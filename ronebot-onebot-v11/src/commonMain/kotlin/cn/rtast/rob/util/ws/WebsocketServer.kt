/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/8/26
 */


package cn.rtast.rob.util.ws

import cn.rtast.rob.IBotInstance
import cn.rtast.rob.enums.internal.InstanceType
import cn.rtast.rob.onebot.OneBotAction
import cn.rtast.rob.onebot.OneBotListener
import cn.rtast.rob.util.Logger
import cn.rtast.rob.util.MessageHandler
import kotlinx.coroutines.launch
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress
import kotlin.time.Duration

internal class WebsocketServer(
    private val port: Int,
    private val accessToken: String,
    private val listener: OneBotListener,
    private val botInstance: IBotInstance,
    private val path: String,
    private val executeDuration: Duration
) : WebSocketServer(InetSocketAddress(port)) {

    private val logger = Logger.getLogger()
    private lateinit var messageHandler: MessageHandler
    private lateinit var action: OneBotAction

    fun createAction(): OneBotAction {
        this.action = OneBotAction(botInstance, InstanceType.Server)
        this.messageHandler = MessageHandler(botInstance, this.action)
        this.action.setHandler(this.messageHandler)
        return this.action
    }

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        val allHeaderKeys = mutableListOf<String>()
        handshake.iterateHttpFields().forEach { allHeaderKeys.add(it) }
        val queryAccessToken = handshake.resourceDescriptor
            .split("?").getOrNull(1)?.split("&")
            ?.firstOrNull { it.startsWith("access_token=") }
            ?.split("=")?.getOrNull(1)
        val value = handshake.getFieldValue("Authorization")
        if (queryAccessToken != accessToken && value != "Bearer $accessToken") {
            logger.warn("Websocket client's access token is not correct, disconnecting...")
            conn.close(4003, "Forbidden: Invalid or missing Authorization token")
        } else {
            // 如果设置监听的路径为`/`则表示监听所有的路径, 如果设置了其他路径
            // 表示只监听设置的路径, 连接到这个路径之外的路径则会直接关闭连接
            val clientPath = handshake.resourceDescriptor ?: "/"
            if (path == "/" || clientPath == if (path.startsWith("/")) path else "/$path") {
                logger.info("Websocket client successfully authed! (${conn.remoteSocketAddress.address})")
                coroutineScope.launch {
                    messageHandler.onOpen(listener, conn)
                }
            } else {
                logger.warn("Websocket client connected to wrong path: $clientPath | (${conn.remoteSocketAddress.address})")
                conn.close(4000, "Connect $path instead of $clientPath")
            }
        }
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
        coroutineScope.launch {
            messageHandler.onClose(listener, code, reason, remote, conn)
        }
    }

    override fun onMessage(conn: WebSocket, message: String) {
        processIncomingMessage(botInstance, listener, message, executeDuration, messageHandler)
    }

    override fun onError(conn: WebSocket?, ex: Exception) {
        coroutineScope.launch {
            messageHandler.onError(listener, ex)
        }
    }

    override fun onStart() {
        coroutineScope.launch {
            messageHandler.onStart(listener, port)
        }
    }
}
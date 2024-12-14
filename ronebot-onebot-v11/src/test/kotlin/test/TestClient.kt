/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/8/28
 */

package test

import cn.rtast.rob.BotInstance
import cn.rtast.rob.ROneBotFactory
import cn.rtast.rob.entity.GroupMessage
import cn.rtast.rob.entity.custom.ErrorEvent
import cn.rtast.rob.onebot.OneBotListener
import cn.rtast.rob.util.BrigadierCommand
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestClient : OneBotListener {

    override suspend fun onGroupMessage(message: GroupMessage, json: String) {
    }

    override suspend fun onWebsocketErrorEvent(event: ErrorEvent) {
        event.exception.printStackTrace()
    }
}

val commands = listOf(
    EchoCommand(), DelayCommand(), MatchedCommand(),
)

class TestBrigadierCommand : BrigadierCommand() {
    private val scope = CoroutineScope(Dispatchers.IO)
    override fun register(dispatcher: CommandDispatcher<BotInstance>) {
        dispatcher.register(
            LiteralArgumentBuilder.literal<BotInstance>("test")
                .executes { context ->
                    scope.launch {
                        TODO("这里执行挂起函数")
                    }
                    println("executed")
                    0
                })
    }
}

suspend fun main() {
    val client = TestClient()
//    val wsAddress = "ws://127.0.0.1:4646"
    val wsAddress = System.getenv("WS_ADDRESS")
    val wsAccessToken = System.getenv("WS_ACCESS_TOKEN")
    val instance1 = ROneBotFactory.createClient(wsAddress, wsAccessToken, client)
    ROneBotFactory.brigadierCommandManager.register(TestBrigadierCommand())
}
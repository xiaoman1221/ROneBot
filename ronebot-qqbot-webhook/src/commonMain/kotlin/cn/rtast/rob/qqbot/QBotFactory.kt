/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/11
 */

@file:Suppress("unused")

package cn.rtast.rob.qqbot

import cn.rtast.rob.BotFactory
import cn.rtast.rob.interceptor.ICommandInterceptor
import cn.rtast.rob.qqbot.command.BaseCommand
import cn.rtast.rob.qqbot.command.CommandManagerImpl
import cn.rtast.rob.qqbot.entity.inbound.C2CMessageCreateEvent
import cn.rtast.rob.qqbot.entity.inbound.GroupAtMessageCreateEvent
import cn.rtast.rob.qqbot.qbot.QQBotListener
import cn.rtast.rob.scheduler.GlobalCoroutineScheduler

public object QBotFactory : BotFactory {

    public val commandManager: CommandManagerImpl = CommandManagerImpl()

    internal val botInstances = mutableListOf<BotInstance>()

    /**
     * 全局作用域的指令拦截器, 只能有一个拦截器
     */
    public lateinit var interceptor: ICommandInterceptor<BaseCommand, GroupAtMessageCreateEvent, C2CMessageCreateEvent>

    /**
     * 判断拦截器是否已经初始化
     */
    internal val isInterceptorInitialized get() = ::interceptor.isInitialized

    /**
     * 全局作用域的任务调度器
     */
    public val globalScheduler: GlobalCoroutineScheduler<BotInstance> = GlobalCoroutineScheduler(botInstances)

    /**
     * 创建HTTP服务器 / 只能在QQBot webhook中使用这种方式
     */
    public suspend fun createServer(
        port: Int,
        appId: String,
        clientSecret: String,
        listener: QQBotListener
    ): BotInstance {
        val instance = BotInstance(port, appId, clientSecret, listener).apply { createBot() }
        botInstances.add(instance)
        return instance
    }

    override var totalCommandExecutionTimes: Int = 0
    override var privateCommandExecutionTimes: Int = 0
    override var groupCommandExecutionTimes: Int = 0
}
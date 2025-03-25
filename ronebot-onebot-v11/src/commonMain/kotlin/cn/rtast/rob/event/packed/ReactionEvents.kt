/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/2/27
 */

package cn.rtast.rob.event.packed

import cn.rtast.rob.event.OneBotEvent
import cn.rtast.rob.event.raw.ReactionEvent
import cn.rtast.rob.onebot.OneBotAction

/**
 * 不管是添加回应表情还是移除回应表情
 * 都会被触发
 */
public data class ReactionCommonEvent(
    override val action: OneBotAction,
    val event: ReactionEvent
) : OneBotEvent

/**
 * 消息被回应
 */
public data class ReactionAddEvent(
    override val action: OneBotAction,
    val event: ReactionEvent
) : OneBotEvent

/**
 * 回应被移除
 */
public data class ReactionRemoveEvent(
    override val action: OneBotAction,
    val event: ReactionEvent
) : OneBotEvent
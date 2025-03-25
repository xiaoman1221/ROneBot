/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/2/27
 */

package cn.rtast.rob.event.packed

import cn.rtast.rob.event.OneBotEvent
import cn.rtast.rob.event.raw.custom.RawBotBeKickEvent
import cn.rtast.rob.event.raw.custom.RawMemberKickEvent
import cn.rtast.rob.onebot.OneBotAction

/**
 * 成员被踢出群聊
 */
public data class MemberKickEvent(
    override val action: OneBotAction,
    val event: RawMemberKickEvent
) : OneBotEvent

/**
 * Bot被踢出群聊
 */
public data class BotBeKickEvent(
    override val action: OneBotAction,
    val event: RawBotBeKickEvent
) : OneBotEvent
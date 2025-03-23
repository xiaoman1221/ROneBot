/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/15
 */


package cn.rtast.rob.qqbot.entity.inbound

import cn.rtast.rob.qqbot.entity.inbound.GroupAtMessageCreateEvent.Author
import cn.rtast.rob.qqbot.qbot.QQBotAction

public data class FriendAddEvent(
    val id: String,
    val d: AddEvent,
) {
    public data class AddEvent(
        @Transient
        var action: QQBotAction,
        val timestamp: String,
        val openid: String,
        val author: Author,
    )
}
/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/19
 */


package cn.rtast.rob.qqbot.entity.inbound

import cn.rtast.rob.qqbot.qbot.QQBotAction
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
public data class FriendDelEvent(
    val id: String,
    val d: DeleteEvent
) {
    @Serializable
    public data class DeleteEvent(
        val timestamp: String,
        @SerialName("openid")
        val openId: String,
        val author: Author,
    ) {
        @Transient
        lateinit var action: QQBotAction
    }

    @Serializable
    public data class Author(
        @SerialName("union_openid")
        val unionOpenId: String,
    )
}
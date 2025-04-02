/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/3
 */


package cn.rtast.rob.event.raw.lagrange

import cn.rtast.rob.event.raw.message.GroupMessage
import cn.rtast.rob.event.raw.message.PrivateMessage
import kotlinx.serialization.Serializable

@Serializable
public data class GroupMessageHistory(
    val data: MessageHistory
) {
    @Serializable
    public data class MessageHistory(
        var messages: List<GroupMessage>
    )
}

@Serializable
public data class PrivateMessageHistory(
    val data: MessageHistory
) {
    @Serializable
    public data class MessageHistory(
        val messages: List<PrivateMessage>
    )
}


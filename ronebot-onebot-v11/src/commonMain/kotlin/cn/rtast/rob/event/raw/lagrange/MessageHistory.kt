/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/3
 */


package cn.rtast.rob.event.raw.lagrange

import cn.rtast.rob.event.raw.GroupMessage
import cn.rtast.rob.event.raw.PrivateMessage

public data class GroupMessageHistory(
    val data: MessageHistory
) {
    public data class MessageHistory(
        var messages: List<GroupMessage>
    )
}

public data class PrivateMessageHistory(
    val data: MessageHistory
) {
    public data class MessageHistory(
        val messages: List<PrivateMessage>
    )
}


/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/3
 */


package cn.rtast.rob.api.get

import com.google.gson.annotations.SerializedName
import java.util.*

internal data class GetGroupMessageHistoryApi(
    val action: String = "get_group_msg_history",
    val echo: UUID,
    val params: Params,
) {
    data class Params(
        @SerializedName("group_id")
        val groupId: Long,
        @SerializedName("message_id")
        val messageId: Long,
        val count: Int
    )
}

internal data class GetPrivateMessageHistoryApi(
    val action: String = "get_friend_msg_history",
    val echo: UUID,
    val params: Params,
) {
    data class Params(
        @SerializedName("user_id")
        val userId: Long,
        @SerializedName("message_id")
        val messageId: Long,
        val count: Int
    )
}
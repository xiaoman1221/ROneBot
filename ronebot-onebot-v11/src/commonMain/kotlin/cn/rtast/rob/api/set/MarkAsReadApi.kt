/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/1
 */


package cn.rtast.rob.api.set

import com.google.gson.annotations.SerializedName

internal data class MarkAsReadApi(
    val action: String = "mark_msg_as_read",
    val params: Params
) {
    data class Params(
        @SerializedName("message_id")
        val messageId: Long,
    )
}
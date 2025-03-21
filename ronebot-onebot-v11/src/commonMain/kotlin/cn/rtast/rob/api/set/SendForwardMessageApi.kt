/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/9/23
 */


package cn.rtast.rob.api.set

import cn.rtast.rob.segment.InternalBaseSegment
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class SendGroupForwardMsgApi(
    val params: Params,
    val action: String = "send_group_forward_msg",
    val echo: UUID,
) {
    data class Params(
        @SerializedName("group_id")
        val groupId: Long,
        val messages: List<InternalBaseSegment>
    )
}

internal data class SendPrivateForwardMsgApi(
    val params: Params,
    val action: String = "send_private_forward_msg",
    val echo: UUID
) {
    data class Params(
        @SerializedName("user_id")
        val userId: Long,
        val messages: List<InternalBaseSegment>
    )
}
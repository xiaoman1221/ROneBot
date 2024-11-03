/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/9/23
 */


package cn.rtast.rob.entity.out.lagrange.set

import cn.rtast.rob.segment.Node
import com.google.gson.annotations.SerializedName
import java.util.UUID

internal data class SendGroupForwardMsgOut(
    val params: Params,
    val action: String = "send_group_forward_msg",
    val echo: UUID,
) {
    data class Params(
        @SerializedName("group_id")
        val groupId: Long,
        val messages: List<Node>
    )
}

internal data class SendPrivateForwardMsgOut(
    val params: Params,
    val action: String = "send_private_forward_msg",
    val echo: UUID
) {
    data class Params(
        @SerializedName("user_id")
        val userId: Long,
        val messages: List<Node>
    )
}
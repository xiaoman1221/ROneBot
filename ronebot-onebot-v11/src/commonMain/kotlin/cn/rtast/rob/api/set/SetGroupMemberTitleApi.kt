/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/8/26
 */


package cn.rtast.rob.api.set

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SetGroupMemberTitleApi(
    val action: String = "set_group_special_title",
    val params: Params,
) {
    @Serializable
    data class Params(
        @SerialName("group_id")
        val groupId: Long,
        @SerialName("user_id")
        val userId: Long,
        @SerialName("special_title")
        val specialTitle: String,
        val duration: Int
    )
}
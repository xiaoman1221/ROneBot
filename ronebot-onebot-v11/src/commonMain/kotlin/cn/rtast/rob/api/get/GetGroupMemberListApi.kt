/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/8/27
 */


@file:OptIn(ExperimentalUuidApi::class)

package cn.rtast.rob.api.get

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
internal data class GetGroupMemberListApi(
    val action: String = "get_group_member_list",
    val params: Params,
    val echo: Uuid
) {
    @Serializable
    data class Params(
        @SerialName("group_id")
        val groupId: Long,
    )
}
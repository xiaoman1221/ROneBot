/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/28
 */


@file:OptIn(ExperimentalUuidApi::class)

package cn.rtast.rob.api.get

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
internal data class GetGroupIgnoreAddRequestApi(
    val action: String = "get_group_ignore_add_request",
    val echo: Uuid
)
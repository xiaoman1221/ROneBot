/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/3
 */


package cn.rtast.rob.api.set

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * 删除群精华消息
 */
internal data class DeleteEssenceMessageApi(
    val action: String = "delete_essence_msg",
    val params: Params
) {
    data class Params(
        @SerializedName("message_id")
        val messageId: Long
    )
}

/**
 * 设置群精华消息
 */
internal data class SetEssenceMessageApi(
    val action: String = "set_essence_msg",
    val params: Params
) {
    data class Params(
        @SerializedName("message_id")
        val messageId: Long,
    )
}

/**
 * 获取群精华消息
 */
internal data class GetEssenceMessageListApi(
    val action: String = "get_essence_msg_list",
    val echo: UUID,
    val params: Params
) {
    data class Params(
        @SerializedName("group_id")
        val groupId: Long,
    )
}


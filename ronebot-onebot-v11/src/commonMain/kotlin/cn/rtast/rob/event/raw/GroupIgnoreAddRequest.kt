/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/28
 */


package cn.rtast.rob.event.raw

import com.google.gson.annotations.SerializedName

/**
 * 已过滤的加群请求
 */
public data class GroupIgnoreAddRequest(
    val data: List<Request>
) {
    public data class Request(
        /**
         * 群号
         */
        @SerializedName("group_id")
        val groupId: Long,
        /**
         * 用户QQ号
         */
        @SerializedName("user_id")
        val userId: Long,
        /**
         * flag作为本次请求的ID
         */
        val flag: String
    )
}
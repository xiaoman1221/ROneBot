/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/8/26
 */


package cn.rtast.rob.api.set

import com.google.gson.annotations.SerializedName

internal data class SendLikeApi(
    val action: String = "send_like",
    val params: Params,
) {
    data class Params(
        @SerializedName("user_id")
        val userId: Long,
        val times: Int,
    )
}
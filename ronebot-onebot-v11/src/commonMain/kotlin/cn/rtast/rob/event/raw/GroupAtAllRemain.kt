/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/28
 */


package cn.rtast.rob.event.raw

import com.google.gson.annotations.SerializedName

/**
 * 群聊剩余@全体成员次数
 */
public data class GroupAtAllRemain(
    val data: AtAllRemain
) {
    public data class AtAllRemain(
        /**
         * 是否可以 @全体成员
         */
        @SerializedName("can_at_all")
        val canAtAll: Boolean,
        /**
         * 群内所有管理当天剩余 @全体成员 次数
         */
        @SerializedName("remain_at_all_count_for_group")
        val groupRemainCount: Int,
        /**
         * Bot 当天剩余 @全体成员 次数
         */
        @SerializedName("remain_at_all_count_for_uin")
        val botRemainCount: Int,
    )
}
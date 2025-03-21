/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/14
 */


package cn.rtast.rob.event.raw

import com.google.gson.annotations.SerializedName

/**
 * 资料卡点赞
 */
public data class GetProfileLike(
    val data: ProfileLike
) {
    public data class ProfileLike(
        /**
         * 总点赞数量
         */
        @SerializedName("total_count")
        val totalCount: Long,
        /**
         * 新加的点赞数量
         */
        @SerializedName("new_count")
        val newCount: Long,
        /**
         * 新的附近的人给你点赞的数量
         */
        @SerializedName("new_nearby_count")
        val newNearbyCount: Long,
        /**
         * 上次点赞时间
         */
        @SerializedName("last_visit_time")
        val lastVisitTime: Long,
        /**
         * 点赞的人的信息
         */
        val userInfos: List<UserInfo>
    )

    public data class UserInfo(
        /**
         * 内部ID
         */
        val uid: String,
        /**
         * 暂时不知道是啥
         */
        val src: Int,
        /**
         * 上次点赞时间
         */
        val latestTime: Long,
        /**
         * 点赞数
         */
        val count: Long,
        /**
         * 暂时不知道是啥
         */
        val customId: Long,
        /**
         * 暂时不知道是啥
         */
        val lastCharged: Long,
        /**
         * 今天还剩多少点赞数
         */
        val bAvailableCnt: Long,
        /**
         * 今天点赞数
         */
        val bTodayVotedCnt: Long,
        /**
         * 昵称
         */
        val nick: String,
        /**
         * 性别
         */
        val gender: Int,
        /**
         * 年龄
         */
        val age: Int,
        /**
         * 是否为好友
         */
        val isFriend: Boolean,
        /**
         * 是否为普通会员
         */
        @SerializedName("isvip")
        val isVip: Boolean,
        /**
         * 是否为超级会员
         */
        @SerializedName("isSvip")
        val isSVip: Boolean,
        /**
         * 内部ID
         */
        val uin: Long,
    )
}
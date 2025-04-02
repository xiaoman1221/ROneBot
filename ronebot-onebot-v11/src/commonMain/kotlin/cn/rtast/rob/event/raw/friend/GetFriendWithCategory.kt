/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/24
 */


package cn.rtast.rob.event.raw.friend

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 获取分类后的好友列表
 */
@Serializable
public data class GetFriendWithCategory(
    val data: List<FriendCategory>,
) {
    @Serializable
    public data class FriendCategory(
        /**
         * 该类别下的好友
         */
        val buddyList: List<Buddy>,
        /**
         * 类别ID
         */
        val categoryId: Int,
        /**
         * 类别下好友的数量
         */
        val categoryMbCount: Int,
        /**
         * 类别名
         */
        val categoryName: String,
        /**
         * 类别排序ID
         */
        val categorySortId: Int,
        /**
         * 在线数量
         */
        val onlineCount: Int
    )

    @Serializable
    public data class Buddy(
        /**
         * 年龄
         */
        val age: Int,
        /**
         * 生日: 日
         */
        @SerialName("birthday_day")
        val birthdayDay: Int,
        /**
         * 生日: 月
         */
        @SerialName("birthday_month")
        val birthdayMonth: Int,
        /**
         * 生日: 年
         */
        @SerialName("birthday_year")
        val birthdayYear: Int,
        /**
         * 类别ID
         */
        val categoryId: Int,
        /**
         * 邮件地址
         */
        val eMail: String,
        /**
         * 等级
         */
        val level: Int,
        /**
         * 长昵称
         */
        val longNick: String,
        /**
         * 昵称
         */
        val nickname: String,
        /**
         * qid
         */
        val qid: String,
        /**
         * 备注
         */
        val remark: String,
        /**
         * 暂时不知道是啥
         */
        val richTime: Int,
        /**
         * 性别
         */
        val sex: String,
        /**
         * 内部ID
         */
        val uid: String,
        /**
         * 内部ID
         */
        val uin: String,
        /**
         * QQ号
         */
        @SerialName("user_id")
        val userId: Long
    )
}
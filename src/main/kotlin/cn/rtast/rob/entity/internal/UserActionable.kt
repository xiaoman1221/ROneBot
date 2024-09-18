/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/9/18
 */


package cn.rtast.rob.entity.internal

import cn.rtast.rob.exceptions.IllegalDurationException
import cn.rtast.rob.exceptions.IllegalLikeTimesException
import cn.rtast.rob.util.ob.MessageChain


interface UserActionable {

    /**
     * 赞用户的名片
     */
    suspend fun sendLike(times: Int) {
        if (times !in 1..10) {
            throw IllegalLikeTimesException("Like times must in 1 ~ 10 >>> $times")
        }
    }

    /**
     * 发送纯文本消息
     */
    suspend fun sendMessage(content: String)

    /**
     * 发送数组消息链消息
     */
    suspend fun sendMessage(content: MessageChain)
}

interface GroupUserActionable : UserActionable {

    /**
     * 将用户踢出群聊可以设置是否拒绝加群请求
     */
    suspend fun kick(rejectJoinRequest: Boolean)

    /**
     * 带有默认值的踢出群员(允许加群请求)
     */
    suspend fun kick() {
        this.kick(false)
    }

    /**
     * 设置群员禁言,时长单位为秒(s)
     */
    suspend fun ban(duration: Int) {
        if (duration <= 0) {
            throw IllegalDurationException("Duration must great than 0(>0) >>> $duration")
        }
    }

    /**
     * 带有默认值的禁言(30分钟 30 * 60s)
     */
    suspend fun ban() {
        this.ban(30 * 60)
    }

    /**
     * 设置群员的群昵称
     */
    suspend fun setGroupCard(card: String?)

    /**
     * 设置群员管理员, enable为true则为设置为false则取消设置
     */
    suspend fun setGroupAdmin(enable: Boolean)
}

/**
 * 私聊消息的可执行操作
 */
interface PrivateUserActionable : UserActionable
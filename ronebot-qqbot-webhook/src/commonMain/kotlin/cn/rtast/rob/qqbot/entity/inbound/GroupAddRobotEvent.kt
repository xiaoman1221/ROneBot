/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/19
 */


package cn.rtast.rob.qqbot.entity.inbound

import cn.rtast.rob.qqbot.qbot.QQBotAction
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
public data class GroupAddRobotEvent(
    val id: String,
    val d: AddRobotEvent
) {
    @Serializable
    public data class AddRobotEvent(

        val timestamp: String,
        @SerialName("group_openid")
        val groupOpenId: String,
        @SerialName("op_member_openid")
        val opMemberOpenId: String,
    ) {
        @Transient
        lateinit var action: QQBotAction
    }
}
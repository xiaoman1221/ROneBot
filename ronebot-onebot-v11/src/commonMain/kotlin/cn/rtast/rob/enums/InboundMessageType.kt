/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/8/26
 */

@file:Suppress("EnumEntryName", "unused")

package cn.rtast.rob.enums

import kotlinx.serialization.Serializable

/**
 * 消息类别
 */
@Serializable
public enum class InboundMessageType {
    private, group
}

/**
 * 为了兼容旧版本的sdk而创建的类型别名
 */
public typealias MessageType = InboundMessageType
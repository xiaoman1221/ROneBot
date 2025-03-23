/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/8/26
 */

@file:Suppress("EnumEntryName")

package cn.rtast.rob.enums.internal

import kotlinx.serialization.Serializable

/**
 * 两种元事件数据类型
 */
@Serializable
internal enum class MetaEventType {
    heartbeat, lifecycle
}
/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/9/1
 */

@file:Suppress("EnumEntryName")

package cn.rtast.rob.enums.internal

import kotlinx.serialization.Serializable

/**
 * 通知类型
 */
@Serializable
internal enum class NoticeType {
    group_recall, friend_recall,
    group_upload, offline_file,
    reaction, group_name_change,
    bot_offline, bot_online
}
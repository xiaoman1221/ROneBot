/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/16
 */


package cn.rtast.rob.qqbot.api

import cn.rtast.rob.qqbot.enums.MsgType
import cn.rtast.rob.qqbot.segment.Keyboard
import cn.rtast.rob.qqbot.segment.Markdown
import com.google.gson.annotations.SerializedName

internal data class SendPlainTextMessage(
    val content: String,
    @SerializedName("event_id")
    val eventId: String,
    @SerializedName("msg_id")
    val msgId: String,
    @SerializedName("msg_seq")
    val msgSeq: Int,
    @SerializedName("msg_type")
    val msgType: Int = MsgType.PlainText.type,
)

internal data class SendMarkdownMessage(
    val content: Markdown,
    @SerializedName("event_id")
    val eventId: String,
    @SerializedName("msg_id")
    val msgId: String,
    @SerializedName("msg_seq")
    val msgSeq: Int,
    @SerializedName("msg_type")
    val msgType: Int = MsgType.Markdown.type,
)

internal data class SendKeyboardMessage(
    val content: Keyboard,
    @SerializedName("event_id")
    val eventId: String,
    @SerializedName("msg_id")
    val msgId: String,
    @SerializedName("msg_seq")
    val msgSeq: Int,
    @SerializedName("msg_type")
    val msgType: Int = MsgType.Markdown.type,
)
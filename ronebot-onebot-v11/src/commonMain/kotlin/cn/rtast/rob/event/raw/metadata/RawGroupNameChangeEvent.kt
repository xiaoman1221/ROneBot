/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/31
 */


package cn.rtast.rob.event.raw.metadata

import cn.rtast.rob.annotations.ExcludeField
import cn.rtast.rob.onebot.OneBotAction
import com.google.gson.annotations.SerializedName


public data class RawGroupNameChangeEvent(
    @ExcludeField
    var action: OneBotAction,
    /**
     * 群号
     */
    val groupId: Long,
    /**
     * BotQQ号
     */
    @SerializedName("self_id")
    val selfId: Long,
    /**
     * 新的群名字
     */
    val name: String,
)
/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/2
 */


package cn.rtast.rob.event.raw.custom

import cn.rtast.rob.annotations.ExcludeField
import cn.rtast.rob.onebot.OneBotAction

public data class RawBotOnlineEvent(
    @ExcludeField
    var action: OneBotAction,
    val reason: String
)

public data class RawBotOfflineEvent(
    @ExcludeField
    var action: OneBotAction,
    val tag: String,
    val message: String
)
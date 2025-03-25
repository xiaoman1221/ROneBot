/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/2/27
 */

package cn.rtast.rob.event.packed

import cn.rtast.rob.event.OneBotEvent
import cn.rtast.rob.event.raw.metadata.RawGroupNameChangeEvent
import cn.rtast.rob.onebot.OneBotAction

/**
 * 群名字变更
 */
public data class GroupNameChangedEvent(
    override val action: OneBotAction,
    val event: RawGroupNameChangeEvent
) : OneBotEvent
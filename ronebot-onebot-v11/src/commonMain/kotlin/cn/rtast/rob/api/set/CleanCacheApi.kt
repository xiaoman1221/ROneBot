/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/10/19
 */


package cn.rtast.rob.api.set

import kotlinx.serialization.Serializable

@Serializable
internal data class CleanCacheApi(val action: String = "clean_cache")
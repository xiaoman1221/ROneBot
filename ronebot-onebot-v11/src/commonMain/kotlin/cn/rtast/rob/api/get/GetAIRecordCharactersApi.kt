/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/3
 */


package cn.rtast.rob.api.get

import com.google.gson.annotations.SerializedName
import java.util.*

internal data class GetAIRecordCharactersApi(
    val action: String = "get_ai_characters",
    val params: Params,
    val echo: UUID
) {
    data class Params(
        @SerializedName("group_id")
        val groupId: Long,
        @SerializedName("chat_type")
        val chatType: UInt,
    )
}

public data class AIRecordCharacters(
    val data: List<AICharacters>
) {
    public data class AICharacters(
        val type: String,
        val characters: List<Character>
    )

    public data class Character(
        @SerializedName("character_id")
        val characterId: String,
        @SerializedName("character_name")
        val characterName: String,
        @SerializedName("preview_url")
        val previewUrl: String,
    )
}
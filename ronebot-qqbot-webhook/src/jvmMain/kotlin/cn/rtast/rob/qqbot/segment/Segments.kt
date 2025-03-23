/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/11/16
 */


package cn.rtast.rob.qqbot.segment

import com.google.gson.annotations.SerializedName

public data class Markdown(val content: String)

public data class Keyboard(val content: List<Row>) {
    public data class Row(val buttons: List<Button>)
    public data class Button(
        val id: String,
        @SerializedName("render_data")
        val renderData: RenderData,
        val action: Action,
    )

    public data class RenderData(
        val label: String,
        @SerializedName("visited_label")
        val visitedLabel: String,
        val style: Int
    )

    public data class Action(
        val type: String,
        val permission: Permission,
        val data: String,
        val reply: Boolean,
        val enter: Boolean,
        val anchor: Int,
        @SerializedName("unsupport_tips")
        val unsupportedTips: String,
    )

    public data class Permission(
        val type: Int,
        @SerializedName("specify_user_ids")
        val specifyUserIds: List<Long>,
        @SerializedName("specify_role_ids")
        val specifyRoleIds: List<Long>,
    )
}
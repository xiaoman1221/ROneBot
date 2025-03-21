/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/12/14
 */

@file:Suppress("unused")


package cn.rtast.rob.command

import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder

public abstract class BrigadierCommand : IBrigadierCommand<CommandSource>

public object Commands {
    public fun literal(literal: String): LiteralArgumentBuilder<CommandSource> {
        return LiteralArgumentBuilder.literal<CommandSource>(literal)
    }

    public fun <T> argument(name: String, argumentType: ArgumentType<T>): RequiredArgumentBuilder<CommandSource, T> {
        return RequiredArgumentBuilder.argument<CommandSource, T>(name, argumentType)
    }
}
/*
 * Copyright © 2024 RTAkland
 * Author: RTAkland
 * Date: 2024/9/19
 */


package cn.rtast.rob.actionable

import okio.Path

/**
 * 对文件的快速操作
 * 所有API都为阻塞式
 * 但是使用了withContext
 */
public interface FileEventActionable {
    /**
     * 保存到指定的文件
     */
    public suspend fun saveTo(file: Path)

    /**
     * 读取InputStream中的内容并将其转换成ByteArray
     */
    public suspend fun readBytes(): ByteArray
}
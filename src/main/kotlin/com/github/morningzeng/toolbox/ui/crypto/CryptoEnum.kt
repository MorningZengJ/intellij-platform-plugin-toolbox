package com.github.morningzeng.toolbox.ui.crypto

import com.github.morningzeng.toolbox.ui.TabSupport
import com.intellij.openapi.wm.ToolWindow
import javax.swing.Icon
import javax.swing.JComponent

/**
 * @author Morning zeng
 * @since 2025-05-16
 */
enum class CryptoEnum(
    override val title: String,
    override val icon: Icon?,
    override val tips: String
) : TabSupport {
    AES("AES", null, "AES") {
        override fun component(toolWindow: ToolWindow): JComponent = AESComponent(toolWindow.project)
    }
}
package com.github.morningzeng.toolbox

import com.intellij.openapi.util.IconLoader
import java.time.format.DateTimeFormatter
import javax.swing.Icon

/**
 * @author Morning Zeng
 * @since 2025-05-16
 */
object Constants {

    object DateTimeFormatterC {
        val YYYY_MM_DD_HH_MM_SS: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val YYYY_MM_DD: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val YYYY_MM: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM")
        val HH_MM_SS: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    }

    object IconC {
        val CLASS_LOADER: ClassLoader = ClassLoader.getSystemClassLoader()
        val BOX: Icon = IconLoader.getIcon("/images/svg/box.svg", CLASS_LOADER)
        val FOLDER_COLOR: Icon = IconLoader.getIcon("/images/svg/folder_color.svg", CLASS_LOADER)
        val TREE_NODE: Icon = IconLoader.getIcon("/images/svg/tree_node.svg", CLASS_LOADER)
    }
}
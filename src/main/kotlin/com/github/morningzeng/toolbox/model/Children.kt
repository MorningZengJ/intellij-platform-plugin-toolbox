package com.github.morningzeng.toolbox.model

import com.github.morningzeng.toolbox.Constants.IconC
import javax.swing.Icon

/**
 * @author Morning Zeng
 * @since 2025-05-19
 */
abstract class Children<T : Children<T>>(
    open var children: MutableList<T> = mutableListOf(),
    open var parent: T? = null,
    open var sorted: Int = 0,
    open var directory: Boolean = false,
) {
    companion object {
        fun <T : Children<T>> comparable(): Comparator<T?> =
            Comparator.comparing<T, Int> { it.sorted }.thenComparing { it.name() }
    }

    fun addChild(child: T) {
        @Suppress("UNCHECKED_CAST")
        child.parent = this as T
        children.add(child)
    }

    abstract fun name(): String

    fun icon(): Icon {
        return if (directory) IconC.FOLDER_COLOR else IconC.TREE_NODE
    }
}

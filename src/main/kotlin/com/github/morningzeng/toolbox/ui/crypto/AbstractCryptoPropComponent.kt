package com.github.morningzeng.toolbox.ui.crypto

import com.fasterxml.jackson.core.type.TypeReference
import com.github.morningzeng.toolbox.Constants.IconC
import com.github.morningzeng.toolbox.annotations.ScratchConfig
import com.github.morningzeng.toolbox.model.CryptoSymmetric
import com.github.morningzeng.toolbox.utils.ScratchFileUtils
import com.intellij.icons.AllIcons.General
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.Messages
import com.intellij.ui.components.JBBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBPanelWithEmptyText
import java.util.function.Predicate
import java.util.stream.Stream
import javax.swing.*

/**
 * @author Morning Zeng
 * @since 2025-05-16
 */
sealed class AbstractCryptoPropComponent<T>(protected open val project: Project) : JBPanel<JBPanelWithEmptyText>() {

    protected val cryptoPropComboBox: ComboBox<T> = ComboBox<T>()
    protected val cryptoManageBtn: JButton = JButton(General.Ellipsis)

    init {
        this.reloadCryptoProps()
        this.setCryptoPropRenderer()
    }

    protected abstract fun typeReference(): TypeReference<MutableList<T>>

    protected abstract fun cryptoPropText(t: T): String

    protected abstract fun isDirectory(t: T): Boolean

    protected abstract fun initLayout()

    protected abstract fun initAction()

    protected abstract fun flatProps(props: MutableList<T>?): Stream<T>

    protected fun filterProp(): Predicate<T> = Predicate { prop: T -> true }

    protected fun setCryptoPropRenderer() {
        this.cryptoPropComboBox.renderer = ListCellRenderer { list, value, index, isSelected, cellHasFocus ->
            val box = JBBox(BoxLayout.X_AXIS)
            value?.let {
                val directory = this.isDirectory(value)
                val component = this.propComponent(value)
                if (index == -1) {
                    return@ListCellRenderer component
                }
                if (!directory && !isSelected) {
                    box.add(JBBox.createHorizontalStrut(10))
                }
                box.add(component)
            }
            return@ListCellRenderer box
        }
    }

    protected fun propComponent(prop: T): JComponent {
        val icon = if (this.isDirectory(prop)) IconC.FOLDER_COLOR else IconC.TREE_NODE
        return JBLabel(this.cryptoPropText(prop), icon, SwingConstants.LEFT)
    }

    protected fun reloadCryptoProps() {
        try {
            ScratchFileUtils.read(this.typeReference())?.let {
                this.reloadCryptoProps(it)
            }
        } catch (e: Exception) {
            Messages.showErrorDialog(e.message, "Configuration File Is Incorrect")
            val config: ScratchConfig = CryptoSymmetric::class.java.getAnnotation(ScratchConfig::class.java)
            ScratchFileUtils.open(project, config.directory, config.outputType.fullName(config.value))
        }
    }

    protected fun reloadCryptoProps(props: MutableList<T>) {
        this.cryptoPropComboBox.removeAllItems()
        this.flatProps(props).filter(this.filterProp()).forEach {
            this.cryptoPropComboBox.addItem(it)
        }
    }

}
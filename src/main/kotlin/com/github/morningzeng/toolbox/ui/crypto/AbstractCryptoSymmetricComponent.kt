package com.github.morningzeng.toolbox.ui.crypto

import com.fasterxml.jackson.core.type.TypeReference
import com.github.morningzeng.toolbox.Constants.IconC
import com.github.morningzeng.toolbox.model.CryptoSymmetric
import com.github.morningzeng.toolbox.ui.dialog.PropertySymmetricDialog
import com.github.morningzeng.toolbox.utils.GridBagUtils
import com.github.morningzeng.toolbox.utils.HumanUtils.maskSensitive
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import javax.swing.JButton

/**
 * @author Morning Zeng
 * @since 2025-05-19
 */
abstract class AbstractCryptoSymmetricComponent(
    project: Project
) : AbstractCryptoComponent<CryptoSymmetric>(project) {
    private val encryptBtn: JButton = JButton("Encrypt", IconC.DOUBLE_ANGLES_DOWN)
    private val decryptBtn: JButton = JButton("Decrypt", IconC.DOUBLE_ANGLES_UP)

    override fun typeReference(): TypeReference<MutableList<CryptoSymmetric>> {
        return object : TypeReference<MutableList<CryptoSymmetric>>() {
        }
    }

    override fun cryptoPropText(t: CryptoSymmetric): String {
        if (t.directory) return t.title
        return "${t.title} - ${t.description} ( ${t.key.maskSensitive()} / ${t.iv.maskSensitive()} )"
    }

    override fun isDirectory(t: CryptoSymmetric): Boolean = t.directory

    override fun initLayout() {
        GridBagUtils.builder(this)
            .row {
                it.fill(GridBagUtils.GridBagFill.HORIZONTAL)
                    .cell().weightX(1.0).add(cryptoPropComboBox)
                    .cell().weightX(0.0).add(cryptoManageBtn)
                cryptoRow(it)
            }
            .row {
                it.fill(GridBagUtils.GridBagFill.BOTH)
                    .cell().weightY(1.0).gridWidth(3).add(decryptArea.withRightBar())
            }
            .row {
                GridBagUtils.builder()
                    .row {
                        it.fill(GridBagUtils.GridBagFill.HORIZONTAL)
                            .cell().add(encryptBtn)
                            .cell().add(decryptBtn)
                    }
                    .build().apply {
                        it.fill(GridBagUtils.GridBagFill.HORIZONTAL)
                            .cell().weightY(0.0).gridWidth(3).add(this)
                    }
            }
            .row {
                it.fill(GridBagUtils.GridBagFill.BOTH)
                    .cell().weightY(1.0).gridWidth(3).add(encryptArea.withRightBar())
            }
    }

    override fun initAction() {
        encryptBtn.addActionListener {
            try {
                val item = this.cryptoPropComboBox.item
                item?.let {
                    if (item.directory || item.key.isBlank() || item.iv.isBlank()) {
                        Messages.showErrorDialog(this, "Please select the correct crypto item")
                        return@addActionListener
                    }
                    this.encryptArea.text = encrypt(item)
                }
            } catch (e: Exception) {
                Messages.showErrorDialog(this, e.message)
            }
        }
        decryptBtn.addActionListener {
            try {
                val item = this.cryptoPropComboBox.item
                item?.let {
                    if (item.directory || item.key.isBlank() || item.iv.isBlank()) {
                        Messages.showErrorDialog(this, "Please select the correct crypto item")
                        return@addActionListener
                    }
                    this.decryptArea.text = decrypt(item)
                }
            } catch (e: Exception) {
                Messages.showErrorDialog(this, e.message)
            }
        }
        this.cryptoManageBtn.addActionListener {
            PropertySymmetricDialog(project, okAfter = {
                this.reloadCryptoProps()
            }, selectedAfter = {
                this.cryptoPropComboBox.selectedItem = it
            }).showAndGet()
        }
    }

    abstract fun cryptoRow(row: GridBagUtils.Row<AbstractCryptoSymmetricComponent>)

    abstract fun encrypt(prop: CryptoSymmetric): String

    abstract fun decrypt(prop: CryptoSymmetric): String

}
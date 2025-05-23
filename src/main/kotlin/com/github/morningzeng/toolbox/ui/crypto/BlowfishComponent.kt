package com.github.morningzeng.toolbox.ui.crypto

import com.intellij.openapi.project.Project

/**
 * @author Morning Zeng
 * @since 2025-05-22
 */
class BlowfishComponent(
    project: Project
) : AbstractInternationalCryptoSymmetricComponent(project) {
    override fun getType(): String = "Blowfish"
}
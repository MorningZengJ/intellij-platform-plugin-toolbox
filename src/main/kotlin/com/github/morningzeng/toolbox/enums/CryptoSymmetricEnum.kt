package com.github.morningzeng.toolbox.enums

import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * @author Morning Zeng
 * @since 2025-05-20
 */
enum class CryptoSymmetricEnum(
    val type: String,
    val algorithm: String,
) {
    DES("DES", "DES") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            return cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType).let {
                val bytes = it.doFinal(data.toByteArray(StandardCharsets.UTF_8))
                Base64.getEncoder().encodeToString(bytes)
            }
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            return cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType).let {
                val bytes = Base64.getDecoder().decode(data)
                String(it.doFinal(bytes))
            }
        }
    },
    DES_CBC_PKCS5("DES", "DES/CBC/PKCS5Padding") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    DES_EDE("DES", "DESede") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    AES_ECB_PKCS5("AES", "AES/ECB/PKCS5Padding") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    AES_ECB_NO_PADDING("AES", "AES/ECB/NoPadding") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    AES_CBC_PKCS5("AES", "AES/CBC/PKCS5Padding") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    AES_CFB_NO_PADDING("AES", "AES/CFB/NoPadding") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    AES_OFB_NO_PADDING("AES", "AES/OFB/NoPadding") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    AES_CTR_NO_PADDING("AES", "AES/CTR/NoPadding") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },
    BLOWFISH("Blowfish", "Blowfish") {
        override fun encrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val cipher = this.cipher(Cipher.ENCRYPT_MODE, key, keyType, iv, ivType)
            val encryptedValue = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedValue)
        }

        override fun decrypt(
            data: String,
            key: String,
            keyType: DataToBinaryTypeEnum,
            iv: String?,
            ivType: DataToBinaryTypeEnum?
        ): String {
            val decodedValue = Base64.getDecoder().decode(data)
            val cipher = this.cipher(Cipher.DECRYPT_MODE, key, keyType, iv, ivType)
            val decryptedValue = cipher.doFinal(decodedValue)
            return String(decryptedValue, StandardCharsets.UTF_8)
        }
    },

    ;

    fun cipher(
        encryptMode: Int,
        key: String,
        keyType: DataToBinaryTypeEnum,
        iv: String?,
        ivType: DataToBinaryTypeEnum?
    ): Cipher {
        return Cipher.getInstance(algorithm).apply {
            if (iv?.isEmpty() == true) {
                init(encryptMode, SecretKeySpec(keyType.bytes(key), type))
            } else {
                init(
                    encryptMode,
                    SecretKeySpec(keyType.bytes(key), type),
                    IvParameterSpec(ivType?.bytes(iv!!))
                )
            }
        }
    }

    fun encrypt(
        data: String, key: String, iv: String?,
    ): String = encrypt(data, key, DataToBinaryTypeEnum.TEXT, iv, DataToBinaryTypeEnum.TEXT)

    abstract fun encrypt(
        data: String,
        key: String,
        keyType: DataToBinaryTypeEnum,
        iv: String?,
        ivType: DataToBinaryTypeEnum?
    ): String

    fun decrypt(
        data: String, key: String, iv: String?
    ): String = decrypt(data, key, DataToBinaryTypeEnum.TEXT, iv, DataToBinaryTypeEnum.TEXT)

    abstract fun decrypt(
        data: String,
        key: String,
        keyType: DataToBinaryTypeEnum,
        iv: String?,
        ivType: DataToBinaryTypeEnum?
    ): String

    fun crypto(key: String): Support = Support.crypto(this, key, null)

    fun crypto(key: String, keyType: DataToBinaryTypeEnum): Support = Support.crypto(this, key, keyType, null, null)

    fun crypto(key: String, iv: String): Support = Support.crypto(this, key, iv)

    fun crypto(
        key: String, keyType: DataToBinaryTypeEnum, iv: String, ivType: DataToBinaryTypeEnum
    ): Support = Support.crypto(this, key, keyType, iv, ivType)

    interface Support {
        companion object {
            fun crypto(crypto: CryptoSymmetricEnum, key: String, iv: String?): Support {
                return object : Support {
                    override fun encrypt(data: String): String = crypto.encrypt(data, key, iv)

                    override fun decrypt(data: String): String = crypto.decrypt(data, key, iv)
                }
            }

            fun crypto(
                crypto: CryptoSymmetricEnum,
                key: String,
                keyType: DataToBinaryTypeEnum,
                iv: String?,
                ivType: DataToBinaryTypeEnum?
            ): Support {
                return object : Support {
                    override fun encrypt(data: String): String = crypto.encrypt(data, key, keyType, iv, ivType)

                    override fun decrypt(data: String): String = crypto.decrypt(data, key, keyType, iv, ivType)
                }
            }
        }

        fun encrypt(data: String): String

        fun decrypt(data: String): String

    }

}
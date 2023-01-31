package com.example.composelearning.utils

import android.util.Base64
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object AppConfig {

    fun encrypt(plaintext: String, passphrase: String): String {
        if (plaintext != null && plaintext.isNotEmpty() && passphrase != null && passphrase.isNotEmpty()) {
            try {
                val keySize = 256
                val ivSize = 128
                val key = ByteArray(keySize / 8)
                val iv = ByteArray(ivSize / 8)
                val saltBytes = generateSalt(8)
                EvpKDF(passphrase.toByteArray(Charsets.UTF_8), keySize, ivSize, saltBytes, key, iv)
                val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
                cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
                val cipherBytes = cipher.doFinal(plaintext.toByteArray(Charsets.UTF_8))
                val sBytes = "Salted__".toByteArray(Charsets.UTF_8)
                val b = ByteArray(sBytes.size + saltBytes.size + cipherBytes.size)
                System.arraycopy(sBytes, 0, b, 0, sBytes.size)
                System.arraycopy(saltBytes, 0, b, sBytes.size, saltBytes.size)
                System.arraycopy(cipherBytes, 0, b, sBytes.size + saltBytes.size, cipherBytes.size)
                val base64b = Base64.encode(b, Base64.DEFAULT)
                var encrypted = String(base64b, Charsets.UTF_8)
                encrypted = encrypted.replace("\n", "")
                encrypted = encrypted.replace("=", "GSON_SPCL_CHR")
                return encrypted
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return ""
    }

    private fun EvpKDF(
        password: ByteArray,
        keySize: Int,
        ivSize: Int,
        salt: ByteArray,
        resultKey: ByteArray,
        resultIv: ByteArray
    ): ByteArray? {
        return EvpKDF(
            password,
            keySize,
            ivSize,
            salt,
            1,
            "MD5",
            resultKey,
            resultIv
        )
    }

    private fun generateSalt(length: Int): ByteArray {
        val r: Random = SecureRandom()
        val salt = ByteArray(length)
        r.nextBytes(salt)
        return salt
    }

    fun decrypt(ciphertext: String, passphrase: String): String {
        if (ciphertext.isNotEmpty() && passphrase.isNotEmpty()) {
            try {
                val keySize = 256
                val ivSize = 128

                // Decode from base64 text
                val ctBytes = Base64.decode(ciphertext.toByteArray(Charsets.UTF_8), Base64.DEFAULT)

                // Get salt
                val saltBytes = ctBytes.copyOfRange(8, 16)

                // Get ciphertext
                val ciphertextBytes = ctBytes.copyOfRange(16, ctBytes.size)

                // Get key and iv from passphrase and salt
                val key = ByteArray(keySize / 8)
                val iv = ByteArray(ivSize / 8)
                EvpKDF(passphrase.toByteArray(Charsets.UTF_8), keySize, ivSize, saltBytes, key, iv)

                // Actual decrypt
                val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
                cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
                val recoveredPlaintextBytes = cipher.doFinal(ciphertextBytes)

                val strIs = recoveredPlaintextBytes.toString(Charsets.UTF_8)
                return strIs
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return ""
    }

    fun EvpKDF(
        password: ByteArray,
        keySize: Int,
        ivSize: Int,
        salt: ByteArray,
        iterations: Int,
        hashAlgorithm: String,
        resultKey: ByteArray,
        resultIv: ByteArray
    ): ByteArray {
        var keySize = keySize / 32
        var ivSize = ivSize / 32
        val targetKeySize = keySize + ivSize
        val derivedBytes = ByteArray(targetKeySize * 4)
        var numberOfDerivedWords = 0
        var block: ByteArray? = null
        val hasher = MessageDigest.getInstance(hashAlgorithm)
        while (numberOfDerivedWords < targetKeySize) {
            if (block != null) {
                hasher.update(block)
            }
            hasher.update(password)
            block = hasher.digest(salt)
            hasher.reset()

            for (i in 1 until iterations) {
                block = block?.let { hasher.digest(it) }
                hasher.reset()
            }

            block?.let {
                System.arraycopy(
                    it, 0, derivedBytes, numberOfDerivedWords * 4,
                    Math.min(block!!.size, (targetKeySize - numberOfDerivedWords) * 4)
                )
            }

            numberOfDerivedWords += block!!.size / 4
        }

        System.arraycopy(derivedBytes, 0, resultKey, 0, keySize * 4)
        System.arraycopy(derivedBytes, keySize * 4, resultIv, 0, ivSize * 4)

        return derivedBytes // key + iv
    }

}
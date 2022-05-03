package com.cavss.aes256

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cavss.aes256.cipher.AESHelper
import com.cavss.aes256.cipher.AndroidKeyStoreProvider
import com.cavss.aes256.cipher.ZygoteInit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ZygoteInit.warmUpJcaProviders()
        AESHelper.keystoreSetting()

        val encryptText = AESHelper.keystoreEncrypt("암호화 할 텍스트".toByteArray(Charsets.UTF_8))
        val decryptText = String(AESHelper.keystoreDecrypt(encryptText)!!, Charsets.UTF_8)
    }
}
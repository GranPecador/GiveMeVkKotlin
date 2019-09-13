package com.example.givemevkkotlin.helpers

import android.app.Application
import com.example.givemevkkotlin.activities.LoginActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        VK.initialize(applicationContext)
    }
}
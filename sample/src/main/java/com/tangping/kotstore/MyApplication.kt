package com.tangping.kotstore

import android.app.Application
import com.tangping.kotstore.support.KotStore

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KotStore.init(this)
    }
}
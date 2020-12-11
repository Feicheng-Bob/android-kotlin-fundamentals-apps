package com.example.android.navigation

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    override fun onHandleIntent(arg0: Intent?) {
        Log.i("ServiceExample", "Intent Service started")
    }
}
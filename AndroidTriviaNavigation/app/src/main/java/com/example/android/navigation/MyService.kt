package com.example.android.navigation

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MyService: Service() {

    private lateinit var job : Job

    override fun onBind(intent: Intent?): IBinder? {
        Log.e("abc", "-- onBind --")
        job = GlobalScope.launch(Dispatchers.IO) {
            if(Looper.getMainLooper() == Looper.myLooper()){
                Log.e("abc", "UI Looper")
            }
            else Log.e("abc", "else Looper")
            for(i in 1..10) {
                Thread.sleep(1000)
                Log.e("Coroutine", i.toString())
            }
        }
        Log.e("abc", "-- onBindreturnUI --")
        return MyBinder()
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("abc", "-- onCreate --")
        if(Looper.getMainLooper() == Looper.myLooper()){
            Log.e("abc", "UI Looper")
        }
        else Log.e("abc", "else Looper")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("abc", "-- onStartCommand --")

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("abc", "-- onDestroy --")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("abc", "-- onUnbind --")
        job.cancel()
        return super.onUnbind(intent)
    }

    inner class MyBinder : Binder() {
        fun getService(): MyService {
            return this@MyService
        }
    }
}
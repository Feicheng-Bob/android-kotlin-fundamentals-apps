/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.app.Activity
import android.content.*
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class TestActivity : Activity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val broadcast_reciever = object : BroadcastReceiver() {

            override fun onReceive(arg0: Context, intent: Intent) {
                val action = intent.action
                if (action == "finish") {
                    finish()
                    Log.i("reciever", "finish!")
                }
            }
        }
        registerReceiver(broadcast_reciever, IntentFilter("finish"))
        Log.i("TestActivity", "onCreate called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TestActivity", "onRestart called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("TestActivity", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TestActivity", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TestActivity", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TestActivity", "onStop called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("TestActivity", "onDestroy called")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("TestActivity", "onSaveInstanceState called")
    }
    override fun onRestoreInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("TestActivity", "onSaveInstanceState called")
    }
}

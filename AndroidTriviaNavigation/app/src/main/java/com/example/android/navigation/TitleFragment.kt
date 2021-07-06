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


import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    private var flag = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
                R.layout.fragment_title,container,false)

        binding.playButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }

        binding.change.setOnClickListener { view : View ->
            val conn = object : ServiceConnection {
                override fun onServiceConnected(className: ComponentName, iBinder: IBinder) {
                    Log.d("mTAG", "ServiceConnection: connected to service.")
                    // We've bound to MyService, cast the IBinder and get MyBinder instance
                }

                override fun onServiceDisconnected(arg0: ComponentName) {
                    Log.d("mTAG", "ServiceConnection: disconnected from service.")
                }
            }
            val intent = Intent(this.activity, MyService::class.java)

            val intentStart : Intent = Intent().setAction("test")
            intentStart.addCategory("android.intent.category.DEFAULT")
            val intentStop = Intent(this.activity, TestActivity::class.java).setAction("finish")
            if(flag == 0) {
                var a = activity?.bindService(intent, conn, Context.BIND_AUTO_CREATE)
                Log.w("a", a.toString())
                startActivity(intentStart)
                Log.w("flag", "0")
                flag = 1
                return@setOnClickListener
            }
            if(flag == 1) {
                activity?.unbindService(conn)
                startActivity(intentStop)
                Log.w("flag", "1")
                flag = 0
                return@setOnClickListener
            }

        }

        setHasOptionsMenu(true)
        Log.i("TitleFragment", "onCreateView called")
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("TitleFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("TitleFragment", "onCreate called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("TitleFragment", "onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("TitleFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TitleFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TitleFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TitleFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("TitleFragment", "onDestroyView called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("TitleFragment", "onDestroy called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("TitleFragment", "onDetach called")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("TitleFragment", "onSaveInstanceState called")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i("TitleFragment", "onViewStateRestored called")
    }
}

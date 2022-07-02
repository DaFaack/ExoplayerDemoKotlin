package com.relsellglobal.exoplayerdemokotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.relsellglobal.exoplayerdemokotlin.databinding.ActivityMainButtonsBinding
import com.relsellglobal.exoplayerdemokotlin.models.Song
import com.relsellglobal.exoplayerdemokotlin.service.SoundService
import com.relsellglobal.exoplayerdemokotlin.ui.HomeListFragment
import com.relsellglobal.exoplayerdemokotlin.viewmodel.SongViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainButtonsBinding

    lateinit var launchIntent : Intent

    @Inject
    lateinit var homeListFragment: HomeListFragment

    lateinit var list : List<Song>

    val songViewModel : SongViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main_buttons)

        supportFragmentManager.beginTransaction().replace(R.id.rvLayout,homeListFragment).commit()

        list = songViewModel.getSongsUrls()

        binding.buttonStop.setOnClickListener{
            stopSongService()
        }


    }

    override fun onPause() {
        super.onPause()
        stopSongService()
    }


    private fun stopSongService() {
        stopService(Intent(this@MainActivity,SoundService::class.java))
    }

    fun fragmentRVClickListener(pos : Int,actionSongService:Int) {
        if(actionSongService == 1) {
            launchIntent = Intent(this@MainActivity, SoundService::class.java)
            launchIntent.putExtra("songUrl", list.get(pos).songUrl)
            startService(launchIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSongService()
    }

}
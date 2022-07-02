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
class Main2Activity : AppCompatActivity() {

    lateinit var binding : ActivityMainButtonsBinding

    lateinit var launchIntent : Intent

    @Inject
    lateinit var homeListFragment: HomeListFragment

    lateinit var list : List<Song>

    val songViewModel : SongViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@Main2Activity,R.layout.activity_main_buttons)

        supportFragmentManager.beginTransaction().replace(R.id.rvLayout,homeListFragment).commit()

        list = songViewModel.getSongsUrls()


//        binding.buttonStart.setOnClickListener{
//            //startActivity(Intent(this@Main2Activity,MainActivity::class.java))
//           startSongService()
//        }

        binding.buttonStop.setOnClickListener{
            //startActivity(Intent(this@Main2Activity,MainActivity::class.java))
            stopSongService()
        }


    }

    override fun onPause() {
        super.onPause()
        stopSongService()
    }

    private fun startSongService() {
        list = songViewModel.getSongsUrls()
        launchIntent = Intent(this@Main2Activity,SoundService::class.java)
        launchIntent.putExtra("songUrl",list.get(1).songUrl)
        startService(launchIntent)
    }

    private fun stopSongService() {
        stopService(Intent(this@Main2Activity,SoundService::class.java))
    }

    fun fragmentRVClickListener(pos : Int,actionSongService:Int) {
        if(actionSongService == 1) {
            launchIntent = Intent(this@Main2Activity, SoundService::class.java)
            launchIntent.putExtra("songUrl", list.get(pos).songUrl)
            startService(launchIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSongService()
    }

}
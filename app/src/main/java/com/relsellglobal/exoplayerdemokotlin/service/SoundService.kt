package com.relsellglobal.exoplayerdemokotlin.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.relsellglobal.exoplayerdemokotlin.repository.SongRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SoundService : Service() {


    @Inject
    lateinit var songRepository: SongRepository

    @Inject
    lateinit var player: ExoPlayer


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            if (intent != null) {
                var songUrl = intent.getStringExtra("songUrl")!!
                addMP3(songUrl)
            }
        } catch (e:Exception) {
            e.printStackTrace()
        }

        return START_STICKY;
    }



    private fun addMP3(songUrl:String) {

//        var list = songRepository.getSongsUrls()

        // Build the media item.
        val mediaItem = MediaItem.fromUri(songUrl)
        // Set the media item to be played.
        player.setMediaItem(mediaItem)
        // Prepare the player.
        player.prepare()

        player.play()

    }





    override fun onDestroy() {
        super.onDestroy()
        player.clearMediaItems()
        player.pause()
    }

}
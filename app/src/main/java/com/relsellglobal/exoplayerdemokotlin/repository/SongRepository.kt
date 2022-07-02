package com.relsellglobal.exoplayerdemokotlin.repository

import com.relsellglobal.exoplayerdemokotlin.models.Song
import javax.inject.Inject

class SongRepository @Inject constructor(){

    fun getSongsUrls(): ArrayList<Song> {
        val list  = ArrayList<Song>()
        list.add(Song("https://samplelib.com/lib/preview/mp3/sample-3s.mp3","Song 0"))
        list.add(Song("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3","Song 1"))
        return list
    }

}
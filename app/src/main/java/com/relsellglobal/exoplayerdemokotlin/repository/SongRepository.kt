package com.relsellglobal.exoplayerdemokotlin.repository

import com.relsellglobal.exoplayerdemokotlin.models.Song
import javax.inject.Inject

class SongRepository @Inject constructor(){

    fun getSongsUrls(): ArrayList<Song> {
        var list  = ArrayList<Song>()
//        list.add("https://file-examples.com/storage/fe2c89b9c062aa5c79ceae8/2017/11/file_example_MP3_2MG.mp3")
        list.add(Song("https://samplelib.com/lib/preview/mp3/sample-3s.mp3","Song 0"))
        list.add(Song("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3","Song 1"))
        return list
    }

}
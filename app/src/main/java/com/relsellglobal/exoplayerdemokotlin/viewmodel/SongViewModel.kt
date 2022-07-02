package com.relsellglobal.exoplayerdemokotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.relsellglobal.exoplayerdemokotlin.models.Song
import com.relsellglobal.exoplayerdemokotlin.repository.SongRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SongViewModel
@Inject constructor(val songRepository: SongRepository) : ViewModel() {

    fun getSongsUrls(): ArrayList<Song> {
        return songRepository.getSongsUrls()
    }
}
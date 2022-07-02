package com.relsellglobal.exoplayerdemokotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.relsellglobal.exoplayerdemokotlin.R
import com.relsellglobal.exoplayerdemokotlin.databinding.FragmentItemListBinding
import com.relsellglobal.exoplayerdemokotlin.viewmodel.SongViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeListFragment @Inject constructor() : Fragment() {
    lateinit var binding : FragmentItemListBinding
    lateinit var myItemRecyclerViewAdapter: MyItemRecyclerViewAdapter

    val songViewModel : SongViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_item_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var list = songViewModel.getSongsUrls()

        myItemRecyclerViewAdapter = MyItemRecyclerViewAdapter(list,this.activity)
        binding.list.layoutManager = LinearLayoutManager(this.activity)

        binding.list.adapter = myItemRecyclerViewAdapter
    }


}
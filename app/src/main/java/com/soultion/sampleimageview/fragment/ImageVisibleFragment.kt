package com.transsoultion.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cheezycode.notesample.ui.note.ImageAdapter
import com.samplesimage.R
import com.samplesimage.databinding.FragmentDashboardBinding
import com.transsoultion.api.ImageListApi

import com.transsoultion.utils.NetWorkResult
import com.transsoultion.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ImageVisibleFragment : Fragment() {
    var string:String="1"
    @Inject lateinit var customerListApi: ImageListApi
    private var _binding: FragmentDashboardBinding?=null
    private val binding get() = _binding!!
    private val customerViewModel by viewModels<NoteViewModel>()
    private lateinit var _adapter: ImageAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_dashboard, container, false)
        _adapter=ImageAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)
        customerViewModel.getCustomer()
        binding.customerlist.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        binding.customerlist.adapter=_adapter

        bindObserver()
    }

    private fun bindObserver() {
        binding.progressAction.isVisible=false
        customerViewModel.customerliveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetWorkResult.Sucess->{
                    val list=it.data!!.toMutableSet()
                    Log.e("ExactData",it.data.toString())
                    _adapter.submitList(it.data)
                }
                is NetWorkResult.Error->{}
                is NetWorkResult.Loading->{
                    binding.progressAction.isVisible=false
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
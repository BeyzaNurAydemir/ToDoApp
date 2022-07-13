package com.beyzanuraydemir.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.beyzanuraydemir.todoapp.R
import com.beyzanuraydemir.todoapp.databinding.FragmentKayitBinding
import com.beyzanuraydemir.todoapp.ui.viewmodel.KayitFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var tasarim : FragmentKayitBinding
    private lateinit var viewModel : KayitFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit,container,false)
        tasarim.kayitFragment = this
        tasarim.isKayitToolbarBaslik = "Yapılacak İş Kayıt"
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydetTikla(yapilacak_is_ad:String){
        viewModel.kayit(yapilacak_is_ad)
    }
}
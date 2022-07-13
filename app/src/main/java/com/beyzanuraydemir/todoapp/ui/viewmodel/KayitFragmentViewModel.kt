package com.beyzanuraydemir.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.beyzanuraydemir.todoapp.data.repo.IslerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor(var irepo:IslerDaoRepository) : ViewModel() {

    fun kayit(yapilacak_is_ad:String){
        irepo.isKayit(yapilacak_is_ad)
    }
}
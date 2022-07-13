package com.beyzanuraydemir.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.beyzanuraydemir.todoapp.data.repo.IslerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var irepo:IslerDaoRepository) : ViewModel() {

    fun guncelle(yapilacak_id:Int, yapilacak_is:String){
       irepo.isGuncelle(yapilacak_id,yapilacak_is)
    }
}
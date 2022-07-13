package com.beyzanuraydemir.todoapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.beyzanuraydemir.todoapp.data.entity.Isler
import com.beyzanuraydemir.todoapp.room.IslerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IslerDaoRepository(var idao:IslerDao) {
    var islerListesi : MutableLiveData<List<Isler>>

    init {
     islerListesi = MutableLiveData()
    }

    fun isleriGetir() : MutableLiveData<List<Isler>>{
        //viewmodel baglanti fonks.
        return islerListesi
    }

    fun isKayit(yapilacak_is_ad:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniIs = Isler(0,yapilacak_is_ad)
            idao.isEkle(yeniIs)
        }
    }

    fun isGuncelle(yapilacak_id:Int, yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Isler(yapilacak_id,yapilacak_is)
            idao.isGuncelle(guncellenenIs)
        }
    }

    fun isAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = idao.isArama(aramaKelimesi)
        }
    }

    fun isSil(yapilacak_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenIs = Isler(yapilacak_id,"")
            idao.isSil(silinenIs)
            tumIsleriAl()
        }
    }

    fun tumIsleriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = idao.tumIsler()
        }
    }
}
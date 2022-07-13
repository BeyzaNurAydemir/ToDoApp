package com.beyzanuraydemir.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.beyzanuraydemir.todoapp.R
import com.beyzanuraydemir.todoapp.databinding.CardTasarimBinding
import com.beyzanuraydemir.todoapp.data.entity.Isler
import com.beyzanuraydemir.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.beyzanuraydemir.todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.beyzanuraydemir.todoapp.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class IslerAdapter(var mContext:Context,
                   var islerListesi:List<Isler>,
                   var viewModel:AnasayfaFragmentViewModel) : RecyclerView.Adapter<IslerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) :RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val isler = islerListesi.get(position)
        val t = holder.tasarim
        t.isNesnesi = isler

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${isler.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(isler.yapilacak_id)
                }.show()
        }

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(isNesnesi = isler)
            Navigation.gecisYap(it,gecis)
        }

    }

    override fun getItemCount(): Int {
        return islerListesi.size
    }
}
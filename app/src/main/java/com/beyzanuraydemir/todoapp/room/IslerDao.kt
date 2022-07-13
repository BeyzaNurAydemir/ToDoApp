package com.beyzanuraydemir.todoapp.room

import androidx.room.*
import com.beyzanuraydemir.todoapp.data.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumIsler() : List<Isler>

    @Insert
    suspend fun isEkle(isler:Isler)

    @Update
    suspend fun isGuncelle(isler:Isler)

    @Delete
    suspend fun isSil(isler:Isler)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%' ")
    suspend fun isArama(aramaKelimesi:String) : List<Isler>
}
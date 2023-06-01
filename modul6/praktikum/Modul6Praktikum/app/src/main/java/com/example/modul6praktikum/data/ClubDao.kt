package com.example.modul6praktikum.data

import androidx.room.*

@Dao
interface ClubDao {

    // Mengambil semua data
    @Query("SELECT * FROM club")
    fun getAll(): List<Club>

    // Mengambil data berdasarkan ID
    @Query("SELECT * FROM club WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Club>

    @Insert
    fun insertAll(vararg clubs: Club)

    @Delete
    fun delete(club : Club)

    @Query("SELECT * FROM club WHERE id= :id")
    fun get(id: Int) : Club

    @Update
    fun update(club: Club)

}
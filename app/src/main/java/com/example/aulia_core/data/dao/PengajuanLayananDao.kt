package com.example.aulia_core.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aulia_core.data.entity.PengajuanLayananEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PengajuanLayananDao {
    @Query("SELECT * FROM pengajuan_layanan ORDER BY createdAt DESC")
    fun getAll(): Flow<List<PengajuanLayananEntity>>

    @Insert
    suspend fun insert(pengajuan: PengajuanLayananEntity)

    @Delete
    suspend fun delete(pengajuan: PengajuanLayananEntity)
}
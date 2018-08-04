package com.example.naveen.roomprac

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
@Dao
interface CurdDao {
    @Insert
    fun insertData(recordBeam: RecordBeam): Long
    @Query("select * from "+RecordBeam.ColumnName.tableName+"")
    fun getAllData(): List<RecordBeam>
}
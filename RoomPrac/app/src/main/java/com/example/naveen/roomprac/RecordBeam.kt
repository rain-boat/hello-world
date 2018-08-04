package com.example.naveen.roomprac

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RecordBeam.ColumnName.tableName)
data class RecordBeam(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,
        @ColumnInfo(name = ColumnName.name)
        var name: String = "",
        @ColumnInfo(name = ColumnName.otherInfo)
        var otherInfo: String =""
) {
    object ColumnName {
        const val name: String = "NAME"
        const val otherInfo: String = "OTHER_INFO"
        const val tableName: String = "Record"
    }
}
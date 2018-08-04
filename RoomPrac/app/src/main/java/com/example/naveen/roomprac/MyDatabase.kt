package com.example.naveen.roomprac

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

//entities = arrayOf(Subject::class, Topic::class),
@Database(
        entities = arrayOf(RecordBeam::class),
        version = 1
)
abstract class MyDatabase: RoomDatabase() {
    abstract fun curdDao(): CurdDao
    companion object : SingletonHolder<MyDatabase, Context>({
        Room.databaseBuilder(it.applicationContext,
                MyDatabase::class.java, "Sample.db")
                .build()
    })
}
package com.example.naveen.roomprac

import android.nfc.cardemulation.HostNfcFService
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class SecondActivity : AppCompatActivity() {
    lateinit var mMyDatabase: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mMyDatabase = MyDatabase.getInstance(this)
        doAsync {
            var ml:List<RecordBeam> = mMyDatabase.curdDao().getAllData()
            uiThread {
                toast(ml.toString())
            }
        }
    }
}

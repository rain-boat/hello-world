package com.example.naveen.roomprac

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.arch.persistence.room.Room
import android.widget.Toast
import com.facebook.stetho.Stetho
import org.jetbrains.anko.doAsync


class MainActivity : AppCompatActivity() {
    val dbName: String = "mydb"
    lateinit var mMyDatabase: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());*/
        /*Stetho.initializeWithDefaults(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build())*/
        setContentView(R.layout.activity_main)
        mMyDatabase = MyDatabase.getInstance(this)
        btnSave.setOnClickListener(View.OnClickListener {
            /*   object:Thread(object:Runnable(){
                override fun run() {
                    print("afdas")
                }
            }).start()
        }*/
            doAsync {
                val mRecordBeam: RecordBeam = RecordBeam(otherInfo ="my" ,name = "guru")
                var status = mMyDatabase.curdDao().insertData(mRecordBeam)
                if(status>0){
//                    Toast.makeText(applicationContext, "success", Toast.LENGTH_LONG).show()
                }

            }
        })
        btnNext.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        })
    }
}

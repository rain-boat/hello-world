package com.example.naveen.roomprac.common

import android.app.Application
import com.facebook.stetho.Stetho

class MyApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build())
    }
}
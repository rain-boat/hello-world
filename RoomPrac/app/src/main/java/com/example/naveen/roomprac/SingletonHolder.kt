package com.example.naveen.roomprac
//https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e

open class SingletonHolder<out T, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}

/********** Example ******************
 * class Manager private constructor(context: Context) {
init {
// Init using context argument
}

companion object : SingletonHolder<Manager, Context>(::Manager)
}

Manager.getInstance(context).doStuff()
**************************************/
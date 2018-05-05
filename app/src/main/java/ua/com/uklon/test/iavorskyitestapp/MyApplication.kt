package ua.com.uklon.test.iavorskyitestapp

import android.app.Application
import ua.com.uklon.test.iavorskyitestapp.util.Injection

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injection.initGraph()
    }
}
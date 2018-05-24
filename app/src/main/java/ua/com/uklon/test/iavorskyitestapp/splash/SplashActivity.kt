package ua.com.uklon.test.iavorskyitestapp.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ua.com.uklon.test.iavorskyitestapp.R
import ua.com.uklon.test.iavorskyitestapp.post.list.ListActivity

class SplashActivity : AppCompatActivity(), SplashContract.SplashView {

    private lateinit var mSplashPresenter: SplashContract.SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mSplashPresenter = SplashPresenter(this)
        mSplashPresenter.syncOnStartUp()
    }

    override fun startListActivity() {
        startActivity(Intent(applicationContext, ListActivity::class.java))
        finish()
    }

}

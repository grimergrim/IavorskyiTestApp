package ua.com.uklon.test.iavorskyitestapp.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
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
        startMainScreenWithDelay()
    }

    private fun startMainScreenWithDelay() {
        Handler().postDelayed({ startListActivity() }, SPLASH_DELAY)
    }

    override fun startListActivity() {
        startActivity(Intent(applicationContext, ListActivity::class.java))
        finish()
    }

    companion object {
        const val SPLASH_DELAY: Long = 3000 //sec
    }

}

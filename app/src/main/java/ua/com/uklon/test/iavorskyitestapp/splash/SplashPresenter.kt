package ua.com.uklon.test.iavorskyitestapp.splash

import ua.com.uklon.test.iavorskyitestapp.util.Injection

class SplashPresenter(private val mSplashView: SplashContract.SplashView) :
        SplashContract.SplashPresenter, SplashContract.SplashPresenterCallback {

    private val mRepository = Injection.getRepositoryInstance()

    override fun syncOnStartUp() {
        mRepository.setPresenter(this)
        mRepository.syncOnStartUp()
    }

    override fun startListActivity() {
        mSplashView.startListActivity()
    }

    companion object {
        const val TAG: String = "SplashPresenter"
    }

}
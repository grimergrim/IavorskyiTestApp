package ua.com.uklon.test.iavorskyitestapp.splash

interface SplashContract {

    interface SplashView {

        fun startListActivity()

    }

    interface SplashPresenter {

        fun syncOnStartUp()

    }

}
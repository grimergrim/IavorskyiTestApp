package ua.com.uklon.test.iavorskyitestapp.splash

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User
import ua.com.uklon.test.iavorskyitestapp.util.Injection

class SplashPresenter(private val mSplashView: SplashContract.SplashView) :
        SplashContract.SplashPresenter {

    private val mRepository = Injection.getRepositoryInstance()

    override fun syncOnStartUp() {
        mRepository.getPosts().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    savePosts(result)
                    getUsers()
                }, { error ->
                    Log.e(TAG, error.message)
                })
    }

    private fun getUsers() {
        mRepository.getUsers().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    saveUsers(result)
                }, { error ->
                    Log.e(TAG, error.message)
                })
    }

    private fun savePosts(result: List<Post>) {
        mRepository.savePosts(result)
    }

    private fun saveUsers(result: List<User>) {
        mRepository.saveUsers(result)
    }

    companion object {
        const val TAG: String = "SplashPresenter"
    }

}
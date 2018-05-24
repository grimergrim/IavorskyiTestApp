package ua.com.uklon.test.iavorskyitestapp.data

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.com.uklon.test.iavorskyitestapp.data.local.LocalDataSource
import ua.com.uklon.test.iavorskyitestapp.data.remote.RemoteDataSource
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User
import ua.com.uklon.test.iavorskyitestapp.splash.SplashContract
import ua.com.uklon.test.iavorskyitestapp.splash.SplashPresenter

class RepositoryImpl(private val mLocalDataSource: LocalDataSource,
                     private val mRemoteDataSource: RemoteDataSource) : Repository {

    private lateinit var mSplashPresenter: SplashContract.SplashPresenterCallback

    override fun setPresenter(presenter: SplashPresenter) {
        mSplashPresenter = presenter
    }

    override fun getComments(postId: Int): Observable<List<Comment>> {
        return mRemoteDataSource.getComments(postId)
    }

    override fun getPostsLocal(): Observable<List<Post>> {
        return mLocalDataSource.getPostsLocal()
    }

    override fun getUserByIdLocal(userId: Int): Observable<User> {
        return mLocalDataSource.getUserByIdLocal(userId)
    }

    override fun syncOnStartUp() {
        mRemoteDataSource.getPosts().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    savePosts(result)
                    getUsers()
                }, { error ->
                    Log.e(SplashPresenter.TAG, error.message)
                })
    }

    private fun getUsers() {
        mRemoteDataSource.getUsers().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    saveUsers(result)
                }, { error ->
                    Log.e(SplashPresenter.TAG, error.message)
                })
    }

    private fun savePosts(posts: List<Post>) {
        mLocalDataSource.savePosts(posts)
    }

    private fun saveUsers(users: List<User>) {
        mLocalDataSource.saveUsers(users)
        mSplashPresenter.startListActivity()
    }

}
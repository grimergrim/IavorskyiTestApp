package ua.com.uklon.test.iavorskyitestapp.post.detail

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.com.uklon.test.iavorskyitestapp.util.Injection

class DetailPresenter(private val mDetailView: DetailContract.DetailView) : DetailContract.DetailPresenter {

    private val mRepository = Injection.getRepositoryInstance()

    override fun getComments(postId: Int) {
        mRepository.getComments(postId).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ commentsList ->
                    mDetailView.showComments(commentsList)
                }, { error ->
                    Log.e(DetailPresenter.TAG, error.message)
                })
    }

    override fun getUserById(userId: Int) {
        mRepository.getUserByIdLocal(userId).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ user ->
                    mDetailView.showUserInfo(user)
                }, { error ->
                    Log.e(DetailPresenter.TAG, error.message)
                })
    }

    companion object {
        const val TAG: String = "DetailPresenter"
    }

}
package ua.com.uklon.test.iavorskyitestapp.post.list

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.com.uklon.test.iavorskyitestapp.util.Injection

class ListPresenter(private val mListView: ListContract.ListView) : ListContract.ListPresenter {

    private val mRepository = Injection.getRepositoryInstance()

    override fun getPosts() {
        mRepository.getPostsLocal().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ postsList ->
                    mListView.showPosts(postsList)
                }, { error ->
                    Log.e(TAG, error.message)
                })
    }

    companion object {
        const val TAG: String = "ListPresenter"
    }

}
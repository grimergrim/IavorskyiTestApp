package ua.com.uklon.test.iavorskyitestapp.post.list

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.transition.Explode
import android.view.Window
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.item_list.*
import ua.com.uklon.test.iavorskyitestapp.R
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.post.detail.DetailActivity

class ListActivity : AppCompatActivity(), ListContract.ListView, ListContract.ListActivityCallback {

    private lateinit var mListPresenter: ListContract.ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransition()
        setContentView(R.layout.activity_list)
        mListPresenter = ListPresenter(this)
        mListPresenter.getPosts()
        swipe_refresh_list.setOnRefreshListener({ refresh() })
    }

    override fun showPosts(posts: List<Post>) {
        if (swipe_refresh_list.isRefreshing) swipe_refresh_list.isRefreshing = false
        setupRecyclerView(item_list, posts)
    }

    override fun startActivity(post: Post) {
        val intent = Intent(applicationContext, DetailActivity::class.java).apply {
            putExtra(DetailActivity.ARG_USER_ID, post.userId)
            putExtra(DetailActivity.ARG_POST_ID, post.id)
        }

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, posts: List<Post>) {
        recyclerView.adapter = ListAdapter(this, posts)
    }

    private fun refresh() {
        mListPresenter.getPosts()
    }

    private fun setTransition() {
        window.allowEnterTransitionOverlap = true
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            enterTransition = Explode()
            exitTransition = Explode()
        }
    }

}

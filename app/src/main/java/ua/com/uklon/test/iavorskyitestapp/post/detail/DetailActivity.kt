package ua.com.uklon.test.iavorskyitestapp.post.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.transition.Explode
import android.view.Window
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_detail.*
import kotlinx.android.synthetic.main.user_info.*
import ua.com.uklon.test.iavorskyitestapp.R
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

class DetailActivity : AppCompatActivity(), DetailContract.DetailView {

    private lateinit var mDetailPresenter: DetailContract.DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransition()
        setContentView(R.layout.activity_detail)
        mDetailPresenter = DetailPresenter(this)
        val userId = intent.extras.getInt(ARG_USER_ID, -1)
        val postId = intent.extras.getInt(ARG_POST_ID, -1)
        if (userId > 0) {
            mDetailPresenter.getUserById(userId)
        } else {
            toolbar_title.text = getString(R.string.no_user_data_placeholder)
        }
        if (postId > 0) {
            mDetailPresenter.getComments(postId)
        }
        swipe_refresh_detail.setOnRefreshListener({ refresh(postId) })
    }

    override fun showUserInfo(user: User) {
        toolbar_title.text = String.format(getString(R.string.user_detail_title),
                user.username, user.address.city)
        name.text = user.name
        phone.text = user.phone
        web_site.text = user.website
        company_name.text = user.company.name
    }

    override fun showComments(comments: List<Comment>) {
        if (swipe_refresh_detail.isRefreshing) swipe_refresh_detail.isRefreshing = false
        setupRecyclerView(item_detail, comments)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, comments: List<Comment>) {
        recyclerView.adapter = DetailAdapter(comments)
    }

    private fun refresh(postId: Int) {
        mDetailPresenter.getComments(postId)
    }

    private fun setTransition() {
        window.allowEnterTransitionOverlap = true
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            enterTransition = Explode()
            exitTransition = Explode()
        }
    }

    companion object {
        const val ARG_USER_ID = "userId"
        const val ARG_POST_ID = "postId"
    }
}

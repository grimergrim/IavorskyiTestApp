package ua.com.uklon.test.iavorskyitestapp.post.detail

import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

interface DetailContract {

    interface DetailView {

        fun showUserInfo(user: User)

        fun showComments(comments: List<Comment>)

    }

    interface DetailPresenter {

        fun getComments(postId: Int)

        fun getUserById(userId: Int)

    }

}
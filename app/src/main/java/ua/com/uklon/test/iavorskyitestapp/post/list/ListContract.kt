package ua.com.uklon.test.iavorskyitestapp.post.list

import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post

interface ListContract {

    interface ListView {

        fun showPosts(posts: List<Post>)

    }

    interface ListPresenter {

        fun getPosts()

    }

    interface ListActivityCallback {

        fun startActivity(post: Post)

    }

}
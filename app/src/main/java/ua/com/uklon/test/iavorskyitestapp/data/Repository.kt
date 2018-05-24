package ua.com.uklon.test.iavorskyitestapp.data

import io.reactivex.Observable
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User
import ua.com.uklon.test.iavorskyitestapp.splash.SplashPresenter

interface Repository {

    fun syncOnStartUp()

    fun getPostsLocal(): Observable<List<Post>>

    fun getComments(postId: Int): Observable<List<Comment>>

    fun getUserByIdLocal(userId: Int): Observable<User>

    fun setPresenter(presenter: SplashPresenter)

}
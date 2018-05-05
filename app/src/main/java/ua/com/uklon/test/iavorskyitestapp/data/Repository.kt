package ua.com.uklon.test.iavorskyitestapp.data

import io.reactivex.Observable
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

interface Repository {

    fun getPosts(): Observable<List<Post>>

    fun savePosts(posts: List<Post>)

    fun saveUsers(users: List<User>)

    fun getPostsLocal(): Observable<List<Post>>

    fun getUsers(): Observable<List<User>>

    fun getComments(postId: Int): Observable<List<Comment>>

    fun getUserByIdLocal(userId: Int): Observable<User>

}
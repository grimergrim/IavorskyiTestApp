package ua.com.uklon.test.iavorskyitestapp.data.remote.http

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

interface HttpApi {

    @GET("posts")
    fun getPosts(): Observable<List<Post>>

    @GET("users")
    fun getUsers(): Observable<List<User>>

    @GET("posts/{postId}/comments")
    fun getComments(@Path("postId") postId: Int): Observable<List<Comment>>

}
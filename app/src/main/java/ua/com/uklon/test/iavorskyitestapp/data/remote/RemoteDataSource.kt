package ua.com.uklon.test.iavorskyitestapp.data.remote

import io.reactivex.Observable
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

interface RemoteDataSource {

    fun getPosts(): Observable<List<Post>>

    fun getUsers(): Observable<List<User>>

    fun getComments(postId: Int): Observable<List<Comment>>

}
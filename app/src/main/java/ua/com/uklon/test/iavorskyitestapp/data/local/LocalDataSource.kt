package ua.com.uklon.test.iavorskyitestapp.data.local

import io.reactivex.Observable
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

interface LocalDataSource {

    fun savePosts(posts: List<Post>)

    fun saveUsers(users: List<User>)

    fun getPostsLocal(): Observable<List<Post>>

    fun getUserByIdLocal(userId: Int): Observable<User>

}
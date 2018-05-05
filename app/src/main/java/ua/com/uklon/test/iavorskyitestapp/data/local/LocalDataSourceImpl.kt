package ua.com.uklon.test.iavorskyitestapp.data.local

import io.reactivex.Observable
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

class LocalDataSourceImpl : LocalDataSource {

    private var postsCache: List<Post> = ArrayList()
    private var usersCache: List<User> = ArrayList()

    override fun savePosts(posts: List<Post>) {
        postsCache = posts
    }

    override fun saveUsers(users: List<User>) {
        usersCache = users
    }

    override fun getPostsLocal(): Observable<List<Post>> {
        return Observable.just(postsCache)
    }

    override fun getUserByIdLocal(userId: Int): Observable<User> {
        val selectedUser: User = usersCache.single { user -> user.id == userId }
        return Observable.just(selectedUser)
    }

}
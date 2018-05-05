package ua.com.uklon.test.iavorskyitestapp.data

import io.reactivex.Observable
import ua.com.uklon.test.iavorskyitestapp.data.local.LocalDataSource
import ua.com.uklon.test.iavorskyitestapp.data.remote.RemoteDataSource
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

class RepositoryImpl(private val mLocalDataSource: LocalDataSource,
                     private val mRemoteDataSource: RemoteDataSource) : Repository {

    override fun getPosts(): Observable<List<Post>> {
        return mRemoteDataSource.getPosts()
    }

    override fun getUsers(): Observable<List<User>> {
        return mRemoteDataSource.getUsers()
    }

    override fun getComments(postId: Int): Observable<List<Comment>> {
        return mRemoteDataSource.getComments(postId)
    }

    override fun savePosts(posts: List<Post>) {
        mLocalDataSource.savePosts(posts)
    }

    override fun saveUsers(users: List<User>) {
        mLocalDataSource.saveUsers(users)
    }

    override fun getPostsLocal(): Observable<List<Post>> {
        return mLocalDataSource.getPostsLocal()
    }

    override fun getUserByIdLocal(userId: Int): Observable<User> {
        return mLocalDataSource.getUserByIdLocal(userId)
    }

}
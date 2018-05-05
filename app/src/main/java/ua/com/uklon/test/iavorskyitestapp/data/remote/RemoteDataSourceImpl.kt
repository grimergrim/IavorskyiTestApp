package ua.com.uklon.test.iavorskyitestapp.data.remote

import io.reactivex.Observable
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.HttpApi
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Comment
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.User

class RemoteDataSourceImpl(private val mHttpApi: HttpApi) : RemoteDataSource {

    override fun getPosts(): Observable<List<Post>> {
        return mHttpApi.getPosts()
    }

    override fun getUsers(): Observable<List<User>> {
        return mHttpApi.getUsers()
    }

    override fun getComments(postId: Int): Observable<List<Comment>> {
        return mHttpApi.getComments(postId)
    }

}
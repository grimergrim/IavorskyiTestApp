package ua.com.uklon.test.iavorskyitestapp.util

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ua.com.uklon.test.iavorskyitestapp.data.Repository
import ua.com.uklon.test.iavorskyitestapp.data.RepositoryImpl
import ua.com.uklon.test.iavorskyitestapp.data.local.LocalDataSource
import ua.com.uklon.test.iavorskyitestapp.data.local.LocalDataSourceImpl
import ua.com.uklon.test.iavorskyitestapp.data.remote.RemoteDataSource
import ua.com.uklon.test.iavorskyitestapp.data.remote.RemoteDataSourceImpl
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.HttpApi

object Injection {

    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

    private lateinit var mRepository: Repository
    private lateinit var mRemoteDataSource: RemoteDataSource
    private lateinit var mLocalDataSource: LocalDataSource
    private lateinit var mRetrofit: HttpApi

    private var initialized: Boolean = false

    fun initGraph() {
        if (!initialized) {
            mRetrofit = createRetrofitInstance()
            mRemoteDataSource = RemoteDataSourceImpl(mRetrofit)
            mLocalDataSource = LocalDataSourceImpl()
            mRepository = RepositoryImpl(mLocalDataSource, mRemoteDataSource)
            initialized = true
        }
    }

    fun getRepositoryInstance(): Repository {
        return mRepository
    }

    private fun createRetrofitInstance(): HttpApi {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .baseUrl(BASE_URL)
                .build()
                .create(HttpApi::class.java)
    }

}
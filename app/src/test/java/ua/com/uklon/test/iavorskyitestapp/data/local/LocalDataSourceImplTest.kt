package ua.com.uklon.test.iavorskyitestapp.data.local

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import ua.com.uklon.test.iavorskyitestapp.data.remote.http.json.Post

class LocalDataSourceImplTest {

    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setUp() {
        localDataSource = LocalDataSourceImpl()
    }

    @Test
    fun savePosts_retrievePosts() {
        val postsToDb: List<Post> = listOf(
                Post(1, "Title1", "Body1", 1),
                Post(2, "Title2", "Body2", 2),
                Post(3, "Title3", "Body3", 3))
        localDataSource.savePosts(postsToDb)
        val postsFromDb = localDataSource.getPostsLocal().blockingFirst()
        assertSame(postsToDb, postsFromDb)
    }

}
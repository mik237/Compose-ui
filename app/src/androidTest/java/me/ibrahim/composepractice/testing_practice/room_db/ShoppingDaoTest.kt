package me.ibrahim.composepractice.testing_practice.room_db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import me.ibrahim.composepractice.getOrAwait
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {


    @get:Rule
    var instantTaskExcutorRule = InstantTaskExecutorRule()

    private lateinit var shoppingDataBase: ShoppingDataBase
    private lateinit var shoppingDao: ShoppingDao


    @Before
    fun setup() {
        shoppingDataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingDataBase::class.java
        ).allowMainThreadQueries().build()

        shoppingDao = shoppingDataBase.shoppingDao()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_insertShoppingItem() = runTest {
        val shoppingItem = ShoppingItem(1, "apple", 2, 4.0, "imageUrl")

        advanceUntilIdle()
        val job = launch {
            shoppingDao.observerAllItems().collectLatest {
                println(it)
                assertThat(it).contains(shoppingItem)
            }
        }
        shoppingDao.insertShoppingItem(shoppingItem)
        job.cancel()
    }


    @Test
    fun test_deleteShoppingItem() = runTest {
        val shoppingItem = ShoppingItem(1, "apple", 2, 4.0, "imageUrl")
        shoppingDao.insertShoppingItem(shoppingItem)

        shoppingDao.deleteShoppingItem(shoppingItem)

        val shoppingItems = shoppingDao.observerAllItemsLive().getOrAwait()
        assertThat(shoppingItems).doesNotContain(shoppingItem)
    }

    @Test
    fun test_totalSumOfAmount() = runTest {
        val shoppingItem1 = ShoppingItem(1, "apple", 2, 5.0, "imageUrl")
        val shoppingItem2 = ShoppingItem(2, "apple", 1, 40.0, "imageUrl")
        val shoppingItem3 = ShoppingItem(3, "apple", 4, 7.0, "imageUrl")

        shoppingDao.insertShoppingItem(shoppingItem1)
        shoppingDao.insertShoppingItem(shoppingItem2)
        shoppingDao.insertShoppingItem(shoppingItem3)

        val sum = shoppingDao.observeTotalPriceLive().getOrAwait()
        assertThat(sum).isEqualTo(2 * 5.0 + 1 * 40.0 + 4 * 7.0)

    }
}
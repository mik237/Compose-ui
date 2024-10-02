package me.ibrahim.composepractice.testing_practice.room_db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {

    @Insert
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun observerAllItems(): Flow<List<ShoppingItem>>

    @Query("SELECT * FROM shopping_items")
    fun observerAllItemsLive(): LiveData<List<ShoppingItem>>


    @Query("SELECT SUM(amount * price) FROM shopping_items")
    fun observeTotalPrice(): Flow<Double>

    @Query("SELECT SUM(amount * price) FROM shopping_items")
    fun observeTotalPriceLive(): LiveData<Double>
}
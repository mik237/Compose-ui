package me.ibrahim.composepractice.testing_practice.room_db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDataBase : RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}
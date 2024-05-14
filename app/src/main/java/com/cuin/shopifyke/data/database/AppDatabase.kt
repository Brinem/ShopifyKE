package com.cuin.shopifyke.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cuin.shopifyke.domain.entity.cart.UserCartEntity
import com.cuin.shopifyke.domain.entity.product.FavoriteProductEntity

@Database(entities = [UserCartEntity::class, FavoriteProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
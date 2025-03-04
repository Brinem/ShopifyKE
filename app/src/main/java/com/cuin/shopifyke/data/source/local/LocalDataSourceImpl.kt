package com.cuin.shopifyke.data.source.local

import com.cuin.shopifyke.data.database.AppDao
import com.cuin.shopifyke.domain.entity.cart.UserCartEntity
import com.cuin.shopifyke.domain.entity.product.FavoriteProductEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val appDao: AppDao) : LocalDataSource {
    override suspend fun getUserCartByUserIdFromDb(userId: String): List<UserCartEntity> {
        return appDao.getCartByUserId(userId)
    }

    override suspend fun insertUserCartToDb(userCartEntity: UserCartEntity) {
        appDao.insertUserCart(userCartEntity)
    }

    override suspend fun deleteUserCartFromDb(userCartEntity: UserCartEntity) {
        appDao.deleteUserCartItem(userCartEntity)
    }

    override suspend fun updateUserCartFromDb(userCartEntity: UserCartEntity) {
        appDao.updateUserCartItem(userCartEntity)
    }

    override suspend fun getFavoriteProductsFromDb(userId: String): List<FavoriteProductEntity> {
        return appDao.getFavoriteProducts(userId)
    }

    override suspend fun insertFavoriteItemToDb(favoriteProductEntity: FavoriteProductEntity) {
        appDao.insertFavoriteItem(favoriteProductEntity)
    }

    override suspend fun deleteFavoriteItemFromDb(favoriteProductEntity: FavoriteProductEntity) {
        appDao.deleteFavoriteItem(favoriteProductEntity)
    }

    override suspend fun getBadgeCountFromDb(userId: String): Int {
        return appDao.getBadgeCount(userId)
    }
}

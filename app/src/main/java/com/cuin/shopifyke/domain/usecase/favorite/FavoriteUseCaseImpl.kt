package com.cuin.shopifyke.domain.usecase.favorite

import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.domain.entity.product.FavoriteProductEntity
import com.cuin.shopifyke.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : FavoriteUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> =
        repository.getFavoriteProductsFromDb(userId)

    override suspend fun invoke(item: FavoriteProductEntity) {
        repository.insertFavoriteProductToDb(item)
    }
}

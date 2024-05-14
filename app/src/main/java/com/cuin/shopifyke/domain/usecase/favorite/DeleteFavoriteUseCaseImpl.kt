package com.cuin.shopifyke.domain.usecase.favorite

import com.cuin.shopifyke.domain.entity.product.FavoriteProductEntity
import com.cuin.shopifyke.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteFavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : DeleteFavoriteUseCase {
    override suspend fun invoke(favoriteProductEntity: FavoriteProductEntity) {
        repository.deleteFavoriteProduct(favoriteProductEntity)
    }
}

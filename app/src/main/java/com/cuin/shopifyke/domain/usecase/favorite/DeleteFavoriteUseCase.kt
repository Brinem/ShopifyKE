package com.cuin.shopifyke.domain.usecase.favorite

import com.cuin.shopifyke.domain.entity.product.FavoriteProductEntity

interface DeleteFavoriteUseCase {
    suspend operator fun invoke(favoriteProductEntity: FavoriteProductEntity)
}
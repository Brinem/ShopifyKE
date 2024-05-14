package com.cuin.shopifyke.domain.usecase.product

import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetAllProductsUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>>

    operator fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>
}

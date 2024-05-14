package com.cuin.shopifyke.domain.usecase.product

import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.domain.entity.product.ProductEntity
import com.cuin.shopifyke.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : SearchProductUseCase {
    override fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListBySearchFromApi(query)
    }
}

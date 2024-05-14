package com.cuin.shopifyke.domain.usecase.product

import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.domain.entity.product.DetailProductEntity
import com.cuin.shopifyke.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleProductUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetSingleProductUseCase {
    override fun invoke(id: Int): Flow<NetworkResponseState<DetailProductEntity>> =
        repository.getSingleProductByIdFromApi(id)
}

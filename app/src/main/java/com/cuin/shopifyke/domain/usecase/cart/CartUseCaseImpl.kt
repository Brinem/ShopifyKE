package com.cuin.shopifyke.domain.usecase.cart

import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.domain.entity.cart.UserCartEntity
import com.cuin.shopifyke.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCaseImpl @Inject constructor(private val repository: LocalRepository) : CartUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> = repository.getCartsByUserIdFromDb(userId)
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.insertUserCartToDb(userCartEntity)
    }
}

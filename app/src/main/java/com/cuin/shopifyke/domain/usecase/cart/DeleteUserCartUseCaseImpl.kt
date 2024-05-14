package com.cuin.shopifyke.domain.usecase.cart

import com.cuin.shopifyke.domain.entity.cart.UserCartEntity
import com.cuin.shopifyke.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteUserCartUseCaseImpl @Inject constructor(private val repository: LocalRepository) :
    DeleteUserCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.deleteUserCart(userCartEntity)
    }
}

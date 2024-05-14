package com.cuin.shopifyke.domain.usecase.cart

import com.cuin.shopifyke.domain.entity.cart.UserCartEntity

interface DeleteUserCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}

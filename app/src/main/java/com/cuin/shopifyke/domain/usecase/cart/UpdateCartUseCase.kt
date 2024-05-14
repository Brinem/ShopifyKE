package com.cuin.shopifyke.domain.usecase.cart

import com.cuin.shopifyke.domain.entity.cart.UserCartEntity

interface UpdateCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}

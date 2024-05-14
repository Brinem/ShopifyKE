package com.cuin.shopifyke.domain.usecase.cart.badge

import com.cuin.shopifyke.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface UserCartBadgeUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<Int>>
}
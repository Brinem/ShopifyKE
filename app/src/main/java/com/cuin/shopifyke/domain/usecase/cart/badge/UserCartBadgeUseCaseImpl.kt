package com.cuin.shopifyke.domain.usecase.cart.badge

import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserCartBadgeUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UserCartBadgeUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<Int>> {
        return repository.getBadgeCountFromDb(userId)
    }
}

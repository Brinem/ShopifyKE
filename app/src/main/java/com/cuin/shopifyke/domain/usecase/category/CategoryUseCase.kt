package com.cuin.shopifyke.domain.usecase.category

import com.cuin.shopifyke.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<String>>>
}

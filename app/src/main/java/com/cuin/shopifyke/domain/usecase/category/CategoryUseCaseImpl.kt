package com.cuin.shopifyke.domain.usecase.category

import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.domain.repository.RemoteRepository
import com.cuin.shopifyke.domain.usecase.category.CategoryUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(private val repository: RemoteRepository) :
    CategoryUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<String>>> {
        return repository.getAllCategoriesListFromApi()
    }
}

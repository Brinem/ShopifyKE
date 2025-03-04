package com.cuin.shopifyke.domain.usecase.user.read_user

import com.cuin.shopifyke.domain.entity.user.UserInformationEntity
import com.cuin.shopifyke.domain.repository.FirebaseRepository
import javax.inject.Inject

class ReadFirebaseUserInfosUseCaseImpl @Inject constructor(
    private val repository: FirebaseRepository
): ReadFirebaseUserInfosUseCase {
    override fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        repository.readUserFromFirebaseDatabase(userId, onSuccess, onFailure)
    }
}
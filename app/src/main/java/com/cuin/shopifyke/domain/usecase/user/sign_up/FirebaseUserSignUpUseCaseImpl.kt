package com.cuin.shopifyke.domain.usecase.user.sign_up

import com.cuin.shopifyke.domain.entity.user.UserInformationEntity
import com.cuin.shopifyke.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseUserSignUpUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository,
) : FirebaseUserSignUpUseCase {
    override fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseRepository.signUpWithFirebase(user, onSuccess, onFailure)
    }
}

package com.cuin.shopifyke.domain.usecase.user.sign_in

import com.cuin.shopifyke.domain.entity.user.FirebaseSignInUserEntity
import com.cuin.shopifyke.domain.entity.user.UserInformationEntity
import com.cuin.shopifyke.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseUserSingInUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
): FirebaseUserSingInUseCase {
    override fun invoke(user: FirebaseSignInUserEntity, onSuccess: (UserInformationEntity) -> Unit, onFailure: (String) -> Unit) {
        firebaseRepository.signInWithFirebase(user, onSuccess, onFailure)
    }
}
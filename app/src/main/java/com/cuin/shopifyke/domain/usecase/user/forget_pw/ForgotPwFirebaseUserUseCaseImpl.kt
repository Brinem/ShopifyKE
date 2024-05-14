package com.cuin.shopifyke.domain.usecase.user.forget_pw

import com.cuin.shopifyke.domain.repository.FirebaseRepository
import com.cuin.shopifyke.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCase
import javax.inject.Inject

class ForgotPwFirebaseUserUseCaseImpl @Inject constructor(
    private val repository: FirebaseRepository,
): ForgotPwFirebaseUserUseCase {
    override fun invoke(email: String, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {
        repository.forgotPassword(
            email,
            onSuccess = {
                onSuccess("Success")
            },
            onFailure = {
                onFailure(it)
            },
        )
    }

}
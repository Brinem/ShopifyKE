package com.cuin.shopifyke.domain.usecase.user.sign_up

import com.cuin.shopifyke.domain.entity.user.UserInformationEntity

interface FirebaseUserSignUpUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}

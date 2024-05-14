package com.cuin.shopifyke.domain.usecase.user.sign_in

import com.cuin.shopifyke.domain.entity.user.FirebaseSignInUserEntity
import com.cuin.shopifyke.domain.entity.user.UserInformationEntity

interface FirebaseUserSingInUseCase {
    operator fun invoke(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}
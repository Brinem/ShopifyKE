package com.cuin.shopifyke.ui.mapper

import com.cuin.shopifyke.domain.entity.user.UserInformationEntity
import com.cuin.shopifyke.domain.mapper.ProductBaseMapper
import com.cuin.shopifyke.ui.uiData.UserInformationUiData
import javax.inject.Inject

class UserInfoEntityToUiDataMapper @Inject constructor() :
    ProductBaseMapper<UserInformationEntity, UserInformationUiData> {
    override fun map(input: UserInformationEntity): UserInformationUiData {
        return UserInformationUiData(
            id = input.id,
            name = input.name,
            surname = input.surname,
            email = input.email,
            phone = input.phone,
            image = input.image,
            password = input.password,
            token = input.token,
        )
    }
}

class UserInfoUiDataToEntityMapper @Inject constructor() :
    ProductBaseMapper<UserInformationUiData, UserInformationEntity> {
    override fun map(input: UserInformationUiData): UserInformationEntity {
        return UserInformationEntity(
            id = input.id,
            name = input.name,
            surname = input.surname,
            email = input.email,
            phone = input.phone,
            image = input.image,
            password = input.password,
            token = input.token,
        )
    }
}

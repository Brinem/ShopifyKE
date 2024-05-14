package com.cuin.shopifyke.di.mappers

import com.cuin.shopifyke.domain.entity.cart.UserCartEntity
import com.cuin.shopifyke.domain.entity.product.DetailProductEntity
import com.cuin.shopifyke.domain.entity.product.FavoriteProductEntity
import com.cuin.shopifyke.domain.entity.product.ProductEntity
import com.cuin.shopifyke.domain.entity.user.UserInformationEntity
import com.cuin.shopifyke.domain.mapper.ProductBaseMapper
import com.cuin.shopifyke.domain.mapper.ProductListMapper
import com.cuin.shopifyke.ui.mapper.CartEntityToFavoriteEntityMapper
import com.cuin.shopifyke.ui.mapper.CartEntityToUiMapper
import com.cuin.shopifyke.ui.mapper.CartUiToEntityMapper
import com.cuin.shopifyke.ui.mapper.DetailProductEntityToUiMapper
import com.cuin.shopifyke.ui.mapper.FavoriteEntityToUiMapper
import com.cuin.shopifyke.ui.mapper.FavoriteUiToEntityMapper
import com.cuin.shopifyke.ui.mapper.ProductEntityToUiMapper
import com.cuin.shopifyke.ui.mapper.UserInfoEntityToUiDataMapper
import com.cuin.shopifyke.ui.mapper.UserInfoUiDataToEntityMapper
import com.cuin.shopifyke.ui.uiData.DetailProductUiData
import com.cuin.shopifyke.ui.uiData.FavoriteUiData
import com.cuin.shopifyke.ui.uiData.ProductUiData
import com.cuin.shopifyke.ui.uiData.UserCartUiData
import com.cuin.shopifyke.ui.uiData.UserInformationUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UiMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindHomeProductUiMapper(productUiDataMapper: ProductEntityToUiMapper): ProductListMapper<ProductEntity, ProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailProductUiMapper(productUiDataMapper: DetailProductEntityToUiMapper): ProductBaseMapper<DetailProductEntity, DetailProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindCartUiMapper(cartUiDataMapper: CartEntityToUiMapper): ProductListMapper<UserCartEntity, UserCartUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartUiMapper(singleCartUiDataMapper: CartUiToEntityMapper): ProductBaseMapper<UserCartUiData, UserCartEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoEntityToUiDataMapper(userInformationUiDataMapper: UserInfoEntityToUiDataMapper): ProductBaseMapper<UserInformationEntity, UserInformationUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoUiDataToEntityMapper(userInformationEntityMapperToUi: UserInfoUiDataToEntityMapper): ProductBaseMapper<UserInformationUiData, UserInformationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteItemUiMapper(favoriteEntityToUiMapper: FavoriteEntityToUiMapper): ProductListMapper<FavoriteProductEntity, FavoriteUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleFavoriteItemUiMapper(favoriteUiToEntityMapper: FavoriteUiToEntityMapper): ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartToFavoriteEntityMapper(cartEntityToFavoriteEntityMapper: CartEntityToFavoriteEntityMapper): ProductBaseMapper<UserCartEntity, FavoriteProductEntity>
}

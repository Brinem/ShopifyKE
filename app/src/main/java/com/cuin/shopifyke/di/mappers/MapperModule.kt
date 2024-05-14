package com.cuin.shopifyke.di.mappers

import com.cuin.shopifyke.data.dto.Product
import com.cuin.shopifyke.data.mapper.ProductEntityMapper
import com.cuin.shopifyke.data.mapper.SingleProductEntityMapper
import com.cuin.shopifyke.domain.entity.product.DetailProductEntity
import com.cuin.shopifyke.domain.entity.product.ProductEntity
import com.cuin.shopifyke.domain.mapper.ProductBaseMapper
import com.cuin.shopifyke.domain.mapper.ProductListMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAllProductsEntityMapper(productEntityMapper: ProductEntityMapper): ProductListMapper<Product, ProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleProductEntityMapper(singleProductEntityMapper: SingleProductEntityMapper): ProductBaseMapper<Product, DetailProductEntity>
}

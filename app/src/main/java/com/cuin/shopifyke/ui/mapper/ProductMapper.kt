package com.cuin.shopifyke.ui.mapper

import com.cuin.shopifyke.ui.uiData.ProductUiData
import com.cuin.shopifyke.domain.entity.product.ProductEntity
import com.cuin.shopifyke.domain.mapper.ProductListMapper
import javax.inject.Inject

class ProductEntityToUiMapper @Inject constructor() :
    ProductListMapper<ProductEntity, ProductUiData> {
    override fun map(input: List<ProductEntity>): List<ProductUiData> {
        return input.map {
            ProductUiData(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price,
                imageUrl = it.imageUrl,
                rating = it.rating,
            )
        }
    }
}

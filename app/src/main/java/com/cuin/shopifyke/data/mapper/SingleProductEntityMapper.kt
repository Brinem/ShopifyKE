package com.cuin.shopifyke.data.mapper

import com.cuin.shopifyke.data.dto.Product
import com.cuin.shopifyke.domain.entity.product.DetailProductEntity
import com.cuin.shopifyke.domain.mapper.ProductBaseMapper
import javax.inject.Inject

class SingleProductEntityMapper @Inject constructor() :
    ProductBaseMapper<Product, DetailProductEntity> {
    override fun map(input: Product): DetailProductEntity {
        return DetailProductEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            price = input.price.toString(),
            imageUrl = input.images,
            rating = input.rating.toString(),
        )
    }
}

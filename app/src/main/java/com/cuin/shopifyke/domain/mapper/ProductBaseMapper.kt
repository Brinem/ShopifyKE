package com.cuin.shopifyke.domain.mapper

interface ProductBaseMapper<I, O> {
    fun map(input: I): O
}

package com.cuin.shopifyke.data.api

import com.cuin.shopifyke.data.dto.Product
import com.cuin.shopifyke.data.dto.Products
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    suspend fun getProductsListFromApi(): Products
    @GET("products/search")
    suspend fun getProductsListBySearchFromApi(@Query("q") query: String): Products
    @GET("products/{id}")
    suspend fun getSingleProductByIdFromApi(@Path("id") productId: Int): Product
    @GET("products/categories")
    suspend fun getAllCategoriesListFromApi(): List<String>
    @GET("products/category/{categoryName}")
    suspend fun getProductsListByCategoryNameFromApi(@Path("categoryName") categoryName: String): Products
}

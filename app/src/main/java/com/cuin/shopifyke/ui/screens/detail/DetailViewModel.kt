package com.cuin.shopifyke.ui.screens.detail

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuin.shopifyke.common.NetworkResponseState
import com.cuin.shopifyke.common.ScreenState
import com.cuin.shopifyke.domain.entity.cart.UserCartEntity
import com.cuin.shopifyke.domain.entity.product.DetailProductEntity
import com.cuin.shopifyke.domain.entity.product.FavoriteProductEntity
import com.cuin.shopifyke.domain.mapper.ProductBaseMapper
import com.cuin.shopifyke.domain.usecase.cart.CartUseCase
import com.cuin.shopifyke.domain.usecase.favorite.FavoriteUseCase
import com.cuin.shopifyke.domain.usecase.product.GetSingleProductUseCase
import com.cuin.shopifyke.ui.uiData.DetailProductUiData
import com.cuin.shopifyke.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSingleProductUseCase: GetSingleProductUseCase,
    private val cartUseCase: CartUseCase,
    private val mapper: ProductBaseMapper<DetailProductEntity, DetailProductUiData>,
    private val favoriteUseCase: FavoriteUseCase,
    private val cartToFavoriteUiMapper: ProductBaseMapper<UserCartEntity, FavoriteProductEntity>,
    private val savedStateHandle: SavedStateHandle,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    private val _product = MutableLiveData<ScreenState<DetailProductUiData>>()
    val product: LiveData<ScreenState<DetailProductUiData>> get() = _product

    init {
        getProduct()
    }

    private fun getProduct() {
        viewModelScope.launch {
            savedStateHandle.get<Int>("productId")?.let { productId ->
                getSingleProductUseCase.invoke(productId).collect {
                    when (it) {
                        is NetworkResponseState.Error -> _product.postValue(ScreenState.Error(it.exception.message!!))
                        is NetworkResponseState.Loading -> _product.postValue(ScreenState.Loading)
                        is NetworkResponseState.Success -> _product.postValue(
                            ScreenState.Success(
                                mapper.map(
                                    it.result,
                                ),
                            ),
                        )
                    }
                }
            }
        }
    }

    fun addToCart(userCartEntity: UserCartEntity) {
        viewModelScope.launch {
            cartUseCase.invoke(
                userCartEntity.copy(
                    userId = getUserIdFromSharedPref(sharedPreferences),
                ),
            )
        }
    }

    fun addToFavorite(userCartUiData: UserCartEntity) {
        viewModelScope.launch {
            favoriteUseCase.invoke(
                cartToFavoriteUiMapper.map(
                    userCartUiData.copy(
                        userId = getUserIdFromSharedPref(sharedPreferences),
                    ),
                ),
            )
        }
    }
}

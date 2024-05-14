package com.cuin.shopifyke.ui.screens.profile

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuin.shopifyke.common.ScreenState
import com.cuin.shopifyke.domain.entity.user.UserInformationEntity
import com.cuin.shopifyke.domain.mapper.ProductBaseMapper
import com.cuin.shopifyke.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import com.cuin.shopifyke.ui.uiData.UserInformationUiData
import com.cuin.shopifyke.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val readFirebaseUserInfosUseCase: ReadFirebaseUserInfosUseCase,
    private val sharedPreferences: SharedPreferences,
    private val firebaseUserInfoToUiData: ProductBaseMapper<UserInformationEntity, UserInformationUiData>,
) : ViewModel() {
    private val _userInfos = MutableLiveData<ScreenState<UserInformationUiData>>()
    val userInfos: LiveData<ScreenState<UserInformationUiData>> get() = _userInfos

    init {
        getUserInfosFromFirebase()
    }

    private fun getUserInfosFromFirebase() {
        _userInfos.value = ScreenState.Loading
        viewModelScope.launch {
            readFirebaseUserInfosUseCase.invoke(
                getUserIdFromSharedPref(sharedPreferences),
                onSuccess = {
                    _userInfos.postValue(ScreenState.Success(firebaseUserInfoToUiData.map(it)))
                },
            ) {
                _userInfos.postValue(ScreenState.Error(it))
            }
        }
    }
}

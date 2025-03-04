package com.cuin.shopifyke.ui.screens.auth.vieModels

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuin.shopifyke.common.Constants.PREF_FIREBASE_USERID_KEY
import com.cuin.shopifyke.common.ScreenState
import com.cuin.shopifyke.domain.entity.user.FirebaseSignInUserEntity
import com.cuin.shopifyke.domain.entity.user.UserInformationEntity
import com.cuin.shopifyke.domain.mapper.ProductBaseMapper
import com.cuin.shopifyke.domain.usecase.user.sign_in.FirebaseUserSingInUseCase
import com.cuin.shopifyke.ui.uiData.UserInformationUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SigInViewModel @Inject constructor(
    private val firebaseUserSingInUseCase: FirebaseUserSingInUseCase,
    private val firebaseUserInfoToUiData: ProductBaseMapper<UserInformationEntity, UserInformationUiData>,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {

    private val _firebaseLoginState = MutableLiveData<ScreenState<UserInformationUiData>>()
    val firebaseLoginState: LiveData<ScreenState<UserInformationUiData>> get() = _firebaseLoginState

    fun loginWithFirebase(user: FirebaseSignInUserEntity) {
        viewModelScope.launch {
            _firebaseLoginState.postValue(ScreenState.Loading)
            firebaseUserSingInUseCase.invoke(
                user,
                onSuccess = {
                    _firebaseLoginState.postValue(
                        ScreenState.Success(
                            firebaseUserInfoToUiData.map(
                                it,
                            ),
                        ),
                    )
                    saveUserIdToSharedPref(it.id)
                },
            ) {
                _firebaseLoginState.postValue(ScreenState.Error(it))
            }
        }
    }

    private fun saveUserIdToSharedPref(id: String) {
        sharedPreferences.edit()
            .putString(PREF_FIREBASE_USERID_KEY, id)
            .apply()
    }
}

package com.cuin.shopifyke.di.usecase

import com.cuin.shopifyke.domain.usecase.cart.CartUseCase
import com.cuin.shopifyke.domain.usecase.cart.CartUseCaseImpl
import com.cuin.shopifyke.domain.usecase.cart.DeleteUserCartUseCase
import com.cuin.shopifyke.domain.usecase.cart.DeleteUserCartUseCaseImpl
import com.cuin.shopifyke.domain.usecase.cart.UpdateCartUseCase
import com.cuin.shopifyke.domain.usecase.cart.UpdateCartUseCaseImpl
import com.cuin.shopifyke.domain.usecase.cart.badge.UserCartBadgeUseCase
import com.cuin.shopifyke.domain.usecase.cart.badge.UserCartBadgeUseCaseImpl
import com.cuin.shopifyke.domain.usecase.favorite.DeleteFavoriteUseCase
import com.cuin.shopifyke.domain.usecase.favorite.DeleteFavoriteUseCaseImpl
import com.cuin.shopifyke.domain.usecase.favorite.FavoriteUseCase
import com.cuin.shopifyke.domain.usecase.favorite.FavoriteUseCaseImpl
import com.cuin.shopifyke.domain.usecase.product.GetAllProductsUseCase
import com.cuin.shopifyke.domain.usecase.product.GetAllProductsUseCaseImpl
import com.cuin.shopifyke.domain.usecase.product.GetSingleProductUseCase
import com.cuin.shopifyke.domain.usecase.product.GetSingleProductUseCaseImpl
import com.cuin.shopifyke.domain.usecase.product.SearchProductUseCase
import com.cuin.shopifyke.domain.usecase.product.SearchProductUseCaseImpl
import com.cuin.shopifyke.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCase
import com.cuin.shopifyke.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCaseImpl
import com.cuin.shopifyke.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import com.cuin.shopifyke.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCaseImpl
import com.cuin.shopifyke.domain.usecase.user.sign_in.FirebaseUserSingInUseCase
import com.cuin.shopifyke.domain.usecase.user.sign_in.FirebaseUserSingInUseCaseImpl
import com.cuin.shopifyke.domain.usecase.user.sign_up.FirebaseUserSignUpUseCase
import com.cuin.shopifyke.domain.usecase.user.sign_up.FirebaseUserSignUpUseCaseImpl
import com.cuin.shopifyke.domain.usecase.user.write_user.WriteFirebaseUserInfosCaseImpl
import com.cuin.shopifyke.domain.usecase.user.write_user.WriteFirebaseUserInfosUseCase
import com.cuin.shopifyke.domain.usecase.category.CategoryUseCase
import com.cuin.shopifyke.domain.usecase.category.CategoryUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllProductsUseCase(
        getAllProductsUseCaseImpl: GetAllProductsUseCaseImpl,
    ): GetAllProductsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetSingleProductUseCase(
        getSingleProductUseCaseImpl: GetSingleProductUseCaseImpl,
    ): GetSingleProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllCategoryUseCase(
        getAllCategoryUseCaseImpl: CategoryUseCaseImpl,
    ): CategoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindCartUseCase(
        cartUseCaseImpl: CartUseCaseImpl,
    ): CartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteUserCartUseCase(
        deleteUserCartUseCaseImpl: DeleteUserCartUseCaseImpl,
    ): DeleteUserCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSearchUseCase(
        searchUseCaseImpl: SearchProductUseCaseImpl,
    ): SearchProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpdateCartUseCase(
        updateCartUseCaseImpl: UpdateCartUseCaseImpl,
    ): UpdateCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteUseCase(
        favoriteUseCaseImpl: FavoriteUseCaseImpl,
    ): FavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteFavoriteUseCase(
        deleteFavoriteUseCaseImpl: DeleteFavoriteUseCaseImpl,
    ): DeleteFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignUpUseCase(
        firebaseSignUpUseCaseImpl: FirebaseUserSignUpUseCaseImpl,
    ): FirebaseUserSignUpUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignInUseCase(
        firebaseSignInUseCaseImpl: FirebaseUserSingInUseCaseImpl,
    ): FirebaseUserSingInUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseForgetPwUseCase(
        firebaseForgetPwUseCaseImpl: ForgotPwFirebaseUserUseCaseImpl,
    ): ForgotPwFirebaseUserUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseWriteUserUseCase(
        firebaseWriteUserUseCaseImpl: WriteFirebaseUserInfosCaseImpl,
    ): WriteFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseReadUserUseCase(
        firebaseReadUserCaseImpl: ReadFirebaseUserInfosUseCaseImpl,
    ): ReadFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUserCartBadgeUseCase(
        userCartBadgeUseCaseImpl: UserCartBadgeUseCaseImpl,
    ): UserCartBadgeUseCase
}

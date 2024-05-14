package com.cuin.shopifyke.di.repository

import com.cuin.shopifyke.data.repository.FirebaseRepositoryImpl
import com.cuin.shopifyke.data.repository.LocalRepositoryImpl
import com.cuin.shopifyke.data.repository.RemoteRepositoryImpl
import com.cuin.shopifyke.domain.repository.FirebaseRepository
import com.cuin.shopifyke.domain.repository.LocalRepository
import com.cuin.shopifyke.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteRepository(
        repository: RemoteRepositoryImpl,
    ): RemoteRepository

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRepository(
        repository: LocalRepositoryImpl,
    ): LocalRepository

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseRepository(
        repository: FirebaseRepositoryImpl,
    ): FirebaseRepository
}

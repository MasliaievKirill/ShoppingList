package com.masliaiev.shoppinglist.di

import android.app.Application
import com.masliaiev.shoppinglist.data.AppDatabase
import com.masliaiev.shoppinglist.data.ShopListDao
import com.masliaiev.shoppinglist.data.ShopListRepositoryImpl
import com.masliaiev.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object{

        @Provides
        @ApplicationScope
        fun provideShopListDao(application: Application): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}
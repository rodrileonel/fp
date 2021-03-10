package com.appstuddio.cleanmvvm.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appstuddio.cleanmvvm.features.coupons.CouponsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CouponsViewModel::class)
    abstract fun bindsCouponsViewModel(couponsViewModel: CouponsViewModel): ViewModel

}
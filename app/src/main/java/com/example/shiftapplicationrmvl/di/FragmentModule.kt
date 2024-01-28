package com.example.shiftapplicationrmvl.di

import com.example.shiftapplicationrmvl.ui.users.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun provideUsersFragment():UsersFragment

}
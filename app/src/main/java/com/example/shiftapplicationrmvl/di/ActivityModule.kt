package com.example.shiftapplicationrmvl.di

import com.example.shiftapplicationrmvl.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity():MainActivity


}
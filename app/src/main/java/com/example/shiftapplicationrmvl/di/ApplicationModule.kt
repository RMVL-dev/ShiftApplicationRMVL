package com.example.shiftapplicationrmvl.di

import android.content.Context
import com.example.shiftapplicationrmvl.ShiftApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext(application: ShiftApplication): Context =
        application.applicationContext


}
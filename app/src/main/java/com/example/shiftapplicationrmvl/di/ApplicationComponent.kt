package com.example.shiftapplicationrmvl.di

import com.example.shiftapplicationrmvl.ShiftApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Component(
    modules = [
        ActivityModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        AndroidInjectionModule::class
    ]
)
@Singleton
interface ApplicationComponent: AndroidInjector<ShiftApplication>{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext:ShiftApplication):ApplicationComponent
    }

}
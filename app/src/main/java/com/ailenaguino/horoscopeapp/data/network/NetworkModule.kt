package com.ailenaguino.horoscopeapp.data.network

import com.ailenaguino.horoscopeapp.data.RepositoryImpl
import com.ailenaguino.horoscopeapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//alcance del modulo, en este caso que cualquiera pueda inyectarse este modulo
object NetworkModule {

    @Provides
    @Singleton //para no crear un retorift por llamada, sino que se use el primero y unico que se creó
    fun provideRetrofit(): Retrofit {
        return Retrofit
                .Builder()
                .baseUrl("https://newastro.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService):Repository{
        return RepositoryImpl(apiService)
    }
}
package co.kr.cobosys.data.di

import co.kr.cobosys.data.api.Request
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @Provides
    @Singleton
    fun reqApi(retrofit: Retrofit): Request =
        retrofit.create(Request::class.java)

}
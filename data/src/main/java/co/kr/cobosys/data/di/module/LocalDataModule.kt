package co.kr.cobosys.data.di.module

import android.content.Context
import androidx.room.Room
import co.kr.cobosys.data.room.db.dao.AccessTokenDao
import co.kr.cobosys.data.room.db.db.BaroderRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext roomContext: Context): BaroderRoomDatabase =
        Room.databaseBuilder(roomContext, BaroderRoomDatabase::class.java, "baroder_localdb")
            .build()

    @Singleton
    @Provides
    fun accessTokenDao(accessToken: BaroderRoomDatabase): AccessTokenDao =
        accessToken.accessTokenDao()

}
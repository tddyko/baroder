package co.kr.cobosys.data.room.db.db

import androidx.room.Database
import androidx.room.RoomDatabase
import co.kr.cobosys.data.room.db.dao.AccessTokenDao
import co.kr.cobosys.data.room.db.dao.UserDao
import co.kr.cobosys.data.room.db.dto.AccessToken
import co.kr.cobosys.data.room.db.dto.User

@Database(entities = [AccessToken::class, User::class], version = 1, exportSchema = false)
abstract class BaroderRoomDatabase: RoomDatabase() {
    abstract fun accessTokenDao(): AccessTokenDao
    abstract fun userDao(): UserDao
}
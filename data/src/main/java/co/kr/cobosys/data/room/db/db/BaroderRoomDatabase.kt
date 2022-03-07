package co.kr.cobosys.data.room.db.db

import androidx.room.Database
import androidx.room.RoomDatabase
import co.kr.cobosys.data.room.db.dao.AccessTokenDao
import co.kr.cobosys.data.room.db.dao.MemberDao
import co.kr.cobosys.data.room.db.dto.RoomAccessToken
import co.kr.cobosys.data.room.db.dto.RoomMember

@Database(entities = [RoomAccessToken::class, RoomMember::class], version = 1, exportSchema = false)
abstract class BaroderRoomDatabase: RoomDatabase() {
    abstract fun accessTokenDao(): AccessTokenDao
    abstract fun memberDao(): MemberDao
}
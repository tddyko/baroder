package co.kr.cobosys.data.datasources.local.accesstoken

import co.kr.cobosys.data.room.db.dao.AccessTokenDao
import co.kr.cobosys.data.room.db.dto.RoomAccessToken
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocalAccessTokenDataSource {

    suspend fun insertAccessToken(token: RoomAccessToken)
    fun getAccessToken(): Flow<RoomAccessToken>
    suspend fun delAccessToken()
}

class LocalAccessTokenDataSourceImpl @Inject constructor(
    private val dao: AccessTokenDao
): LocalAccessTokenDataSource {
    override suspend fun insertAccessToken(token: RoomAccessToken) = dao.insertToken(token)

    override fun getAccessToken(): Flow<RoomAccessToken> = dao.getToken()

    override suspend fun delAccessToken() = dao.delToken()

}
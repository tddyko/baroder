package co.kr.cobosys.domain.repos.local.accesstoken

import co.kr.cobosys.domain.models.LocalAccessToken
import kotlinx.coroutines.flow.Flow

interface LocalAccessTokenRepo {

    suspend fun insertLocalAccessToken(token: LocalAccessToken)
    fun getLocalAccessToken(): Flow<LocalAccessToken>
    suspend fun delLocalAccessToken()

}
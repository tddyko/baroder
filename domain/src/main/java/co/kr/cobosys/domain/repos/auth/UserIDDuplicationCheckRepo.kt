package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.UserIDDuplicationCheck
import kotlinx.coroutines.flow.Flow

interface UserIDDuplicationCheckRepo {
    fun getUserIDDuplicationCheck(): Flow<UserIDDuplicationCheck>
}
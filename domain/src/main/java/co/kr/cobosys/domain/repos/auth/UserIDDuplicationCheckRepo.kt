package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.UserIDDuplicationCheckModel
import kotlinx.coroutines.flow.Flow

interface UserIDDuplicationCheckRepo {
    fun getUserIDDuplicationCheck(): Flow<UserIDDuplicationCheckModel>
}
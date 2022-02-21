package co.kr.cobosys.domain.repos

import co.kr.cobosys.domain.models.SharedMessage
import kotlinx.coroutines.flow.Flow

interface SharedMessageRepo {
    fun getSharedMessage(): Flow<SharedMessage>
}
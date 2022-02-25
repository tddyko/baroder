package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.UserIDDuplicationCheckModel

interface UserIDDuplicationCheckRepo {
    fun getUserIDDuplicationCheck(): UserIDDuplicationCheckModel
}
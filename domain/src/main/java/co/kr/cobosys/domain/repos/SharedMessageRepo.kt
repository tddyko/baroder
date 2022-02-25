package co.kr.cobosys.domain.repos

import co.kr.cobosys.domain.models.SharedMessageModel

interface SharedMessageRepo {
    fun getSharedMessage(): SharedMessageModel
}
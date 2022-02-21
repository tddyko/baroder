package co.kr.cobosys.domain.repos.home

import co.kr.cobosys.domain.models.Home
import kotlinx.coroutines.flow.Flow

interface HomeRepo {
    fun getHome(): Flow<Home>
}
package co.kr.cobosys.domain.repos.home

import co.kr.cobosys.domain.models.HomeModel
import kotlinx.coroutines.flow.Flow

interface HomeRepo {
    fun getHome(): Flow<HomeModel>
}
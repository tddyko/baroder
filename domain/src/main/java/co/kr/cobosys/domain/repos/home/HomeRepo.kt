package co.kr.cobosys.domain.repos.home

import co.kr.cobosys.domain.models.HomeModel

interface HomeRepo {
    fun getHome(): HomeModel
}
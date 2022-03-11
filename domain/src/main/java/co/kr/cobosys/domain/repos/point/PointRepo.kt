package co.kr.cobosys.domain.repos.point

import co.kr.cobosys.domain.models.PointModel
import kotlinx.coroutines.flow.Flow

interface PointRepo {
    fun getPoint(token: String): Flow<PointModel>
}
package co.kr.cobosys.domain.usecases.point

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.PointModel
import co.kr.cobosys.domain.repos.point.PointRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPointUseCase @Inject constructor(
    private val point: PointRepo
) : GeneralPagingUseCase<Flow<PointModel>, GetPointListParams> {
    override fun invoke(params: GetPointListParams): Flow<PointModel> =
        point.getPoint(params.ids)
}

@JvmInline
value class GetPointListParams(val ids: String)
package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.UserIDDuplicationCheckResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.UserIDDuplicationCheckData
import co.kr.cobosys.domain.models.UserIDDuplicationCheckModel

class UserIDDuplicationCheckMapper: Mapper<UserIDDuplicationCheckResponseModel, UserIDDuplicationCheckModel> {
    override fun mapLeftToRight(obj: UserIDDuplicationCheckResponseModel): UserIDDuplicationCheckModel = with(obj) {
       UserIDDuplicationCheckModel(
           code = code,
           message = message,
           data = UserIDDuplicationCheckData(data.isDuplication)
       )
    }
}
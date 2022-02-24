package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.MemberInfoResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.MemberInfoData
import co.kr.cobosys.domain.models.MemberInfoModel

class MemberInfoMapper : Mapper<MemberInfoResponseModel, MemberInfoModel> {
    override fun mapLeftToRight(obj: MemberInfoResponseModel): MemberInfoModel = with(obj) {
        MemberInfoModel(
            code = code,
            message = message,
            data = data.map { data ->
                MemberInfoData(
                    data.memberId,
                    data.memberName,
                    data.memberBirthDay,
                    data.memberGender,
                    data.memberPhoneNum,
                    data.memberQrCode
                )
            }
        )
    }
}
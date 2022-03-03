package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.MemberInfoResponseData
import co.kr.cobosys.data.api.MemberInfoResponseModel
import co.kr.cobosys.domain.models.MemberInfoData
import co.kr.cobosys.domain.models.MemberInfoModel

fun MemberInfoResponseModel.toMemberInfoModel(): MemberInfoModel = MemberInfoModel(
    code, message, data = data.map { data ->
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

fun MemberInfoModel.toMemberInfoResponseModel(): MemberInfoResponseModel = MemberInfoResponseModel(
    code, message, data = data.map { data ->
        MemberInfoResponseData(
            data.memberId,
            data.memberName,
            data.memberBirthDay,
            data.memberGender,
            data.memberPhoneNum,
            data.memberQrCode
        )
    }
)
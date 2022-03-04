package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.MemberInfoDataUI
import co.kr.cobosys.baroder.models.MemberInfoModelUI
import co.kr.cobosys.domain.models.MemberInfoData
import co.kr.cobosys.domain.models.MemberInfoModel

fun MemberInfoModelUI.toMemberInfoModel(): MemberInfoModel = MemberInfoModel(
    code, message, data = MemberInfoData(
        data.memberId,
        data.memberName,
        data.memberBirthDay,
        data.memberGender,
        data.memberPhoneNum,
        data.memberQrCode
    )
)

fun MemberInfoModel.toMemberInfoModelUI(): MemberInfoModelUI = MemberInfoModelUI(
    code, message, data = MemberInfoDataUI(
        data.memberId,
        data.memberName,
        data.memberBirthDay,
        data.memberGender,
        data.memberPhoneNum,
        data.memberQrCode
    )
)
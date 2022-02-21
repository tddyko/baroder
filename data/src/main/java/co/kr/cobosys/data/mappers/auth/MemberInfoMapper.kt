package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.MemberInfoResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.MemberInfo

class MemberInfoMapper: Mapper<MemberInfoResponse, MemberInfo> {
    override fun mapLeftToRight(obj: MemberInfoResponse): MemberInfo = with(obj) {
      MemberInfo(
          memberId = memberId,
          memberName = memberName,
          memberBirthDay = memberBirthDay,
          memberGender = memberGender,
          memberPhoneNum = memberPhoneNum,
          memberQrCode = memberQrCode
      )
    }
}
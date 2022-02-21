package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.MemberInfoUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.MemberInfo

class MemberInfoMapper: Mapper<MemberInfo, MemberInfoUI> {
    override fun mapLeftToRight(obj: MemberInfo): MemberInfoUI = with(obj) {
      co.kr.cobosys.baroder.models.MemberInfoUI(
          memberId = memberId,
          memberName = memberName,
          memberBirthDay = memberBirthDay,
          memberGender = memberGender,
          memberPhoneNum = memberPhoneNum,
          memberQrCode = memberQrCode
      )
    }
}
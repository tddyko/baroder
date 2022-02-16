package co.kr.cobosys.baroder.model.mappers.auth

import co.kr.cobosys.baroder.model.MemberInfoUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.MemberInfo

class MemberInfoMapper: Mapper<MemberInfo, MemberInfoUI> {
    override fun mapLeftToRight(obj: MemberInfo): MemberInfoUI = with(obj) {
      co.kr.cobosys.baroder.model.MemberInfoUI(
          memberId = memberId,
          memberName = memberName,
          memberBirthDay = memberBirthDay,
          memberGender = memberGender,
          memberPhoneNum = memberPhoneNum,
          memberQrCode = memberQrCode
      )
    }
}
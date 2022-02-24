package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.MemberInfoDataUI
import co.kr.cobosys.baroder.models.MemberInfoModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.MemberInfoModel

class MemberInfoMapper: Mapper<MemberInfoModel, MemberInfoModelUI> {
    override fun mapLeftToRight(obj: MemberInfoModel): MemberInfoModelUI = with(obj) {
      MemberInfoModelUI(
          code = code,
          message = message,
          data = data.map { data ->
              MemberInfoDataUI(
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
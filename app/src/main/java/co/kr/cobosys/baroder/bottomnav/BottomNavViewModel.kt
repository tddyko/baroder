package co.kr.cobosys.baroder.bottomnav

import co.kr.cobosys.baroder.base.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class BottomType {
    HOME,
    STORE,
    COUPON,
    POINT,
    SHOP
}

@HiltViewModel
class BottomNavViewModel @Inject constructor(): BaseViewModel(){



}
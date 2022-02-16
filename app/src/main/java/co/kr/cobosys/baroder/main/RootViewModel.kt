package co.kr.cobosys.baroder.main

import co.kr.cobosys.baroder.base.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

enum class ViewType {
    HOME,
    STORE,
    COUPON,
    POINT,
    SHOP
}

@HiltViewModel
class RootViewModel @Inject constructor(): Base {
    private val _userAuthResult = MutableStateFlow(false)
    val userAuthResult = _userAuthResult.asStateFlow()

    init {
        goHome()
    }

    private fun goHome() {
        _userAuthResult.value = true
    }
}

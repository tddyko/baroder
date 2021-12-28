package co.kr.cobosys.baroder.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(): ViewModel() {
    private val _userAuthResult = MutableStateFlow(false)
    val userAuthResult = _userAuthResult.asStateFlow()

    init {
        goHome()
    }

    private fun goHome() {
        _userAuthResult.value = true
    }

}

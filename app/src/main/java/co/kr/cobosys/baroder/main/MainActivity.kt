package co.kr.cobosys.baroder.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ActivityMainBinding
import co.kr.cobosys.baroder.extension.viewInflateBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewInflateBinding(ActivityMainBinding::inflate)
    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTheme(R.style.Theme_Baroder)
    }


    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onBackPressed() {
        if (isTaskRoot
            && supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.backStackEntryCount == 0
            && supportFragmentManager.backStackEntryCount == 0
        ) {
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        if (isTaskRoot && isFinishing) {
            finishAfterTransition()
        }
        super.onDestroy()
    }

    private fun setUpNav() {



        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_fragment,
                R.id.store_fragment,
                R.id.coupon_fragment,
                R.id.point_fragment,
                R.id.shop_fragment
            )
        )

    }

}
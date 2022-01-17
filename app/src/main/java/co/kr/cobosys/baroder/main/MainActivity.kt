package co.kr.cobosys.baroder.main

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ActivityMainBinding
import co.kr.cobosys.baroder.extension.viewInflateBinding
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewInflateBinding(ActivityMainBinding::inflate)
    private val toolBar: MaterialToolbar by lazy { binding.rootToolbar }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Baroder)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setNav()
    }

    override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()

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

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setNav() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        toolBar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolBar.setNavigationIcon(R.drawable.ic_move_icon_left)
            when (destination.id) {
//                R.id.root_fragment,
//                R.id.bottom_navigation_fragment,
                R.id.home_fragment,
                R.id.store_fragment,
                R.id.coupon_fragment,
                R.id.point_fragment,
                R.id.shop_fragment
                -> toolBar.visibility = View.GONE
//                R.id.home_mypage
//                -> {
//                    toolBar.setBackgroundColor(getColor(R.color.mainGreen))
//                    window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.white)
//                }
                else -> {
                    toolBar.visibility = View.VISIBLE
                }
            }
        }
    }
}
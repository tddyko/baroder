package co.kr.cobosys.baroder.main

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ActivityMainBinding
import co.kr.cobosys.baroder.extension.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewInflateBinding(ActivityMainBinding::inflate)
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Baroder)
        super.onCreate(savedInstanceState)
        
        installSplashScreen()
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

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.rootActivityToolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.rootActivityToolbar.setNavigationIcon(R.drawable.ic_move_icon_left)
            when (destination.id) {
                R.id.root_fragment,
                R.id.bottom_navigation_fragment,
                R.id.sign_in_fragment,
                -> {
                    binding.rootActivityToolbar.gone()
                    binding.rootActivityAppBarLayout.elevation = 0f
                    binding.rootActivityToolbar.setBackgroundColor(getColor(R.color.white))
                }
                R.id.mypage_fragment
                -> {
                    binding.rootActivityToolbar.visible()
                    binding.rootActivityAppBarLayout.elevation = 0f
                    binding.rootActivityToolbar.elevation = 0f
                    binding.rootActivityToolbar.setBackgroundColor(getColor(R.color.main_green))
                    binding.rootActivityToolbar.setTitleTextColor(getColor(R.color.white))
                }
                else -> {
                    binding.rootActivityToolbar.visible()
                    window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                    binding.rootActivityToolbar.setBackgroundColor(getColor(R.color.white))
                    binding.rootActivityToolbar.setNavigationIconTint(getColor(R.color.secondary_text_color))
                }
            }
        }
    }
}
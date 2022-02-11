package co.kr.cobosys.baroder.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ActivityMainBinding
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewInflateBinding
import co.kr.cobosys.baroder.extension.visible
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
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
                    window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                    window.statusBarColor =
                        ContextCompat.getColor(applicationContext, R.color.white)
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                }
                R.id.mypage_fragment
                -> {
                    binding.rootActivityToolbar.visible()
                    binding.rootActivityToolbar.setBackgroundColor(getColor(R.color.main_green))
                    binding.rootActivityAppBarLayout.elevation = 0f
                    binding.rootActivityToolbar.setNavigationIconTint(getColor(R.color.white))
                    binding.rootActivityToolbar.setTitleTextColor(getColor(R.color.white))
                    window.statusBarColor =
                        ContextCompat.getColor(applicationContext, R.color.main_green)
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                }
                else -> {
                    binding.rootActivityToolbar.visible()
                    window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                    binding.rootActivityToolbar.setBackgroundColor(getColor(R.color.white))
                    binding.rootActivityToolbar.setNavigationIconTint(getColor(R.color.secondary_text_color))
                    window.statusBarColor =
                        ContextCompat.getColor(applicationContext, R.color.white)
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                }
            }
        }
    }
}
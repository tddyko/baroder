package co.kr.cobosys.baroder.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ActivityMainBinding
import co.kr.cobosys.baroder.base.utils.Edge
import co.kr.cobosys.baroder.base.utils.edgeToEdge
import co.kr.cobosys.baroder.extension.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewInflateBinding(ActivityMainBinding::inflate)
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Baroder)
        super.onCreate(savedInstanceState)
        edgeToEdge {
            if(binding.rootActivityToolbar.visibility == View.VISIBLE) {
                binding.rootActivityToolbar.fit { Edge.TopArc }
            }
        }
        installSplashScreen()
        setContentView(binding.root)
        setNav()
    }

    override fun onResume() {
        super.onResume()
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

    @SuppressLint("NewApi")
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
                }
                R.id.mypage_fragment
                -> {
                    binding.rootActivityToolbar.visible()
                    binding.rootActivityToolbar.setBackgroundColor(getColor(R.color.main_green))
                    binding.rootActivityToolbar.setTitleTextColor(getColor(R.color.white))
                    binding.rootActivityToolbar.setNavigationIconTint(getColor(R.color.white))
                    binding.rootActivityAppBarLayout.elevation = 0f

                }
                else -> {
                    binding.rootActivityToolbar.visible()
                }
            }
        }
    }
}
package co.kr.cobosys.baroder.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentOnboardingBinding
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.invisible
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import dagger.hilt.android.AndroidEntryPoint

class OnBoardingItem(itemView: View) : RecyclerView.ViewHolder(itemView)

class OnBoardingPagerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context

        return when (viewType) {
            0 -> OnBoardingItem(
                LayoutInflater.from(context).inflate(R.layout.item_onboarding_first, parent, false)
            )
            1 -> OnBoardingItem(
                LayoutInflater.from(context).inflate(R.layout.item_onboarding_second, parent, false)
            )
            else -> OnBoardingItem(
                LayoutInflater.from(context).inflate(R.layout.item_onboarding_third, parent, false)
            )
        }

    }

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}

}

@AndroidEntryPoint
class OnBoardingDialog : DialogFragment(R.layout.fragment_onboarding) {

    private val binding by viewBinding(FragmentOnboardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onboardingViewpager.adapter = OnBoardingPagerAdapter()

        binding.onboardingIndicator.setViewPager2(binding.onboardingViewpager)
        binding.nextBtn.setOnClickListener {
            binding.onboardingViewpager.currentItem = binding.onboardingViewpager.currentItem + 1
        }
        binding.skipBtn.setOnClickListener {
            dismiss()
        }
        binding.onboardingComplete.setOnClickListener {
            dismiss()
        }

        binding.onboardingBackBtn.setOnClickListener {
            dismiss()
        }

        binding.onboardingViewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                binding.nextBtn.isEnabled = 2 != position
                if (2 == position) {
                    binding.onboardingComplete.visible()
                    binding.nextBtn.invisible()
                    binding.skipBtn.invisible()
                } else {
                    binding.onboardingComplete.invisible()
                    binding.nextBtn.visible()
                    binding.skipBtn.visible()
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setWindowAnimations(R.style.DialogAnimationSlideLeftOutRight)
    }

    companion object {
        fun show(fragmentMgr: FragmentManager) {
            val dlg = OnBoardingDialog()

            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
            dlg.show(fragmentMgr, "onBoarding")
        }
    }
}
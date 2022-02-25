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
import co.kr.cobosys.baroder.extension.viewBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import dagger.hilt.android.AndroidEntryPoint

//class OnBoardingFragment: Fragment() {
//    private val binding by viewInflateBinding(FragmentOnboardingBinding::inflate)
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding.onboardingViewpager.adapter = OnBoardingPagerAdapter()
//        binding.onboardingIndicator.setViewPager2(binding.onboardingViewpager)
//        binding.nextBtn.setOnClickListener {
//            binding.onboardingViewpager.currentItem = binding.onboardingViewpager.currentItem + 1
//        }
//        binding.onboardingViewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//                binding.nextBtn.isEnabled = 2 != position
//            }
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//                super.onPageScrollStateChanged(state)
//            }
//        })
//
//        return binding.root
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        super.onViewCreated(view, savedInstanceState)
//    }
//}

class OnBoardingItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
}

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

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 3
    }
}

@AndroidEntryPoint
class OnBoardingDialog : DialogFragment(R.layout.fragment_onboarding) {
    val binding by viewBinding(FragmentOnboardingBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewpager = binding.onboardingViewpager
        val indicator = binding.onboardingIndicator
        val nextBtn = binding.nextBtn
        val skipBtn = binding.skipBtn
        val completeBtn = binding.onboardingComplete

        viewpager.adapter = OnBoardingPagerAdapter()
        indicator.setViewPager2(viewpager)
        nextBtn.setOnClickListener {
            viewpager.currentItem = viewpager.currentItem + 1
        }
        skipBtn.setOnClickListener {
            dismiss()
        }
        completeBtn.setOnClickListener {
            dismiss()
        }
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                nextBtn.isEnabled = 2 != position
                if (2 == position) {
                    completeBtn.visibility = View.VISIBLE
                    nextBtn.visibility = View.INVISIBLE
                    skipBtn.visibility = View.INVISIBLE
                } else {
                    completeBtn.visibility = View.INVISIBLE
                    nextBtn.visibility = View.VISIBLE
                    skipBtn.visibility = View.VISIBLE
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
package com.dtech.darussalam.view.tour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.ActivityTourBinding
import com.dtech.darussalam.utilities.helper.VPDashBoardAdapter
import com.dtech.darussalam.view.auth.AuthActivity
import com.sangcomz.fishbun.BaseActivity

class TourActivity : BaseActivity(), ViewPager.OnPageChangeListener  , View.OnClickListener{

    lateinit var binding: ActivityTourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tour)

        setListeners()
        setupPager()
    }
    private fun setListeners(){
        binding.vpTour.addOnPageChangeListener(this)
        binding.btnGetStarted.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnGetStarted ->{
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }

    }

    private fun setupPager(){
        val adapter = VPDashBoardAdapter(supportFragmentManager)
        adapter.addFragment(TourOneFragment(), "TourPage1Fragment")
        adapter.addFragment(TourTwoFragment(), "TourPage2Fragment")
        adapter.addFragment(TourThreeFragment(), "TourPage3Fragment")
        binding.vpTour.adapter = adapter
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                binding.btnGetStarted.visibility = View.INVISIBLE
                binding.tab1.setImageResource(R.drawable.ic_tour_select_one)
                binding.tab2.setImageResource(R.drawable.ic_unselect_tour)
                binding.tab3.setImageResource(R.drawable.ic_unselect_tour)
            }
            1 -> {
                binding.btnGetStarted.visibility = View.INVISIBLE
                binding.tab1.setImageResource(R.drawable.ic_unselect_tour)
                binding.tab2.setImageResource(R.drawable.ic_tour_select_one)
                binding.tab3.setImageResource(R.drawable.ic_unselect_tour)
            }

            2 -> {
                binding.btnGetStarted.visibility = View.VISIBLE
                binding.tab1.setImageResource(R.drawable.ic_unselect_tour)
                binding.tab2.setImageResource(R.drawable.ic_unselect_tour)
                binding.tab3.setImageResource(R.drawable.ic_tour_select_one)
            }

        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}
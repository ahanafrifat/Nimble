package com.ahanaf.nimble.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.ahanaf.nimble.R
import com.ahanaf.nimble.common.HomeIntroModel
import com.ahanaf.nimble.databinding.FragmentHomeBinding
import com.ahanaf.nimble.util.AppUtils

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(binding.root)
        initHomeScreen()
        initMessage()

        viewModel.loadHomeScreen()
    }

    private fun initHomeScreen() {
        viewModel.homeIntroMutableList.observe(viewLifecycleOwner) { homeIntroMutableList ->
            homeIntroMutableList?.let {
                initViewPager(it)
            }
        }
    }

    private fun initViewPager(list: List<HomeIntroModel>) {
        with(binding) {
            viewPager.adapter = ViewpageAdapter(list)
            viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            indicator.setViewPager(viewPager)

            floatingActionButton.setOnClickListener {

                if(floatingActionButton.isExtended){
                    gotoSurvey()
                }else {
                    viewPager.apply {
                        beginFakeDrag()
                        fakeDragBy(-50f)
                        endFakeDrag()
                    }
                }
            }

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    AppUtils.log("HomeFragment" , "list size: ${list.size}  position: $position ")
                    if(position +1 == list.size ){
                        AppUtils.log("HomeFragment" , "list size: ${list.size}  position: ${position +1} ")
                        floatingActionButton.extend()
                    }else{
                        floatingActionButton.shrink()
                    }
                }
            })

        }
    }

    private fun gotoSurvey() {
        navController.navigate(R.id.action_navigation_home_to_surveyFragment)
    }

    private fun initMessage() {
        viewModel.message.observe(viewLifecycleOwner) { message ->
            message?.let {
                AppUtils.message(binding.root, message)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
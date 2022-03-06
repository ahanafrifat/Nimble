package com.ahanaf.nimble.ui.survey

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.ahanaf.nimble.R
import com.ahanaf.nimble.databinding.SurveyFragmentBinding
import com.ahanaf.nimble.model.Attributes
import com.ahanaf.nimble.util.AppUtils

class SurveyFragment : Fragment() {

    companion object {
        fun newInstance() = SurveyFragment()
    }

    private val viewModel: SurveyViewModel by viewModels()
    private var _binding : SurveyFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.survey_fragment, container, false)
        _binding = SurveyFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(binding.root)

        initQuestions()
        initMessage()
        viewModel.loadQuestions()

        binding.fabCancel.setOnClickListener {
            showCancelMessage()
        }
    }

    private fun initQuestions() {
        viewModel.attributesMutableLiveData.observe(viewLifecycleOwner){attributes->
            attributes?.let {
                initViewPager(it)
            }
        }
    }

    private fun initViewPager(attributes: List<Attributes>) {

        with(binding){
            viewPager.adapter = SurveyViewpageAdapter(attributes)
            viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            floatingActionButton.setOnClickListener {
                if(floatingActionButton.isExtended){
                    gotoFinish()
                }
                else {
                    viewPager.apply {
                        beginFakeDrag()
                        fakeDragBy(-50f)
                        endFakeDrag()
                    }
                }
            }

            viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if(position +1 == attributes.size ){
                        AppUtils.log("SurveyFragment" , "list size: ${attributes.size}  position: ${position +1} ")
                        floatingActionButton.extend()
                    }else{
                        floatingActionButton.shrink()
                    }
                }
            })




        }
    }

    private fun gotoFinish() {

    }

    private fun initMessage() {
        viewModel.message.observe(viewLifecycleOwner){message->
            message?.let {
                AppUtils.message(binding.root, it)
            }
        }
    }

    private fun showCancelMessage() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
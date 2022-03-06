package com.ahanaf.nimble.ui.survey

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahanaf.nimble.R
import com.ahanaf.nimble.model.Attributes
import com.ahanaf.nimble.util.AppUtils

class SurveyViewpageAdapter(private var attributes: List<Attributes>) : RecyclerView.Adapter<SurveyViewpageAdapter.Pager2ViewHolder>(){

    inner class Pager2ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val itemPageNo : TextView = itemView.findViewById(R.id.pageNo)
        val itemQuestions : TextView = itemView.findViewById(R.id.questions)
        val itemAnswers : NumberPicker = itemView.findViewById(R.id.picker)
        val itemImage : ImageView = itemView.findViewById(R.id.image)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SurveyViewpageAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.survey_page, parent, false) )
    }

    override fun onBindViewHolder(holder: SurveyViewpageAdapter.Pager2ViewHolder, position: Int) {
        with(holder){

            val answers = arrayOf("Very fulfilled", "Somewhat fulfilled", "Somewhat unfulfilled")
            val pageNo = " ${position+1}/${attributes.size}"

            itemPageNo.text = pageNo
            itemQuestions.text = attributes[position].description

            itemAnswers.minValue = 0
            itemAnswers.maxValue = answers.size -1
            itemAnswers.displayedValues = answers
            itemAnswers.wrapSelectorWheel =true

//            itemAnswers.setOnValueChangedListener { numberPicker, i, i2 ->
//                AppUtils.log("SurveyViewpage", "Answers : ${itemAnswers.value}")
//            }
        }
    }

    override fun getItemCount(): Int {
        return attributes.size
    }


}
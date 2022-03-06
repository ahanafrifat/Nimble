package com.ahanaf.nimble.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahanaf.nimble.R
import com.ahanaf.nimble.common.HomeIntroModel
import com.ahanaf.nimble.util.AppUtils

class ViewpageAdapter(
    private var homeIntroModel: List<HomeIntroModel>
) : RecyclerView.Adapter<ViewpageAdapter.Pager2ViewHolder>() {

//    private var title: List<String>,
//    private var details: List<String>,
//    private var images: List<Int>

    inner class Pager2ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val itemDate :TextView =itemView.findViewById(R.id.date)
        val itemToday :TextView =itemView.findViewById(R.id.today)
        val itemTitle :TextView =itemView.findViewById(R.id.title)
        val itemDescription :TextView =itemView.findViewById(R.id.description)
        val itemImage :ImageView =itemView.findViewById(R.id.image)

        init {

            itemImage.setOnClickListener {
                val position = adapterPosition
                AppUtils.log("ViewpageAdapter" , "ViewpageAdapter no : ${position + 1}")
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewpageAdapter.Pager2ViewHolder {

        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun onBindViewHolder(holder: ViewpageAdapter.Pager2ViewHolder, position: Int) {
        with(holder){
            val homeIntroModel = homeIntroModel[position]
            itemDate.text = homeIntroModel.date
            itemToday.text = homeIntroModel.today
            itemTitle.text = homeIntroModel.title
            itemDescription.text = homeIntroModel.description
            itemImage.setImageResource(homeIntroModel.image)
        }
    }


    override fun getItemCount(): Int {
        return homeIntroModel.size
    }

}
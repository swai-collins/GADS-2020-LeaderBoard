package com.example.leaderboard.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboard.BR
import com.example.leaderboard.HoursItem
import com.example.leaderboard.R
import com.example.leaderboard.databinding.ActivitySubmitBinding
import com.example.leaderboard.databinding.ItemLearnerBinding


@SuppressLint("SetTextI18n")
class HoursAdapter(
    learners: List<HoursItem> = arrayListOf()
) : RecyclerView.Adapter<HoursAdapter.ViewHolder>() {
    var learners = learners
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = DataBindingUtil.inflate<ItemLearnerBinding>(LayoutInflater.from(parent.context), R.layout.item_learner, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(learners[position])
    }

    override fun getItemCount() = learners.count()

    class ViewHolder(val binding: ItemLearnerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(learner: HoursItem) {
            run {
                binding.setVariable(BR.model, learner)
            }
        }
    }
}
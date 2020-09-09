package com.example.leaderboard.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboard.BR
import com.example.leaderboard.R
import com.example.leaderboard.SkillItem
import com.example.leaderboard.databinding.ItemLearnerBinding
import com.example.leaderboard.databinding.ItemSkillIqBinding


@SuppressLint("SetTextI18n")
class SkillIqAdapter(
    learners: List<SkillItem> = arrayListOf()
) : RecyclerView.Adapter<SkillIqAdapter.ViewHolder>() {
    var learners = learners
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = DataBindingUtil.inflate<ItemSkillIqBinding>(LayoutInflater.from(parent.context), R.layout.item_skill_iq, parent, false)
        return SkillIqAdapter.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(learners[position])
    }

    override fun getItemCount() = learners.count()

    class ViewHolder(val binding: ItemSkillIqBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(learner: SkillItem) {
            run {
                binding.setVariable(BR.model, learner)
            }
        }

    }
}
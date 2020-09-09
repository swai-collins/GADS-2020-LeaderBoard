package com.example.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.LinearLayoutBindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leaderboard.adapter.HoursAdapter
import com.example.leaderboard.databinding.FragmentLearningLeadersBinding

class LearningLeadersFragment: Fragment(){

    lateinit var binding: FragmentLearningLeadersBinding
    val viewModel: LeaderBoardViewModel by viewModels{
        LeaderBoardViewModelFactory(LeaderBoardRepository(LeaderBoardApi.invoke()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_learning_leaders, container, false)


        binding.learningRecycler.apply {
            this.adapter = HoursAdapter()
            this.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.fetchTopHourLearners()
        viewModel.fetchTopHourLearner.observe(viewLifecycleOwner, Observer {
            val adapter = HoursAdapter(it)
            binding.learningRecycler.adapter = adapter
        })

        return binding.root
    }
}
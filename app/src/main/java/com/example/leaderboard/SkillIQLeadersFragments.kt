package com.example.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leaderboard.adapter.HoursAdapter
import com.example.leaderboard.adapter.SkillIqAdapter
import com.example.leaderboard.databinding.FragmentLearningLeadersBinding
import com.example.leaderboard.databinding.FragmentSkillIqLeadersBinding

class SkillIQLeadersFragments : Fragment() {

    lateinit var binding: FragmentSkillIqLeadersBinding

    val viewModel: LeaderBoardViewModel by viewModels{
        LeaderBoardViewModelFactory(LeaderBoardRepository(LeaderBoardApi.invoke()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_skill_iq_leaders, container, false)

        binding.skillIqRecycler.apply {
            this.adapter = SkillIqAdapter()
            this.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.fetchTopIqLearners()
        viewModel.fetchTopIqLearners.observe(viewLifecycleOwner, Observer {
            val adapter =SkillIqAdapter(it)
            binding.skillIqRecycler.adapter = adapter
        })

        return binding.root
    }
}
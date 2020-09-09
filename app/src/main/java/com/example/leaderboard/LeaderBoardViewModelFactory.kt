package com.example.leaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LeaderBoardViewModelFactory (private val repository: LeaderBoardRepository)
    :ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHCKED CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LeaderBoardViewModel(repository) as T
    }
}
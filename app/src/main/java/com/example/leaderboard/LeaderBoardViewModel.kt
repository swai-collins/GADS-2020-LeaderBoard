package com.example.leaderboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Request
import java.security.cert.Extension

class LeaderBoardViewModel(private val repository: LeaderBoardRepository) : ViewModel() {

    private val _fetchTopHourLearner = MutableLiveData<List<HoursItem>>()
    val fetchTopHourLearner: LiveData<List<HoursItem>>
        get() = _fetchTopHourLearner

    private val _fetchTopIqLearners = MutableLiveData<List<SkillItem>>()
    val fetchTopIqLearners: LiveData<List<SkillItem>>
        get() = _fetchTopIqLearners

    fun fetchTopHourLearners() {
        GlobalScope.launch(Dispatchers.Main) {
            _fetchTopHourLearner.value = repository.getHours()


        }

    }

    fun fetchTopIqLearners() {
        GlobalScope.launch(Dispatchers.Main) {
            _fetchTopIqLearners.value = repository.getSkillIq()
        }
    }

    fun continueRequest(firstName:String, lastName:String,email:String,projectLink:String) {
        GlobalScope.launch(Dispatchers.Main) {
            repository.submitForm(firstName!!, lastName!!, email!!, projectLink!!)

        }
    }
}


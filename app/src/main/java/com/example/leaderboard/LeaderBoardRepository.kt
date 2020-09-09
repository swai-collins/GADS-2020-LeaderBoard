package com.example.leaderboard


class LeaderBoardRepository (private val api: LeaderBoardApi) : SafeApiResponse() {
    suspend fun getHours() = apiRequest { api.getHours() }

    suspend fun getSkillIq() = apiRequest { api.getSkillIq() }

    suspend fun submitForm(
        firstName: String,
        lastName: String,
        email: String,
        projectLink: String
    ) = apiSubmit {api.ProjectSubmit(firstName,lastName,email,projectLink)}


}
package com.example.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.leaderboard.databinding.ActivitySubmitBinding
import com.example.leaderboard.databinding.DialogueActionBinding
import kotlinx.android.synthetic.main.activity_submit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SubmitActivity: AppCompatActivity(){
//    val viewModel: LeaderBoardViewModel by viewModels{
//        LeaderBoardViewModelFactory(LeaderBoardRepository(LeaderBoardApi.invoke()))
//    }
    private lateinit var binding: ActivitySubmitBinding
    private val retrofit = Retrofit.Builder().baseUrl(Post_Base_Url).addConverterFactory(GsonConverterFactory.create()).build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit)


        val myToolbar = binding.toolbar2
        setSupportActionBar(toolbar2)
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btn_submit.setOnClickListener {
            showConfirmationDialog()
        }

    }
    private fun sendData(firstName:String, lastName:String, email:String, projectLink:String){

        val service = retrofit.create(LeaderBoardApi::class.java)

        service.ProjectSubmit(firstName,lastName,email,projectLink).enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                showSuccessDialog()
                Toast.makeText(applicationContext,"Data Posted",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                showFailureDialog()
                Toast.makeText(applicationContext,"Data not Posted", Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun showConfirmationDialog() {
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)

        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.dialogue_query, viewGroup, false)

        val yes : Button = dialogView.findViewById(R.id.query_submit)
        val close : ImageView = dialogView.findViewById(R.id.query_cancel)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.show()

        close.setOnClickListener {
            alertDialog.dismiss()
        }

        yes.setOnClickListener {
            sendData(enterfirstName.text.toString(),enterLastName.text.toString(),enteremailName.text.toString(),enterprojectLink.text.toString())
            alertDialog.dismiss()
        }
    }
    private fun showSuccessDialog(){
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.dialogue_action, viewGroup, false)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.show()

    }
    private fun showFailureDialog(){
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.dialogue_cancel, viewGroup, false)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.show()
    }

    //setting navigate up button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


}

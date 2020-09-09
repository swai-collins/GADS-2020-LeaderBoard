package com.example.leaderboard

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.leaderboard.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class HomeActivity : AppCompatActivity(){


    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setSupportActionBar(binding.toolbar)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = viewPagerAdapter
        binding.tab.setupWithViewPager(binding.viewPager)


        val repository = LeaderBoardRepository(LeaderBoardApi())


//        GlobalScope.launch(Dispatchers.Main) {
//            val hours = repository.getHours()
//            val SkillIq = repository.getSkillIq()
//
//            Toast.makeText(this@HomeActivity, hours.toString(), Toast.LENGTH_LONG).show()
//            Toast.makeText(this@HomeActivity, SkillIq.toString(), Toast.LENGTH_LONG).show()
//
//        }

        binding.submitBtn.setOnClickListener{
            startActivity(Intent(this,SubmitActivity::class.java))
        }

    }





}
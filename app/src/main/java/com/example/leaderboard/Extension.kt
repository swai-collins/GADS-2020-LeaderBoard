package com.example.leaderboard

import android.content.Context
import android.net.ConnectivityManager
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import java.security.AccessControlContext


@BindingAdapter(value = ["imgUri"])
fun ImageView.loadImage(imageUri: String?){
        imageUri?.let {
            Picasso.get().load(it).into(this)
        }
}

//fun InternetConnection(context: Context) : Boolean{
//    val mConMgr :ConnectivityManager  = context.getSystemService(Context.CONNECTIVITY_SERVICE)
//    return mConMgr.activeNetwork
//}
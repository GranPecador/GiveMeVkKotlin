package com.example.givemevkkotlin.adapters

import android.arch.lifecycle.ViewModel
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.givemevkkotlin.R
import com.example.givemevkkotlin.models.FriendModel

class FriendsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var mFriendsList: ArrayList<FriendModel> = ArrayList()

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    override fun getItemCount(): Int {
        return mFriendsList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, parent, false);
        return FriendsViewHolder(itemView = itemView)
    }


    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}
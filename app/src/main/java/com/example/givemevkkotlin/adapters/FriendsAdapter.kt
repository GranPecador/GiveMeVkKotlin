package com.example.givemevkkotlin.adapters

import android.arch.lifecycle.ViewModel
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.givemevkkotlin.R
import com.example.givemevkkotlin.models.FriendModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class FriendsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mSourceList : ArrayList<FriendModel> = ArrayList()
    private var mFriendsList: ArrayList<FriendModel> = ArrayList()

    fun setupFriends(friendsList:ArrayList<FriendModel>){
        mSourceList.clear()
        mSourceList.addAll(friendsList)
        filter("")
    }

    fun filter(query: String){
        mFriendsList.clear()
        mSourceList.forEach{
            if(it.name.contains(query, ignoreCase = true) || it.surname.contains(query, ignoreCase = true))
                mFriendsList.add(it)
            else
                it.city?.let {city ->
                    if (city.contains(query, ignoreCase = true))
                        mFriendsList.add(it)}
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is FriendsViewHolder)
            holder.bind(friendModel = mFriendsList[position])
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

            private var mCivAvatar:CircleImageView = itemView.findViewById(R.id.civ_avatar_friend_item)
            private var mTxtName : TextView = itemView.findViewById(R.id.txt_name_friend_item)
            private var mTxtCity : TextView = itemView.findViewById(R.id.txt_city_friend_item)
            private var mImgOnline : ImageView = itemView.findViewById(R.id.img_online_friend_item)

        fun bind(friendModel: FriendModel){
            friendModel.avatar?.let { url ->
                Picasso.get().load(url).into(mCivAvatar)
            }
            mTxtName.text = "${friendModel.name} ${friendModel.surname}"
            mTxtCity.text = itemView.context.getString(R.string.no_city)
            friendModel.city?.let { mTxtCity.text = it}
            if (friendModel.isOnline)
                mImgOnline.visibility = View.VISIBLE
            else
                mImgOnline.visibility = View.GONE
        }
    }
}
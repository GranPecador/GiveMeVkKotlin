package com.example.givemevkkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.givemevkkotlin.R
import com.example.givemevkkotlin.models.FriendModel
import com.example.givemevkkotlin.presenters.FriendsPresenter
import com.example.givemevkkotlin.views.FriendsView

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
    }

    //Friends view implementation
    override fun showError(text: String) {

    }

    override fun setupEmptyList() {

    }

    override fun setupFriendsList(friendsList: ArrayList<FriendModel>) {

    }
}

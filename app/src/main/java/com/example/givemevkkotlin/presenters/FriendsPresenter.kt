package com.example.givemevkkotlin.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.givemevkkotlin.R
import com.example.givemevkkotlin.models.FriendModel
import com.example.givemevkkotlin.providers.FriendsProvider
import com.example.givemevkkotlin.views.FriendsView

@InjectViewState
class FriendsPresenter : MvpPresenter<FriendsView>() {
    fun loadFriends(){
        viewState.startLoading()
        FriendsProvider(presenter = this).testLoadFriends(hasFriends = true)
    }
    fun loadedFriends(friendsList:ArrayList<FriendModel>){
        viewState.endLoading()
        if(friendsList.isEmpty()){
            viewState.setupEmptyList()
            viewState.showError(textResource = R.string.friends_no_items)
        } else {
            viewState.setupFriendsList(friendsList = friendsList)
        }
    }
}
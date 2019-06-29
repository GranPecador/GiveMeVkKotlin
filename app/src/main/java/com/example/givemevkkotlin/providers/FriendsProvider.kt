package com.example.givemevkkotlin.providers

import android.os.Handler
import com.example.givemevkkotlin.models.FriendModel
import com.example.givemevkkotlin.presenters.FriendsPresenter

class FriendsProvider(var presenter:FriendsPresenter) {
    fun testLoadFriends(hasFriends:Boolean) {
        Handler().postDelayed({
            val friendsList : ArrayList<FriendModel> = ArrayList()
            if (hasFriends) {
                val friendIvan = FriendModel("Ivan", "Ivanov", null, "http://i.imgur.com/DvpvklR.png", true)
                val friendVasya = FriendModel("Vasya", "Ivanov", "Moscow", "https://images.app.goo.gl/ZFzJvJ9mj8t2Qcjb8", false)
                val friendRain = FriendModel("Rain", "Petrov", "SPb", "https://vk.com/photo-23169544_456487279", true)
                friendsList.add(friendIvan)
                friendsList.add(friendRain)
                friendsList.add(friendVasya)
            }
            presenter.loadedFriends(friendsList = friendsList)
        }, 2000)
    }
}
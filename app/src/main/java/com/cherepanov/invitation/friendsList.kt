package com.cherepanov.invitation

class friendsList: jsonReader {

    fun whoInvitedMe(mutableList: MutableList<Friend>): Friend {
        var whoInvited = Friend()
        mutableList.forEach { if (it.status == "именины") whoInvited = it }
        return whoInvited
    }

    fun whoIsInvited(mutableList: MutableList<Friend>): MutableList<Friend>{
        val whoIsComing = mutableListOf<Friend>()
        mutableList.forEach { if (it.status == "придёт") whoIsComing.add(it)}
        return whoIsComing
    }

}
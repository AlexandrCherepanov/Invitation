package com.cherepanov.invitation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var allFriends = mutableListOf<Friend>()
    var mainFriend = Friend()
    var whoIsComing = mutableListOf<Friend>()

    var friendsList = friendsList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.title_activitybar)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val img_for_header = "https://s3-alpha-sig.figma.com/img/599e/c8b8/170a251979a7cba87bc05a5e50b63c65?Expires=1601251200&Signature=QwxgfuYArjz8AZtoAfby5FG4jK~8p4GsTPBA4YozHCmFuDxOQV8z~1O~w2-JnRjLzjM-dRDkWaLpv5CnW1xTdhJBMZLzJmzElMbKpIv196rhDVTWpPHUarskw8WHsRWKjiPWaWtrO4zgOmnWdjyOBNJv-KAdTrbM7YAK5x7cwgy-rZcDPEqYVUYUKbLrrQQTTRjAOK3vW9rnfiLRwT7AM1i-EI6HwHzWU65Q9IGcAjzjefusRul8d61PLK1RCnA9A8FaezF~dhVh0JqHC~8kbRjas0tByFBB3xhji09dj8LXBfHlfsxzqo-XRkYRUqhAMjd6duX0-QRe54vUFYGhRg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"
        Picasso.get().load(img_for_header).into(img_header)

        allFriends = friendsList.getAllFreindsFromAsset(this, "all.json")!!

        mainFriend = friendsList.whoInvitedMe(allFriends)
        Picasso.get().load(mainFriend.image).into(img_birthday)
        invited_friend.text = ("Пригласил(а): ${mainFriend.name}")

        whoIsComing = friendsList.whoIsInvited(allFriends)
        val recyclerView = findViewById<RecyclerView>(R.id.friends_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = FreindsAdapter(this, whoIsComing)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}



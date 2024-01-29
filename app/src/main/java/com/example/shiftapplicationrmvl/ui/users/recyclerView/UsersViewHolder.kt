package com.example.shiftapplicationrmvl.ui.users.recyclerView

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shiftapplicationrmvl.R
import com.example.shiftapplicationrmvl.data.User
import com.example.shiftapplicationrmvl.databinding.UsersViewHolderBinding

class UsersViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val picture = view.findViewById<ImageView>(R.id.vh_preview_pict)
    private val firstName = view.findViewById<TextView>(R.id.vh_first_name)
    private val lastName = view.findViewById<TextView>(R.id.vh_last_name)
    private val phoneNumber = view.findViewById<TextView>(R.id.vh_phone_number)
    private val address = view.findViewById<TextView>(R.id.vh_address)
    private val viewHolder = view.findViewById<RelativeLayout>(R.id.view_holder_layout)
    var onClick: ()->Unit = {}

    fun bind(user: User){

        firstName.text = "${user.name.title} ${user.name.firstName}"
        lastName.text = user.name.lastName
        phoneNumber.text = user.phoneNumber
        address.text = "${user.location.city}, ${user.location.street.name}, ${user.location.street.number}"
        Glide.with(picture)
            .load(user.picture.largeUrl)
            .into(picture)
        viewHolder.setOnClickListener { onClick() }
    }

}
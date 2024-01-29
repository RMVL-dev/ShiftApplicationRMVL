package com.example.shiftapplicationrmvl.ui.users.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shiftapplicationrmvl.R
import com.example.shiftapplicationrmvl.data.User

class UsersAdapter(
    private val usersList: List<User>
):RecyclerView.Adapter<UsersViewHolder>() {

    var onClick:(Int)->Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder =
        UsersViewHolder(
            view = LayoutInflater.from(parent.context).inflate(R.layout.users_view_holder, parent, false)
        )


    override fun getItemCount(): Int =
        usersList.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(user = usersList[position])
        holder.onClick = {
            onClick(position)
        }
    }
}
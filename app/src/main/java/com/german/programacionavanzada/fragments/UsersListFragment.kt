package com.german.programacionavanzada.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.german.programacionavanzada.R
import kotlinx.android.synthetic.main.fragment_users_list.*

class UsersListFragment : Fragment() {

    interface OnShowUserDetailListener {
        fun showUserDetail(name: String)
    }

    private var detailListener: OnShowUserDetailListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        detailListener = context as? OnShowUserDetailListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_users_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_user_detail.setOnClickListener {
            detailListener?.showUserDetail("German")
        }
    }
}

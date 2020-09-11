package com.german.programacionavanzada.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.german.programacionavanzada.R

class UserDetailFragment : Fragment() {

    companion object {
        fun newInstance(userName: String): UserDetailFragment {
            val fragment = UserDetailFragment()

            val arguments = Bundle()
            arguments.putString("user_name", userName)

            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_user_detail, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
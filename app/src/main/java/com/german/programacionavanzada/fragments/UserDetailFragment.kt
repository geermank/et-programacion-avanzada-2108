package com.german.programacionavanzada.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.german.programacionavanzada.R
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

    companion object {
        private const val KEY_USER_NAME = "user_name"

        fun newInstance(userName: String) = UserDetailFragment().apply {
            arguments = Bundle().apply { putString(KEY_USER_NAME, userName) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_user_detail, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userName = arguments?.getString(KEY_USER_NAME)
        tv_user_name.text = userName
    }
}

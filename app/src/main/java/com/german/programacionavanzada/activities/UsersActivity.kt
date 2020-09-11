package com.german.programacionavanzada.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.german.programacionavanzada.R
import com.german.programacionavanzada.fragments.UserDetailFragment
import com.german.programacionavanzada.fragments.UsersListFragment

class UsersActivity : AppCompatActivity(), UsersListFragment.OnShowUserDetailListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)

        /*val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, UsersListFragment())
        fragmentTransaction.commit()*/
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, UsersListFragment())
            .commit()
    }

    override fun showUserDetail(name: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, UserDetailFragment.newInstance(name))
            .commit()
    }
}

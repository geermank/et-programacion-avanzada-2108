package com.german.programacionavanzada.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.german.programacionavanzada.R
import com.german.programacionavanzada.RetrofitManager
import com.german.programacionavanzada.adapters.UsersAdapter
import com.german.programacionavanzada.api.ApiService
import com.german.programacionavanzada.extensions.hayUsuarios
import com.german.programacionavanzada.extensions.remove
import com.german.programacionavanzada.extensions.show
import com.german.programacionavanzada.models.User
import kotlinx.android.synthetic.main.fragment_users_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

        val retrofit = RetrofitManager()
        val api = retrofit.getApi()
        val apiCall: Call<List<User>> = api.getUsers()
        //apiCall.execute() // ejecutando la request sobre el thread donde se encuentra en este momento
        apiCall.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                hideLoading()
                Toast.makeText(context,"Tuvimos un problema", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                hideLoading()
                if (response.isSuccessful) {
                    val usersList = response.body()
                    handleUserListResponse(usersList!!)
                } else {
                    val code = response.code()
                    // TODO manejar el error
                }
            }
        })
    }

    private fun handleUserListResponse(usersList: List<User>) {
        val rvUsers: RecyclerView = rv_users
        val usersAdapter = UsersAdapter(usersList)
        val layoutManager = LinearLayoutManager(context)

        rvUsers.layoutManager = layoutManager
        rvUsers.adapter = usersAdapter
    }

    private fun hideLoading() {
        pb_loading_users.remove()
    }

    private fun showLoading() {
        pb_loading_users.show()
    }
}

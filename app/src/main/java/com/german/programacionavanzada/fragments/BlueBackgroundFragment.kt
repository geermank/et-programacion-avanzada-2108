package com.german.programacionavanzada.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.german.programacionavanzada.R
import com.german.programacionavanzada.activities.StaticFragmentsActivity
import kotlinx.android.synthetic.main.fragment_blue_background.*

class BlueBackgroundFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_blue_background, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_show.setOnClickListener {
            (activity as? StaticFragmentsActivity)?.show("Hola desde el fragment azul")
        }
    }
}

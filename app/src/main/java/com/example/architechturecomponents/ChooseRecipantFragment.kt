package com.example.architechturecomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipant.*
import kotlinx.android.synthetic.main.fragment_specify_amountfragment.cancel_btn

class ChooseRecipantFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        cancel_btn.setOnClickListener(this)
        next_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.cancel_btn -> {
                activity!!.onBackPressed()
            }

            R.id.next_btn -> {
                navController.navigate(R.id.action_chooseRecipantFragment_to_specifyAmountFragment)
            }
        }
    }
}

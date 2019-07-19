package com.example.architechturecomponents.Fragments


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.architechturecomponents.Models.Money
import com.example.architechturecomponents.R
import kotlinx.android.synthetic.main.fragment_specify_amountfragment.*
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var recipient : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments!!.getString("recipient")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amountfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)

        val messageToDisplay = "Sending money to $recipient"

        view.findViewById<TextView>(R.id.recipient).text = messageToDisplay

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    val amount = Money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf("recipient" to recipient,
                        "amount" to amount)
                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
                } else {
                    Toast.makeText(activity, "Please Enter amount", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> {
                activity!!.onBackPressed()
            }
        }
    }
}

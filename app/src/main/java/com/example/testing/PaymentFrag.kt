package com.example.testing

import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.testing.databinding.FragmentHomeScreenBinding
import com.example.testing.databinding.FragmentPaymentBinding
import java.text.NumberFormat


class PaymentFrag : Fragment() {
      private var _binding: FragmentPaymentBinding? = null
      private val binding get() = _binding!!

      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View? {
            // Inflate the layout for this fragment
            _binding = FragmentPaymentBinding.inflate(inflater, container, false)

            binding.amount.addTextChangedListener(
                       //CurrencyTextWatcher(binding.amount)
            )
            binding.payButton.setOnClickListener {
                  binding.payButton.text = "Pay ₹${binding.amount.text}"
                  var letter = extractAndCapitalizeFirstLetter(binding.name.text.toString()).toString()
                  binding.nameLogo.text = letter

            }
            binding.backButton.setOnClickListener {
                  activity?.onBackPressed()
            }





            return binding.root
      }

      fun extractAndCapitalizeFirstLetter(input: String): Char? {
            val firstWord = input.trim().split("\\s+".toRegex())[0]
            return firstWord.firstOrNull()?.toUpperCase()
      }


      private fun CurrencyTextWatcher(amount: EditText): TextWatcher? {
            binding.amount.addTextChangedListener(object : TextWatcher {
                  override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                            //To change body of created functions use File | Settings | File Templates.

                  }

                  override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        //To change body of created functions use File | Settings | File Templates.
                  }

                  override fun afterTextChanged(s: android.text.Editable?) {
                        if (s.toString().isNotEmpty()) {
                              amount.removeTextChangedListener(this)
                              val cleanString: String = s.toString().replace("[$,.]".toRegex(), "")
                              val parsed: Double = cleanString.toDouble()
                              val formatted: String = NumberFormat.getCurrencyInstance().format((parsed / 100))
                              amount.setText(formatted)
                              amount.setSelection(formatted.length)
                              amount.addTextChangedListener(this)
                        }
                  }
            })
                return null
      }

}
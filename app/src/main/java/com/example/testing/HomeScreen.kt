package com.example.testing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testing.databinding.FragmentHomeScreenBinding


class HomeScreen : Fragment() {
      private var _binding: FragmentHomeScreenBinding? = null
      private val binding get() = _binding!!
      private lateinit var peopleList: ArrayList<GridItem>
      private lateinit var businessList: ArrayList<GridItem>
      private lateinit var promotionList: ArrayList<GridItem>
      private lateinit var billsList: ArrayList<BillItem>

      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View? {
            // Inflate the layout for this fragment
            requireActivity().window.statusBarColor = this.resources.getColor(R.color.black)
            _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
            val view =  inflater.inflate(R.layout.fragment_home_screen, container, false)


            binding.btnPayPhoneNumber.setOnClickListener {
                  findNavController().navigate(R.id.action_homeScreen_to_paymentFrag)
            }

            binding.peopleRecyclerView.setHasFixedSize(true)
            binding.peopleRecyclerView.layoutManager = GridLayoutManager(this.activity, 4)

//        Businesses RecyclerView
            binding.businessesRecyclerView.setHasFixedSize(true)
            binding.businessesRecyclerView.layoutManager = GridLayoutManager(this.activity, 4)

//        Promotion RecyclerView
            binding.promotionRecyclerView.setHasFixedSize(true)
            binding.promotionRecyclerView.layoutManager = GridLayoutManager(this.activity, 4)

            peopleList = ArrayList()
            addPeoples()

            businessList = ArrayList()
            addBusinesses()

            billsList = ArrayList()
            addBills()

            promotionList = ArrayList()
            addPromotion()

            binding.peopleRecyclerView.adapter = GirdItemAdapter(peopleList)
            binding.businessesRecyclerView.adapter = GirdItemAdapter(businessList)
            binding.promotionRecyclerView.adapter = GirdItemAdapter(promotionList
            )
            binding.billGridView.adapter = BillsAdapter(requireActivity(), billsList)


            return binding.root


      }
      private fun addBills() {
            billsList.add(BillItem(R.drawable.ic_tv, "DTH / Cable TV"))
            billsList.add(BillItem(R.drawable.ic_electricity, "Electricity"))
            billsList.add(BillItem(R.drawable.ic_fastag, "FASTag recharge"))
            billsList.add(BillItem(R.drawable.ic_postpaid_recharge, "Postpaid mobile"))
      }

      private fun addPromotion() {
            promotionList.add(GridItem(R.drawable.ic_rewards, "Rewards"))
            promotionList.add(GridItem(R.drawable.ic_offers, "Offers"))
            promotionList.add(GridItem(R.drawable.ic_referrals, "Referrals"))
            promotionList.add(GridItem(R.drawable.ic_indi_home, "Indi-Home"))
      }

      private fun addPeoples() {
            peopleList.add(GridItem(R.color.theme_blue, "Blue Color"))
            peopleList.add(GridItem(R.color.theme_green, "Green Color"))
            peopleList.add(GridItem(R.color.theme_red, "Red Color"))
            peopleList.add(GridItem(R.color.theme_gray, "Grey Color"))
            peopleList.add(GridItem(R.color.theme_gray, "Grey Color"))
            peopleList.add(GridItem(R.color.theme_red, "Red Color"))
            peopleList.add(GridItem(R.color.theme_green, "Green Color"))
            peopleList.add(GridItem(R.color.theme_blue, "Blue Color"))
      }

      private fun addBusinesses() {
            businessList.add(GridItem(R.color.theme_red, "Red Color"))
            businessList.add(GridItem(R.color.theme_gray, "Grey Color"))
            businessList.add(GridItem(R.color.theme_green, "Green Color"))
            businessList.add(GridItem(R.color.theme_blue, "Blue Color"))
      }




}

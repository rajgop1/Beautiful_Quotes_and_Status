package com.rajgopaljakmola.beautifulquotesandstatus.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajgopaljakmola.beautifulquotesandstatus.R
import com.rajgopaljakmola.beautifulquotesandstatus.R.drawable
import com.rajgopaljakmola.beautifulquotesandstatus.adapter.RvQuoteHomeAdapter
import com.rajgopaljakmola.beautifulquotesandstatus.databinding.FragmentHomeBinding
import com.rajgopaljakmola.beautifulquotesandstatus.model.RvQuoteHomeModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var rvAdapter:RvQuoteHomeAdapter
    private lateinit var dataList:ArrayList<RvQuoteHomeModel>
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // adding data to datalist
        dataList = ArrayList<RvQuoteHomeModel>()
        dataList.add(RvQuoteHomeModel(drawable.birthday, getString(R.string.birthday)))
        dataList.add(RvQuoteHomeModel(drawable.anniversary, getString(R.string.anniversary)))
        dataList.add(RvQuoteHomeModel(drawable.wisdom, getString(R.string.wisdom)))
        dataList.add(RvQuoteHomeModel(drawable.happiness, getString(R.string.happiness)))
        dataList.add(RvQuoteHomeModel(drawable.inspiration, getString(R.string.inspirational)))
        dataList.add(RvQuoteHomeModel(drawable.love, getString(R.string.love)))
        dataList.add(RvQuoteHomeModel(drawable.motivation, getString(R.string.motivational)))

        rvAdapter = context?.let { RvQuoteHomeAdapter(dataList, it) }!!
        binding.rvHome.layoutManager = LinearLayoutManager(context)
        binding.rvHome.adapter=rvAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
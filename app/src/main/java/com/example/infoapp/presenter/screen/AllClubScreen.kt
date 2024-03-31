package com.example.infoapp.presenter.screen

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.infoapp.R
import com.example.infoapp.data.CategoryData
import com.example.infoapp.data.ClubData
import com.example.infoapp.databinding.ActivityAllClubBinding
import com.example.infoapp.presenter.adapter.CategoryAdapter
import com.example.infoapp.presenter.adapter.ClubAdapter

class AllClubScreen : Fragment(R.layout.activity_all_club) {

    private val binding by viewBinding(ActivityAllClubBinding::bind)
    private val adapter = ClubAdapter()
    private val categoryAdapter = CategoryAdapter()

    private val data = ArrayList<ClubData>().apply {
        add(ClubData(R.drawable.antwerp, "Royal Antwerp", "Belgium"))
        add(ClubData(R.drawable.arsenal_2, "Arsenal", "England"))
        add(ClubData(R.drawable.a_madrid, "Atletico de Madrid", "Espain"))
        add(ClubData(R.drawable.barcelona, "Barcelona", "Espain"))
        add(ClubData(R.drawable.bayern, "Bayern Munchen", "Germany"))
        add(ClubData(R.drawable.benfica, "Benfica", "Portugal"))
        add(ClubData(R.drawable.braga, "Braga", "Portugal"))
        add(ClubData(R.drawable.celtic, "Celtic", "Scottish"))
        add(ClubData(R.drawable.copenhagen, "Copenhagen", "Denmark"))
        add(ClubData(R.drawable.crvena_zvezda, "Crvena Zvezda", "Serbia"))
        add(ClubData(R.drawable.bvb, "Borussia Dortmund", "Germany"))
        add(ClubData(R.drawable.porto, "Porto", "Portugal"))
        add(ClubData(R.drawable.feyenoord, "Feyenoord", "Netherlands"))
        add(ClubData(R.drawable.galatasaray, "Galatasaray", "Turkia"))
        add(ClubData(R.drawable.internazionale_milano, "Internazionale Milano", "Italy"))
        add(ClubData(R.drawable.lazio, "Lazio", "Italy"))
        add(ClubData(R.drawable.leipzig, "Leipzig", "Germany"))
        add(ClubData(R.drawable.lens, "Lens", "France"))
        add(ClubData(R.drawable.man_city, "Manchester City", "England"))
        add(ClubData(R.drawable.man_united, "Manchester United", "England"))
        add(ClubData(R.drawable.milan, "Milan", "Italy"))
        add(ClubData(R.drawable.napoli, "Napoli", "Italy"))
        add(ClubData(R.drawable.new_castle, "Newcastle United", "England"))
        add(ClubData(R.drawable.psg, "Paris Saint-German", "France"))
        add(ClubData(R.drawable.psv, "PSV Eindhoven", "Netherlands"))
        add(ClubData(R.drawable.real_madrid, "Real Madrid", "Espain"))
        add(ClubData(R.drawable.real_sociedad, "Real Sociedad", "Espain"))
        add(ClubData(R.drawable.salzburg, "Salzburg", "Austria"))
        add(ClubData(R.drawable.sevilla, "Sevilla", "Espain"))
        add(ClubData(R.drawable.shakhtar, "Shakhtar Donesk", "Ukrain"))
        add(ClubData(R.drawable.union, "Union Berlin", "Germany"))
        add(ClubData(R.drawable.young_boys, "Young Boys", "Switzerland"))
    }

    private val categories = HashSet<CategoryData>()

    init {
        data.forEach {
            categories.add(CategoryData("All"))
            categories.add(CategoryData(it.country))
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initRv()

        adapter.onClick = { pos ->
            findNavController().navigate(AllClubScreenDirections.actionAllClubScreenToDetailActivity(pos))
        }

        requireActivity().window.statusBarColor = Color.parseColor("#ffffff")
    }

    private fun initRv() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        adapter.submitList(data)

        binding.recyclerCategory.adapter = categoryAdapter
        categoryAdapter.submitList(categories.toList())

        categoryAdapter.onCLick = { it ->
            if (it == "All") adapter.submitList(data)
            else adapter.submitList(getClubDataByCountry(it))
        }
    }

    private fun getClubDataByCountry(countryName: String): List<ClubData> {
        val filteredList = mutableListOf<ClubData>()
        for (clubData in data) {
            if (clubData.country.equals(countryName, ignoreCase = true)) {
                filteredList.add(clubData)
            }
        }
        return filteredList
    }


}
package com.example.infoapp.presenter.screen

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.infoapp.R
import com.example.infoapp.data.ClubDetailData
import com.example.infoapp.databinding.ActivityDetailBinding

class DetailScreen : Fragment(R.layout.activity_detail) {

    private val binding by viewBinding(ActivityDetailBinding::bind)
    private val list = ArrayList<ClubDetailData>()
    private val navArgs: DetailScreenArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        loadData()

        val data = list[navArgs.pos]

        binding.imageClub.setImageResource(data.img)
        binding.textFootballClubName.text = data.name
        binding.textDescription.setText(data.clubDescription)

        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }

        requireActivity().window.statusBarColor = Color.parseColor("#FFFFFF")

    }

    private fun loadData() {
        list.add(ClubDetailData(R.drawable.antwerp, "Royal Antwerp", R.string.antwerp))
        list.add(ClubDetailData(R.drawable.arsenal_2, "Arsenal", R.string.arsenal))
        list.add(ClubDetailData(R.drawable.a_madrid, "Atletico de Madrid", R.string.atletico_madrid))
        list.add(ClubDetailData(R.drawable.barcelona_2, "Barcelona", R.string.barsa))
        list.add(ClubDetailData(R.drawable.bayern, "Bayern Munchen", R.string.bayern))
        list.add(ClubDetailData(R.drawable.benfica, "Benfica", R.string.benfica))
        list.add(ClubDetailData(R.drawable.braga, "Braga", R.string.braga))
        list.add(ClubDetailData(R.drawable.celtic, "Celtic", R.string.celtic))
        list.add(ClubDetailData(R.drawable.copenhagen, "Copenhagen", R.string.copenhagen))
        list.add(ClubDetailData(R.drawable.crvena_zvezda, "Crvena Zvezda", R.string.crvena_zvezda))
        list.add(ClubDetailData(R.drawable.bvb, "Borussia Dortmund", R.string.dortmund))
        list.add(ClubDetailData(R.drawable.porto, "Porto", R.string.porto))
        list.add(ClubDetailData(R.drawable.feyenoord, "Feyenoord", R.string.feyenoord))
        list.add(ClubDetailData(R.drawable.galatasaray, "Galatasaray", R.string.galatasaray))
        list.add(ClubDetailData(R.drawable.internazionale_milano, "Internazionale Milano", R.string.inter_milan))
        list.add(ClubDetailData(R.drawable.lazio, "Lazio", R.string.lazio))
        list.add(ClubDetailData(R.drawable.leipzig, "Leipzig", R.string.leipzig))
        list.add(ClubDetailData(R.drawable.lens, "Lens", R.string.lens))
        list.add(ClubDetailData(R.drawable.man_city_2, "Manchester City", R.string.man_city))
        list.add(ClubDetailData(R.drawable.man_united_2, "Manchester United", R.string.man_united))
        list.add(ClubDetailData(R.drawable.milan, "Milan", R.string.ac_milan))
        list.add(ClubDetailData(R.drawable.napoli, "Napoli", R.string.napoli))
        list.add(ClubDetailData(R.drawable.new_castle, "New Castle", R.string.newcastle_united))
        list.add(ClubDetailData(R.drawable.psg, "Paris Saint-German", R.string.psg))
        list.add(ClubDetailData(R.drawable.psv, "PSV Eindhoven", R.string.psv))
        list.add(ClubDetailData(R.drawable.real_madrid_2, "Real Madrid", R.string.real))
        list.add(ClubDetailData(R.drawable.real_sociedad, "Real Sociedad", R.string.real_sociedad))
        list.add(ClubDetailData(R.drawable.salzburg, "Salzburg", R.string.salzburg))
        list.add(ClubDetailData(R.drawable.sevilla, "Sevilla", R.string.sevilla))
        list.add(ClubDetailData(R.drawable.shakhtar, "Shakhtar Donesk", R.string.shakhtar_donetsk))
        list.add(ClubDetailData(R.drawable.union, "Union Berlin", R.string.union_berlin))
        list.add(ClubDetailData(R.drawable.young_boys, "Young Boys", R.string.youngBoys))
    }

}
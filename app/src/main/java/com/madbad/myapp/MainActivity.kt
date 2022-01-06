package com.madbad.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.madbad.myapp.adapter.FilmListRecyclerAdapter
import com.madbad.myapp.helper.SimpleItemTouchHelperCallback
import com.madbad.myapp.model.Film
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val filmsDataBase = listOf(
        Film("The King's Man", R.drawable.the_kings_man_1, "The film features an ensemble cast that includes Ralph Fiennes (who also serves as one of the film's executive producers), Gemma Arterton, Rhys Ifans, Matthew Goode, Tom Hollander, Harris Dickinson, Daniel Brühl, Djimon Hounsou, and Charles Dance, and focuses on several events during World War I and the birth of the Kingsman organization."),
        Film("Mad Max", R.drawable.mad_max_2, "Mad Max: Fury Road is a 2015 Australian post-apocalyptic action film co-written, co-produced, and directed by George Miller. Miller collaborated with Brendan McCarthy and Nico Lathouris on the screenplay. The fourth instalment and a revisiting of the Mad Max franchise, it was produced by Kennedy Miller Mitchell and RatPac-Dune Entertainment and distributed by Village Roadshow Pictures in Australia and by Warner Bros. Pictures internationally. The film stars Tom Hardy, Charlize Theron, Nicholas Hoult, Hugh Keays-Byrne, Rosie Huntington-Whiteley, Riley Keough, Zoë Kravitz, Abbey Lee, and Courtney Eaton. Set in a post-apocalyptic desert wasteland where gasoline and water are scarce commodities, Fury Road follows Max Rockatansky, who joins forces with Imperator Furiosa to flee from cult leader Immortan Joe and his army in an armoured tanker truck, leading to a lengthy road battle."),
        Film("The Witcher", R.drawable.the_witcher_3, "The Witcher is a fantasy drama streaming television series created by Lauren Schmidt Hissrich, based on the book series of the same name by Polish writer Andrzej Sapkowski. Set on a fictional, medieval-inspired landmass known as the Continent, The Witcher explores the legend of Geralt of Rivia and Princess Ciri, who are linked to each other by destiny.[9] It stars Henry Cavill, Freya Allan and Anya Chalotra. "),
        Film("Black Widow", R.drawable.black_widow_4, "Black Widow is a 2021 American superhero film based on Marvel Comics featuring the character of the same name. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures, it is the 24th film in the Marvel Cinematic Universe (MCU). The film was directed by Cate Shortland from a screenplay by Eric Pearson, and stars Scarlett Johansson as Natasha Romanoff / Black Widow alongside Florence Pugh, David Harbour, O-T Fagbenle, Olga Kurylenko, William Hurt, Ray Winstone, and Rachel Weisz. Set after the events of Captain America: Civil War (2016), the film sees Romanoff on the run and forced to confront her past."),
        Film("The falcon and the winter soldier", R.drawable.the_falcon_and_the_winter_soldier_5, "The Falcon and the Winter Soldier[a] is an American television miniseries created by Malcolm Spellman for the streaming service Disney+, based on Marvel Comics featuring the characters Sam Wilson / Falcon and Bucky Barnes / Winter Soldier. It is the second television series in the Marvel Cinematic Universe (MCU) produced by Marvel Studios, sharing continuity with the films of the franchise and taking place after the events of the film Avengers: Endgame (2019). Spellman served as head writer with Kari Skogland directing."),
        Film("Venom", R.drawable.venom_6, "Venom: Let There Be Carnage is a 2021 American superhero film featuring the Marvel Comics character Venom, produced by Columbia Pictures in association with Marvel. Distributed by Sony Pictures Releasing, it is the second film in Sony's Spider-Man Universe and the sequel to Venom (2018). The film was directed by Andy Serkis from a screenplay by Kelly Marcel, based on a story she wrote with Tom Hardy who stars as Eddie Brock and Venom alongside Michelle Williams, Naomie Harris, Reid Scott, Stephen Graham, and Woody Harrelson. In the film, Brock and the alien symbiote Venom must face serial killer Cletus Kasady (Harrelson) after he becomes the host of an offshoot of Venom named Carnage."),
        Film("Hawkeye", R.drawable.hawkeye_7, "Hawkeye is an American television miniseries created by Jonathan Igla for the streaming service Disney+, based on Marvel Comics featuring the characters Clint Barton / Hawkeye and Kate Bishop / Hawkeye. It is the fifth television series in the Marvel Cinematic Universe (MCU) produced by Marvel Studios, sharing continuity with the films of the franchise and taking place after the events of the film Avengers: Endgame (2019). Igla serves as head writer with Rhys Thomas leading the directing team."),
        Film("Finch", R.drawable.finch_8, "Finch is a 2021 American post-apocalyptic science fiction drama film directed by Miguel Sapochnik from a spec script written by Craig Luck and Ivor Powell.[1] The film stars Tom Hanks and Caleb Landry Jones.")
    )


    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            initNavigation()


        main_recycler.apply {

            initFilmAdapter()
            
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(filmsDataBase)

        val callbacks = SimpleItemTouchHelperCallback(main_recycler.adapter as FilmListRecyclerAdapter)
        val touchHelper = ItemTouchHelper(callbacks)
        touchHelper.attachToRecyclerView(main_recycler)
    }

    private fun initNavigation() {
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    fun initFilmAdapter(){
        filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
            override fun click(film: Film) {
                val bundle = Bundle()
                bundle.putParcelable("film", film)
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        })
    }
}
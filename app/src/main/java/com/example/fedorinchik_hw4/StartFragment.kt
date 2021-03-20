package com.example.fedorinchik_hw4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val COLOR_VALUES = "color_values"
const val COLOR_NAME = "color_name"
const val COLOR_HEX_CODE = "color_hex_code"

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StartFragment : Fragment() {

    private val colors = listOf(
        ColorsData(R.color.c1, "красный", "#F44336"),
        ColorsData(R.color.c2, "малиновый", "#E91E63"),
        ColorsData(R.color.c3, "фиолетовый", "#9C27B0"),
        ColorsData(R.color.c4, "синий", "#3F51B5"),
        ColorsData(R.color.c5, "голубой", "#03A9F4"),
        ColorsData(R.color.c6, "зеленый", "#4CAF50"),
        ColorsData(R.color.c7, "желтый", "#FFEB3B"),
        ColorsData(R.color.c8, "оранжевый", "#FF9800"),
        ColorsData(R.color.c9, "черный", "#000000"),
        ColorsData(R.color.c10, "белый", "#FFFFFF")
    )

    private lateinit var recycler: RecyclerView
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val startFragment = inflater.inflate(R.layout.fragment_start, container, false)
        recyclerStart(startFragment)
        return startFragment
    }

    private fun recyclerStart(view: View) {
        recycler = view.findViewById(R.id.RecyclerView)
        val adapter = Adapter(colors) {
            val intent = Intent(this.context, ColorHexCopyActivity::class.java)
            intent.putExtra(COLOR_VALUES, it.colorValues)
            intent.putExtra(COLOR_NAME, it.colorName)
            intent.putExtra(COLOR_HEX_CODE, it.colorHexCode)
            startActivity(intent)
        }
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
    }
}
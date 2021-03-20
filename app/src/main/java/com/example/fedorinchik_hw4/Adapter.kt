package com.example.fedorinchik_hw4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val colors: List<ColorsData>, private val onClick: (ColorsData) -> Unit
) :
    RecyclerView.Adapter<Adapter.ViewHolderCurrentColor>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCurrentColor {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.colors_layout, parent, false)
        return ViewHolderCurrentColor(view, onClick)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onBindViewHolder(holder: ViewHolderCurrentColor, pos: Int) {
        holder.bindViewHolder(colors[pos])
    }

    class ViewHolderCurrentColor(view: View, val onClick: (ColorsData) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private var currentViewHolderColor: ColorsData? = null
        private val nameColorText = view.findViewById<TextView>(R.id.cl_name)
        private val viewHolderColor = view.findViewById<View>(R.id.color)

        init {
            view.setOnClickListener {
                currentViewHolderColor?.let {
                    onClick(it)
                }
            }
        }

        fun bindViewHolder(currentColor: ColorsData) {
            currentViewHolderColor = currentColor
            viewHolderColor.setBackgroundResource(currentColor.colorValues)
            nameColorText.text = currentColor.colorName
        }
    }
}
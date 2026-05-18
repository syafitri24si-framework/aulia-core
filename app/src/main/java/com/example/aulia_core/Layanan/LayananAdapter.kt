package com.example.aulia_core.Layanan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.aulia_core.R

class LayananAdapter(
    context: Context,
    private val items: List<LayananModel>
) : ArrayAdapter<LayananModel>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_layanan, parent, false)

        val item = items[position]

        val avatarImg = view.findViewById<ImageView>(R.id.avatarImg)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)

        tvTitle.text = item.title
        tvDescription.text = item.description

        // Load gambar menggunakan Glide
        Glide.with(context)
            .load(item.avatarUrl)
            .placeholder(R.drawable.ic_layanan)
            .error(R.drawable.ic_layanan)
            .circleCrop()
            .into(avatarImg)

        // OnClick listener
        view.setOnClickListener {
            Toast.makeText(
                context,
                "Kamu memilih: ${item.title}\n${item.description}",
                Toast.LENGTH_LONG
            ).show()
        }

        return view
    }
}
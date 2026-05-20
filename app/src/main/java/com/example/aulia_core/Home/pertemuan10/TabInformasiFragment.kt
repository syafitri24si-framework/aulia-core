package com.example.aulia_core.Home.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.aulia_core.R

class TabInformasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Buat ScrollView agar bisa di-scroll
        val scrollView = android.widget.ScrollView(requireContext())
        scrollView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.background_soft))

        // LinearLayout utama
        val mainLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 20, 20, 20)
        }

        // ==================== HEADER ====================
        val headerCard = CardView(requireContext()).apply {
            radius = 20f
            cardElevation = 8f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.primary))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 20 }
        }

        val headerLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            setPadding(30, 25, 30, 25)
        }

        val iconTitle = TextView(requireContext()).apply {
            text = "🏛️"
            textSize = 48f
            gravity = android.view.Gravity.CENTER
        }

        val title = TextView(requireContext()).apply {
            text = "INFORMASI DESA"
            textSize = 22f
            setTextColor(ContextCompat.getColor(context, R.color.text_white))
            gravity = android.view.Gravity.CENTER
            typeface = android.graphics.Typeface.DEFAULT_BOLD
        }

        val subtitle = TextView(requireContext()).apply {
            text = "Bina Desa • Profil & Data Desa"
            textSize = 12f
            setTextColor(ContextCompat.getColor(context, R.color.text_white))
            gravity = android.view.Gravity.CENTER
        }

        headerLayout.addView(iconTitle)
        headerLayout.addView(title)
        headerLayout.addView(subtitle)
        headerCard.addView(headerLayout)
        mainLayout.addView(headerCard)

        // ==================== STRUKTUR PEMERINTAHAN ====================
        val strukturCard = CardView(requireContext()).apply {
            radius = 12f
            cardElevation = 4f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_background))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 16 }
        }

        val strukturLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 16, 20, 16)
        }

        val strukturTitle = TextView(requireContext()).apply {
            text = "🏛️ STRUKTUR PEMERINTAHAN"
            textSize = 16f
            setTextColor(ContextCompat.getColor(context, R.color.primary))
            typeface = android.graphics.Typeface.DEFAULT_BOLD
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 12 }
        }

        strukturLayout.addView(strukturTitle)

        val officials = listOf(
            "👨‍💼 Kepala Desa" to "Bapak Ahmad",
            "👩‍💼 Sekretaris Desa" to "Ibu Siti",
            "💰 Kaur Keuangan" to "Bapak Budi",
            "📋 Kaur Pelayanan" to "Ibu Dewi",
            "🌾 Kaur Pembangunan" to "Bapak Eko"
        )

        for ((position, name) in officials) {
            val rowLayout = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 10 }
            }

            val posView = TextView(requireContext()).apply {
                text = position
                textSize = 13f
                setTextColor(ContextCompat.getColor(context, R.color.text_primary))
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val nameView = TextView(requireContext()).apply {
                text = name
                textSize = 13f
                setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                gravity = android.view.Gravity.END
            }

            rowLayout.addView(posView)
            rowLayout.addView(nameView)
            strukturLayout.addView(rowLayout)
        }

        strukturCard.addView(strukturLayout)
        mainLayout.addView(strukturCard)

        // ==================== DATA DESA ====================
        val dataCard = CardView(requireContext()).apply {
            radius = 12f
            cardElevation = 4f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_background))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 16 }
        }

        val dataLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 16, 20, 16)
        }

        val dataTitle = TextView(requireContext()).apply {
            text = "📊 DATA DESA"
            textSize = 16f
            setTextColor(ContextCompat.getColor(context, R.color.primary))
            typeface = android.graphics.Typeface.DEFAULT_BOLD
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 12 }
        }

        dataLayout.addView(dataTitle)

        val stats = listOf(
            "📌 Jumlah RT" to "25 RT",
            "📌 Jumlah RW" to "5 RW",
            "👥 Total Jiwa" to "5.234 Jiwa",
            "🏞️ Luas Desa" to "4,5 km²",
            "🏘️ Jumlah KK" to "1.247 KK"
        )

        for ((label, value) in stats) {
            val rowLayout = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 10 }
            }

            val labelView = TextView(requireContext()).apply {
                text = label
                textSize = 13f
                setTextColor(ContextCompat.getColor(context, R.color.text_primary))
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val valueView = TextView(requireContext()).apply {
                text = value
                textSize = 13f
                setTextColor(ContextCompat.getColor(context, R.color.primary))
                typeface = android.graphics.Typeface.DEFAULT_BOLD
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                gravity = android.view.Gravity.END
            }

            rowLayout.addView(labelView)
            rowLayout.addView(valueView)
            dataLayout.addView(rowLayout)
        }

        dataCard.addView(dataLayout)
        mainLayout.addView(dataCard)

        // ==================== INFO KONTAK ====================
        val kontakCard = CardView(requireContext()).apply {
            radius = 12f
            cardElevation = 4f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.primary_soft))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        val kontakLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 16, 20, 16)
        }

        val kontakTitle = TextView(requireContext()).apply {
            text = "📞 KONTAK KANTOR DESA"
            textSize = 14f
            setTextColor(ContextCompat.getColor(context, R.color.primary))
            typeface = android.graphics.Typeface.DEFAULT_BOLD
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 8 }
        }

        val kontakTelp = TextView(requireContext()).apply {
            text = "📱 (021) 1234-5678"
            textSize = 12f
            setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
        }

        val kontakEmail = TextView(requireContext()).apply {
            text = "📧 bina@desa.id"
            textSize = 12f
            setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
        }

        kontakLayout.addView(kontakTitle)
        kontakLayout.addView(kontakTelp)
        kontakLayout.addView(kontakEmail)
        kontakCard.addView(kontakLayout)
        mainLayout.addView(kontakCard)

        scrollView.addView(mainLayout)
        return scrollView
    }
}
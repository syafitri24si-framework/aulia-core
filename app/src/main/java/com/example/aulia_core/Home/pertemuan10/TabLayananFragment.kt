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

class TabLayananFragment : Fragment() {

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
            text = "📋"
            textSize = 48f
            gravity = android.view.Gravity.CENTER
        }

        val title = TextView(requireContext()).apply {
            text = "LAYANAN DESA"
            textSize = 22f
            setTextColor(ContextCompat.getColor(context, R.color.text_white))
            gravity = android.view.Gravity.CENTER
            typeface = android.graphics.Typeface.DEFAULT_BOLD
        }

        val subtitle = TextView(requireContext()).apply {
            text = "Bina Desa • Layanan Administratif"
            textSize = 12f
            setTextColor(ContextCompat.getColor(context, R.color.text_white))
            gravity = android.view.Gravity.CENTER
        }

        headerLayout.addView(iconTitle)
        headerLayout.addView(title)
        headerLayout.addView(subtitle)
        headerCard.addView(headerLayout)
        mainLayout.addView(headerCard)

        // ==================== DAFTAR LAYANAN ====================
        val services = listOf(
            Triple("🆔", "Pembuatan KTP", "Kartu Tanda Penduduk elektronik"),
            Triple("📘", "Pembuatan KK", "Kartu Keluarga"),
            Triple("🏠", "Surat Domisili", "Keterangan tempat tinggal"),
            Triple("📄", "Surat Keterangan Usaha", "Untuk izin usaha"),
            Triple("👶", "Akta Kelahiran", "Pencatatan kelahiran"),
            Triple("🚚", "Surat Pindah", "Pindah penduduk")
        )

        for ((icon, service, desc) in services) {
            val serviceCard = CardView(requireContext()).apply {
                radius = 12f
                cardElevation = 4f
                setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_background))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 12 }
            }

            val serviceLayout = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(20, 16, 20, 16)
                gravity = android.view.Gravity.CENTER_VERTICAL
            }

            val iconView = TextView(requireContext()).apply {
                text = icon
                textSize = 32f
                layoutParams = LinearLayout.LayoutParams(80, LinearLayout.LayoutParams.WRAP_CONTENT)
            }

            val textLayout = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val titleView = TextView(requireContext()).apply {
                text = service
                textSize = 16f
                setTextColor(ContextCompat.getColor(context, R.color.text_primary))
                typeface = android.graphics.Typeface.DEFAULT_BOLD
            }

            val descView = TextView(requireContext()).apply {
                text = desc
                textSize = 12f
                setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
            }

            textLayout.addView(titleView)
            textLayout.addView(descView)

            val arrowView = TextView(requireContext()).apply {
                text = "→"
                textSize = 20f
                setTextColor(ContextCompat.getColor(context, R.color.primary))
                layoutParams = LinearLayout.LayoutParams(50, LinearLayout.LayoutParams.WRAP_CONTENT)
            }

            serviceLayout.addView(iconView)
            serviceLayout.addView(textLayout)
            serviceLayout.addView(arrowView)
            serviceCard.addView(serviceLayout)
            mainLayout.addView(serviceCard)
        }

        // ==================== INFO TAMBAHAN ====================
        val infoCard = CardView(requireContext()).apply {
            radius = 12f
            cardElevation = 4f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.primary_soft))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = 20 }
        }

        val infoLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(20, 16, 20, 16)
            gravity = android.view.Gravity.CENTER_VERTICAL
        }

        val infoIcon = TextView(requireContext()).apply {
            text = "🕐"
            textSize = 28f
            layoutParams = LinearLayout.LayoutParams(60, LinearLayout.LayoutParams.WRAP_CONTENT)
        }

        val infoTextLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }

        val infoTitle = TextView(requireContext()).apply {
            text = "Jam Operasional"
            textSize = 14f
            setTextColor(ContextCompat.getColor(context, R.color.text_primary))
            typeface = android.graphics.Typeface.DEFAULT_BOLD
        }

        val infoDesc = TextView(requireContext()).apply {
            text = "Senin - Jumat | 08:00 - 15:00 WIB"
            textSize = 12f
            setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
        }

        infoTextLayout.addView(infoTitle)
        infoTextLayout.addView(infoDesc)

        infoLayout.addView(infoIcon)
        infoLayout.addView(infoTextLayout)
        infoCard.addView(infoLayout)
        mainLayout.addView(infoCard)

        scrollView.addView(mainLayout)
        return scrollView
    }
}
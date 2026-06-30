package com.example.aulia_core.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.aulia_core.BaseActivity

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val title = intent.getStringExtra("title") ?: "Pengingat Bina Desa"
        val message = intent.getStringExtra("message") ?: "Waktunya melakukan sesuatu"
        val targetClassName = intent.getStringExtra("target_activity")
        val openTab = intent.getIntExtra("open_tab", 0)  // ← TAMBAHKAN INI

        val targetIntent = if (!targetClassName.isNullOrEmpty()) {
            val clazz = Class.forName(targetClassName)
            Intent(context, clazz).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                putExtra("OPEN_TAB", openTab)  // ← TAMBAHKAN INI
            }
        } else {
            Intent(context, BaseActivity::class.java)
        }

        NotificationHelper.showNotification(
            context = context,
            title = title,
            message = message,
            intent = targetIntent
        )
    }
}

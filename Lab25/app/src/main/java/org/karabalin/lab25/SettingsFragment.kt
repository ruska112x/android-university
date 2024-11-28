package org.karabalin.lab25

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.SwitchPreferenceCompat

class SettingsFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
        val preference: Preference? = key?.let { findPreference(it) }
        preference?.let {
            val value: Any? = when (it) {
                is SwitchPreferenceCompat -> sharedPreferences.getBoolean(key, false)
                is EditTextPreference -> sharedPreferences.getString(key, "")
                is ListPreference -> {
                    val index = (it as ListPreference).findIndexOfValue(sharedPreferences.getString(key, ""))
                    if (index >= 0) it.entries[index] else sharedPreferences.getString(key, "")
                }
                else -> sharedPreferences.all[key]
            }
            Toast.makeText(context, "Настройка '${it.title}' изменена на '$value'", Toast.LENGTH_SHORT).show()
        }
    }
}

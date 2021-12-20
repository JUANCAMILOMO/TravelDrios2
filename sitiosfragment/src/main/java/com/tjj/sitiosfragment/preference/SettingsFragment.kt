package com.tjj.sitiosfragment.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.tjj.sitiosfragment.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}
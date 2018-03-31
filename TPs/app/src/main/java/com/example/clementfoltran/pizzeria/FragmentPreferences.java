package com.example.clementfoltran.pizzeria;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

public class FragmentPreferences extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        ((PizzeriaMainActivity) getActivity()).applyPref();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}

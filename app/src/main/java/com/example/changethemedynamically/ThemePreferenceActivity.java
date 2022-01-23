package com.example.changethemedynamically;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiAutomation;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceChangeListener;

public class ThemePreferenceActivity extends PreferenceActivity {

    public static final int RESULT_CODE_THEME_UPDATED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        findPreference("theme").setOnPreferenceChangeListener(new RefreshActivityOnPreferenceChangeListener(RESULT_CODE_THEME_UPDATED));

    }
    private class RefreshActivityOnPreferenceChangeListener implements OnPreferenceChangeListener
    {

        private final  int resultCode;

        public RefreshActivityOnPreferenceChangeListener(int resultCode) {
            this.resultCode = resultCode;

        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            setResult(resultCode);
            finish();
            return true;
        }
    }
}
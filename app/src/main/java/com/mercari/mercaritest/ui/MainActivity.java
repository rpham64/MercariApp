package com.mercari.mercaritest.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mercari.mercaritest.R;
import com.mercari.mercaritest.utils.JSONUtils;

/**
 * The Activity class of the Main section of this app. Manages the MainFragment class.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate fragment from fragment manager
        // If null, create a new fragment with container fragment_container.xml
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createMainFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    /**
     * Creates a Fragment instance of MainFragment.
     *
     * @return New instance of MainFragment.
     */
    protected Fragment createMainFragment() {
        return MainFragment.newInstance();
    }
}

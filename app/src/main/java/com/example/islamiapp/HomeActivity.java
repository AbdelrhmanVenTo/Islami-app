package com.example.islamiapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.view.MenuItem;

import com.example.islamiapp.Base.BaseActivity;
import com.example.islamiapp.TabsFragment.MentionFragment;
import com.example.islamiapp.TabsFragment.QuotesFragment;
import com.example.islamiapp.TabsFragment.QuranFragment;
import com.example.islamiapp.TabsFragment.RadioFragment;


public class HomeActivity extends BaseActivity {

    Fragment fragment;
    FragmentTransaction fragmentTransaction;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer)==null) {
                fragment = new QuranFragment();
            }
            switch (item.getItemId()) {
                case R.id.navigation_quran:
                    fragment = new QuranFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_Quotes:
                    fragment = new QuotesFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_mention:
                    fragment = new MentionFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_radio:
                    fragment = new RadioFragment();
                    switchFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    public void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Fragment fragment = new QuranFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit();
    }

}

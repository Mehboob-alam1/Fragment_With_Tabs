package com.mehboob.fragmentstab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.mehboob.fragmentstab.fragments.CallsFragment;
import com.mehboob.fragmentstab.fragments.ChatsFragment;
import com.mehboob.fragmentstab.fragments.MessagesFragment;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Fragment fragment=null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FrameLayout frameLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        frameLayout = findViewById(R.id.framelayout);


        fragment = new ChatsFragment();
        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                switch (tab.getPosition()){
                    case 0:
                        fragment= new ChatsFragment();
                        break;
                    case 1:
                        fragment = new CallsFragment();
                        break;
                    case  2:
                        fragment= new MessagesFragment();
                        break;
                }
                fragmentManager = getSupportFragmentManager();

                fragmentTransaction = fragmentManager.beginTransaction();


                fragmentTransaction.replace(R.id.framelayout, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
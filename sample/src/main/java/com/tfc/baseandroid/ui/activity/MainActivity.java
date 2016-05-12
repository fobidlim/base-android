package com.tfc.baseandroid.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.tfc.baseandroid.R;
import com.tfc.baseandroid.ui.adapter.SwipeableViewPagerAdapter;
import com.tfc.library.ui.widget.SwipeableViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.a_main);

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.a_main_togglebutton);

        final SwipeableViewPager swipeableViewPager = (SwipeableViewPager) findViewById(R.id.a_main_swipeableviewpager);
        SwipeableViewPagerAdapter adapter = new SwipeableViewPagerAdapter(getSupportFragmentManager());

        //noinspection ConstantConditions
        swipeableViewPager.setAdapter(adapter);

        //noinspection ConstantConditions
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swipeableViewPager.setCurrentItem(1);
                } else {
                    swipeableViewPager.setCurrentItem(0);
                }
            }
        });
    }
}

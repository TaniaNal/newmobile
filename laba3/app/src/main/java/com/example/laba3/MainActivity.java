package com.example.laba3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabsAdapter tabsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        viewPager = findViewById(R.id.main_activity_view_pager);
        tabsAdapter = new TabsAdapter(getSupportFragmentManager(), getLifecycle());

        viewPager.setAdapter(tabsAdapter);

        final String[] tabTitles = new String[]{"Movies", "Tab 2", "Profile"};
        final TabLayout tabLayout = findViewById(R.id.main_activity_tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(tabTitles[position]);
                    }
                }
        ).attach();
    }
}
package com.example.application4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager2.widget.ViewPager2;

public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager2 と TabLayout を取得
        ViewPager2 viewPager = findViewById(R.id.my_view_pager);
        TabLayout tabLayout = findViewById(R.id.my_tab_layout);

        // ViewPager2 にアダプタを設定
        viewPager.setAdapter(new MyVPAdapter(this));

        // TabLayoutMediator を設定
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("メニュー");
                    break;
                case 1:
                    tab.setText("カレンダー");
                    break;
            }
        }).attach();

        // ボタンを押した時の処理
        findViewById(R.id.seni_button01).setOnClickListener(v -> {
            // インテントの追加（これが遷移用ロジックです）
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
        });
    }
}

package com.example.gaboja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    ViewFlipper v_fllipper;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ranking_listview);

        v_fllipper = findViewById(R.id.image_slide);

        List<String> itemList = new ArrayList<String>();


        itemList.add("부산 해운대 모래 축제          (2023.05.19 ~ 2023.05.22)");
        itemList.add("레고랜드 코리아                    (2023.05.12 ~ 2023.06.30)");
        itemList.add("한강 달빛야시장                    (2023.05.07 ~ 2023.06.11)");
        itemList.add("알파카월드                             (2023.10.08 ~ 2023.10.08)");
        itemList.add("여의도 불꽃축제                   (2023.05.23 ~ 2023.05.25)");
        itemList.add("서울장미축제                        (2023.05.13 ~ 2023.05.28)");
        itemList.add("춘향제                                   (2023.05.25 ~ 2023.05.29)");


        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList);

        // listView에 adapter 연결
        listView.setAdapter(adapter);

        int images[] = {
                R.drawable.busan ,  //첫번째 파일 이름
                R.drawable.legoland, //두번째 파일 이름
                R.drawable.alpaka,//세번째 파일 이름
                R.drawable.rose,
                R.drawable.hanriver
        };


        for(int image : images) {
            fllipperImages(image);
        }


    }

    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_fllipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int curld = item.getItemId();
        switch (curld) {
            case R.id.menu_filter:
               Intent intent = new Intent(getApplicationContext(), window.class);
                startActivity(intent);
                break;

            case R.id.menu_search:
                Toast.makeText(this, "검색 메뉴가 선택 되었습니다.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_menu:
                Toast.makeText(this, "메뉴 메뉴가 선택 되었습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void slideInAnimation(ListView listView) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int lastVisiblePosition = listView.getLastVisiblePosition();

        for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
            View view = listView.getChildAt(i - firstVisiblePosition);
            float translationX = view.getWidth(); // 슬라이드할 거리

            // 시작 위치 설정
            view.setTranslationX(-translationX);

            // 애니메이션 생성
            ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0);
            animator.setDuration(500); // 애니메이션 지속 시간 (밀리초)
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setStartDelay(i * 100); // 항목마다 시작 지연 시간 설정
            animator.start();
        }
    }
}
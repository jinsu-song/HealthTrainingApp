package com.sample.healthtrainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import me.relex.circleindicator.CircleIndicator3;

/*
    로그인 또는 회원가입 성공시 나타나는 액티비티
 */
public class LoginSuccessActivity extends AppCompatActivity {
    private ImageButton ibOpenDrawable, ibCloseDrawable;
    private Button btnPT_Reservation, btnChargeInfo, btnManagerPage;
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayout;
    private ViewPager2 viewPager1, viewPager2, viewPager3, viewPager4, viewPager5;
    private CircleIndicator3 indicator1, indicator2, indicator3, indicator4, indicator5;

    private FragmentStateAdapter pagerAdapter, pagerAdapter2, pagerAdapter3, pagerAdapter4, pagerAdapter5;

    private int numberPage = 4;

    // 로그인 또는 회원가입 페이지에서 id값을 intent로 받는 변수
    private String id;

    private static float pageMargin;
    private static float pageOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Intent intent = getIntent();

        id = intent.getStringExtra("id");


        // 위젯 아이디 찾기
        findViewByIdFunc();

        // DrawerLayout 열고 닫기 이벤트
        openAndCloseDrawable();

        // 이벤트 처리
        eventHandlerFunc();

        ViewPager1Func();

        ViewPager2Func();

        ViewPager3Func();

        ViewPager4Func();

        ViewPager5Func();


        pageMargin = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);

    }   // end of onCreate

    private void eventHandlerFunc() {
        btnPT_Reservation.setOnClickListener(v->{
            Intent intent = new Intent(LoginSuccessActivity.this, PT_ReservationActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });
    }   // end of eventHandlerFunc

    private void ViewPager5Func() {
        //ViewPager2
        viewPager5 = findViewById(R.id.viewPager5);

        //Adapter
        //1. 프래그먼트 어댑터를 만들고 보여줄 개수를 설정한다
        //2. 프래그먼트 어댑터를 viewPager2 에 연결시켜준다
        //프래그먼트를 어디서 보여줄건지, 개수는 몇개인지
        pagerAdapter5 = new FragmentAdapter(this, numberPage);
        viewPager5.setAdapter(pagerAdapter5);

        //Indicator
        indicator5 = findViewById(R.id.indicator5);


        //2. circleIndicator 에 viewpager2를 연결해주면 자동으로 개수를 체크해서 실행해준다
        //전체 개수에서 현재 보여줄 위치를 지정한다
        indicator5.setViewPager(viewPager5);
        indicator5.createIndicators(numberPage, 0);


        //3. viewPager2 에 방향 설정 좌우, 상하
        viewPager5.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);



        //ViewPager2 Item을 200개 만들었으니 현재 위치를 100으로setCurrentItem(100) 하여 좌우로 슬라이딩 가능하도록 하였습니다.
        //4.viewPager2 에서 슬라이딩 이 몇개까지 가능한지
        viewPager5.setCurrentItem(100);
        viewPager5.setOffscreenPageLimit(3);

        //5. viewPager3 event처리
        viewPager5.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewPager5.setCurrentItem(position);
                }
            }


            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                indicator5.animatePageSelected(position % numberPage);
            }
        });

        //setPageTransformer를 통해 프래그먼트간 애니메이션 맞춤설정도 가능합니다.
        viewPager5.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (viewPager5.getOrientation() ==
                        ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(viewPager1) ==
                            ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });
    }


    private void ViewPager4Func() {
        //ViewPager2
        viewPager4 = findViewById(R.id.viewPager4);

        //Adapter
        //1. 프래그먼트 어댑터를 만들고 보여줄 개수를 설정한다
        //2. 프래그먼트 어댑터를 viewPager2 에 연결시켜준다
        //프래그먼트를 어디서 보여줄건지, 개수는 몇개인지
        pagerAdapter4 = new FragmentAdapter(this, numberPage);
        viewPager4.setAdapter(pagerAdapter4);

        //Indicator
        indicator4 = findViewById(R.id.indicator4);


        //2. circleIndicator 에 viewpager2를 연결해주면 자동으로 개수를 체크해서 실행해준다
        //전체 개수에서 현재 보여줄 위치를 지정한다
        indicator4.setViewPager(viewPager4);
        indicator4.createIndicators(numberPage, 0);


        //3. viewPager2 에 방향 설정 좌우, 상하
        viewPager4.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);



        //ViewPager2 Item을 200개 만들었으니 현재 위치를 100으로setCurrentItem(100) 하여 좌우로 슬라이딩 가능하도록 하였습니다.
        //4.viewPager2 에서 슬라이딩 이 몇개까지 가능한지
        viewPager4.setCurrentItem(100);
        viewPager4.setOffscreenPageLimit(3);

        //5. viewPager3 event처리
        viewPager4.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewPager4.setCurrentItem(position);
                }
            }


            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                indicator4.animatePageSelected(position % numberPage);
            }
        });


        //setPageTransformer를 통해 프래그먼트간 애니메이션 맞춤설정도 가능합니다.
        viewPager4.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (viewPager4.getOrientation() ==
                        ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(viewPager1) ==
                            ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });

    }



    private void ViewPager3Func() {
        //ViewPager2
        viewPager3 = findViewById(R.id.viewPager3);

        //Adapter
        //1. 프래그먼트 어댑터를 만들고 보여줄 개수를 설정한다
        //2. 프래그먼트 어댑터를 viewPager2 에 연결시켜준다
        //프래그먼트를 어디서 보여줄건지, 개수는 몇개인지
        pagerAdapter3 = new FragmentAdapter(this, numberPage);
        viewPager3.setAdapter(pagerAdapter3);

        //Indicator
        indicator3 = findViewById(R.id.indicator3);


        //2. circleIndicator 에 viewpager2를 연결해주면 자동으로 개수를 체크해서 실행해준다
        //전체 개수에서 현재 보여줄 위치를 지정한다
        indicator3.setViewPager(viewPager3);
        indicator3.createIndicators(numberPage, 0);


        //3. viewPager2 에 방향 설정 좌우, 상하
        viewPager3.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);



        //ViewPager2 Item을 200개 만들었으니 현재 위치를 100으로setCurrentItem(100) 하여 좌우로 슬라이딩 가능하도록 하였습니다.
        //4.viewPager2 에서 슬라이딩 이 몇개까지 가능한지
        viewPager3.setCurrentItem(100);
        viewPager3.setOffscreenPageLimit(3);


        //5. viewPager3 event처리
        viewPager3.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewPager3.setCurrentItem(position);
                }
            }


            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                indicator3.animatePageSelected(position % numberPage);
            }
        });


        //setPageTransformer를 통해 프래그먼트간 애니메이션 맞춤설정도 가능합니다.
        viewPager3.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (viewPager3.getOrientation() ==
                        ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(viewPager1) ==
                            ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });


    }


    private void ViewPager2Func() {
        //ViewPager2
        viewPager2 = findViewById(R.id.viewPager2);

        //Adapter
        //1. 프래그먼트 어댑터를 만들고 보여줄 개수를 설정한다
        //2. 프래그먼트 어댑터를 viewPager2 에 연결시켜준다
        //프래그먼트를 어디서 보여줄건지, 개수는 몇개인지
        pagerAdapter2 = new FragmentAdapter(this, numberPage);
        viewPager2.setAdapter(pagerAdapter2);

        //Indicator
        indicator2 = findViewById(R.id.indicator2);


        //2. circleIndicator 에 viewpager2를 연결해주면 자동으로 개수를 체크해서 실행해준다
        //전체 개수에서 현재 보여줄 위치를 지정한다
        indicator2.setViewPager(viewPager2);
        indicator2.createIndicators(numberPage, 0);


        //3. viewPager2 에 방향 설정 좌우, 상하
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);



        //ViewPager2 Item을 200개 만들었으니 현재 위치를 100으로setCurrentItem(100) 하여 좌우로 슬라이딩 가능하도록 하였습니다.
        //4.viewPager2 에서 슬라이딩 이 몇개까지 가능한지
        viewPager2.setCurrentItem(100);
        viewPager2.setOffscreenPageLimit(3);


        //5. viewPager2 event처리
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewPager2.setCurrentItem(position);
                }
            }


            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                indicator2.animatePageSelected(position % numberPage);
            }
        });


        //setPageTransformer를 통해 프래그먼트간 애니메이션 맞춤설정도 가능합니다.
        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (viewPager1.getOrientation() ==
                        ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(viewPager1) ==
                            ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });

    }


    private void ViewPager1Func() {
        //ViewPager2
        viewPager1 = findViewById(R.id.viewPager1);

        //Adapter
        //1. 프래그먼트 어댑터를 만들고 보여줄 개수를 설정한다
        //2. 프래그먼트 어댑터를 viewPager2 에 연결시켜준다
        //프래그먼트를 어디서 보여줄건지, 개수는 몇개인지
        pagerAdapter = new FragmentAdapter(this, numberPage);
        viewPager1.setAdapter(pagerAdapter);

        //Indicator
        indicator1 = findViewById(R.id.indicator1);

        //2. circleIndicator 에 viewpager2를 연결해주면 자동으로 개수를 체크해서 실행해준다
        //전체 개수에서 현재 보여줄 위치를 지정한다
        indicator1.setViewPager(viewPager1);
        indicator1.createIndicators(numberPage, 0);

        //3. viewPager2 에 방향 설정 좌우, 상하
        viewPager1.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        //ViewPager2 Item을 200개 만들었으니 현재 위치를 100으로setCurrentItem(100) 하여 좌우로 슬라이딩 가능하도록 하였습니다.
        //4.viewPager2 에서 슬라이딩 이 몇개까지 가능한지
        viewPager1.setCurrentItem(100);
        viewPager1.setOffscreenPageLimit(3);

        //5. viewPager2 event처리
        viewPager1.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewPager1.setCurrentItem(position);
                }
            }


            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                indicator1.animatePageSelected(position % numberPage);
            }
        });


        //setPageTransformer를 통해 프래그먼트간 애니메이션 맞춤설정도 가능합니다.
        viewPager1.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (viewPager1.getOrientation() ==
                        ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(viewPager1) ==
                            ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });
    }




    private void openAndCloseDrawable() {
        ibOpenDrawable.setOnClickListener(v->{
            drawerLayout.openDrawer(linearLayout);
        });
        ibCloseDrawable.setOnClickListener(v->{
            drawerLayout.closeDrawer(linearLayout);
        });
    }   // end of openAndCloseDrawable

    private void findViewByIdFunc() {
        ibOpenDrawable = findViewById(R.id.ibOpenDrawable);
        ibCloseDrawable = findViewById(R.id.ibCloseDrawable);
        linearLayout = findViewById(R.id.linearLayout);
        drawerLayout = findViewById(R.id.drawerLayout);
        btnPT_Reservation = findViewById(R.id.btnPT_Reservation);
        btnChargeInfo = findViewById(R.id.btnChargeInfo);
        btnManagerPage = findViewById(R.id.btnManagerPage);
    }   // end of findViewByIdFunc
}
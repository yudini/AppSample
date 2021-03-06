package com.hansung.android.appsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MonthCalendarFragment.OnTitleSelectedListener {
    // 데이터 원본 준비
    Calendar today;
    ArrayList<String> list = new ArrayList<>();
    Intent getIn;


    //앱바
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.month:
                //월 달력으로 프래그먼트 전환하는 코드 작성
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new MonthViewFragment());
                fragmentTransaction.commit();
                return true;
            case R.id.week:
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.fragment_container, new WeekViewFragment());
                fragmentTransaction2.commit();
                //주 달력으로 프래그먼트 전환하는 코드 작성
                Toast.makeText(getApplicationContext(), "주", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new MonthViewFragment());
        fragmentTransaction.commit();

        today = Calendar.getInstance();   //현재 날짜를 가진 캘린더 객체 생성

        getSupportActionBar().setTitle(today.get(Calendar.YEAR)+"년"+(today.get(Calendar.MONTH)+1)+"월");
    }
    public void onTitleSelected(int year,int month,int day,View view) {

        GridView gridView = findViewById(R.id.gridview);
        if(day>=1){
            Toast.makeText(getApplicationContext(),+year+"."+(month+1)+"."+day,Toast.LENGTH_SHORT).show();
        }
            //날짜가 있을때만 토스트 메세지 띄우기
            //캘린더 클래스의 월은 0~11, +1을 해주어서 1~12로 설정
    }

}
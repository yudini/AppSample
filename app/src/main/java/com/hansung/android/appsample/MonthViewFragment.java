package com.hansung.android.appsample;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MonthViewFragment extends Fragment {

    Calendar today;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;

    public MonthViewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MonthViewFragment newInstance(int year, int month) {
        MonthViewFragment fragment = new MonthViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, year);
        args.putInt(ARG_PARAM2, month);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_month_view,container, false);

        ViewPager2 vpPager = rootView.findViewById(R.id.vpPager);
        FragmentStateAdapter adapter = new MonthAdapter(this);
        vpPager.setAdapter(adapter);
        vpPager.setCurrentItem(3,false);  // SecondFragment를 첫 화면에 표시되도록 설정


        vpPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                ActionBar actionBar =((MainActivity)getActivity()).getSupportActionBar();
                actionBar.setTitle(today.get(Calendar.YEAR)+"년"+(today.get(Calendar.MONTH)+1)+"월");
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}
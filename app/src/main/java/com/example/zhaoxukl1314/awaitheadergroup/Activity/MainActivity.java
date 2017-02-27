package com.example.zhaoxukl1314.awaitheadergroup.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaoxukl1314.awaitheadergroup.R;
import com.example.zhaoxukl1314.awaitheadergroup.View.AwaitHeaderTab;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private AwaitHeaderTab mHeader;
    private ViewPager mPage;
    private List<View> mViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeader = (AwaitHeaderTab) findViewById(R.id.await_header_tab);
        mPage = (ViewPager) findViewById(R.id.viewpager);
        View view1 = View.inflate(this, R.layout.await_header_tab, null);
        View view2 = View.inflate(this, R.layout.await_header_tab, null);
        View view3 = View.inflate(this, R.layout.await_header_tab, null);
        mHeader.addTab(0, view1);
        mHeader.addTab(1, view2);
        mHeader.addTab(2, view3);

        View pageView1 = View.inflate(this, R.layout.await_header_tab, null);
        View pageView2 = View.inflate(this, R.layout.await_header_tab, null);
        View pageView3 = View.inflate(this, R.layout.await_header_tab, null);

        mViewList = new ArrayList<View>();
        mViewList.add(pageView1);
        mViewList.add(pageView2);
        mViewList.add(pageView3);

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return mViewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(mViewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(mViewList.get(position));


                return mViewList.get(position);
            }
        };

        mPage.setAdapter(pagerAdapter);

        mHeader.setOnTabSelectListener(new AwaitHeaderTab.OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mPage.setCurrentItem(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
    }
}

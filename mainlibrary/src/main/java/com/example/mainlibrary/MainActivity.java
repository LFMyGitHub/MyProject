package com.example.mainlibrary;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.chatlibrary.ChatFragment;
import com.example.commonlibrary.base.BaseToolbarActivity;
import com.example.minelibrary.MineFragment;
import com.example.newslibrary.NewsFragment;
import com.example.shoplibrary.ShopFragment;

import static com.example.commonlibrary.config.AppConstant.NavigationModule.COMMUNITY_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.HOME_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.MESSAGE_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.MINE_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.SHOP_TAB;

@Route(path = "/mainlibrary/mainactivity")
public class MainActivity extends BaseToolbarActivity {
    private Fragment mMineFragment;
    private Fragment mChatFragment;
    private Fragment mMainFragment;
    private Fragment mShopFragment;
    private Fragment mNewsFragment;

    private String mCurrentTab = HOME_TAB;

    @Override
    protected int getContentViewId() {
        return com.example.commonlibrary.R.layout.activity_content;
    }

    @Override
    protected Fragment getFragment() {
        return null;
    }

    @Override
    protected int getFragmentContentId() {
        return com.example.commonlibrary.R.id.activity_contentFrame;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化导航栏
        initTab(savedInstanceState);
    }

    /**
     * 初始化首页Tab
     */
    private void initTab(Bundle savedInstanceState) {
        //mUnbinder = ButterKnife.bind(this);

        //String theme = SimulateNetAPI.getOriginalFundData("json/sojson.com.json", this);
        //themeAdapter(null);

        mMainFragment = new MainFragment();
        mNewsFragment = new NewsFragment();
        mShopFragment = new ShopFragment();
        mChatFragment = new ChatFragment();
        mMineFragment = new MineFragment();

        //无缓存添加fragment
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (transaction == null) {
                return;
            }

            Fragment homeFragment = getSupportFragmentManager().findFragmentByTag(HOME_TAB);
            Fragment communityFragment = getSupportFragmentManager().findFragmentByTag(COMMUNITY_TAB);
            Fragment shopFragment = getSupportFragmentManager().findFragmentByTag(SHOP_TAB);
            Fragment messageFragment = getSupportFragmentManager().findFragmentByTag(MESSAGE_TAB);
            Fragment mineFragment = getSupportFragmentManager().findFragmentByTag(MINE_TAB);
            if (homeFragment == null) {
                transaction.add(
                        getFragmentContentId(),
                        mMainFragment,
                        HOME_TAB
                );
            }

            if (communityFragment == null) {
                transaction.add(
                        getFragmentContentId(),
                        mNewsFragment,
                        COMMUNITY_TAB
                ).hide(mNewsFragment);
            }

            if (shopFragment == null) {
                transaction.add(
                        getFragmentContentId(),
                        mShopFragment,
                        SHOP_TAB
                ).hide(mShopFragment);
            }

            if (messageFragment == null) {
                transaction.add(
                        getFragmentContentId(),
                        mChatFragment,
                        MESSAGE_TAB
                ).hide(mChatFragment);
            }

            if (mineFragment == null) {
                transaction.add(
                        getFragmentContentId(),
                        mMineFragment,
                        MINE_TAB
                ).hide(mMineFragment);
            }
            transaction.commitAllowingStateLoss();
        } else {
            checkTab(savedInstanceState.getString("current_tab"));
        }

//        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.home_tab:
//                        mTopView.setVisibility(View.GONE);
//                        changeTab(HOME_TAB);
//                        break;
//                    case R.id.community_tab:
//                        mTopView.setVisibility(View.VISIBLE);
//                        showIv(1, false);
//                        showTv(3, true);
//                        setText(3, getString(R.string.my_application));
//                        changeTab(COMMUNITY_TAB);
//                        break;
//                    case R.id.shop_tab:
//                        mTopView.setVisibility(View.GONE);
//                        if (mShared.getBoolean(AppConstant.UserInfoModule.IS_LOGIN, false)) {
//                            LinkUtils.parse(MainActivity.this, "https://csqfqz.xinfuli.net/api/isv/xcyd/login", "商城", true);
//                        } else {
//                            LoginActivity.startActivity(MainActivity.this);
//                        }
//                        break;
//                    case R.id.message_tab:
//                        mTopView.setVisibility(View.GONE);
//                        if (tabsEntity != null && !TextUtils.isEmpty(tabsEntity.getData().getTabs().getLinli_url())) {
//                            mWebViewFragment.reLoadUrl();
//                        }
//                        changeTab(MESSAGE_TAB);
//                        break;
//                    case R.id.mine_tab:
//                        mTopView.setVisibility(View.GONE);
//                        changeTab(MINE_TAB);
//                        break;
//                }
//            }
//        });
//
//
//        checkTab(HOME_TAB);//初始化TAB选项
    }

    /**
     * 非点击底部RadioButton切换选项卡
     *
     * @param tab
     */
    public void checkTab(String tab) {
        if (TextUtils.isEmpty(tab)) return;
//        switch (tab) {
//            case HOME_TAB:
//                if (mHomeTab == null) return;
//                mHomeTab.setChecked(true);
//                break;
//            case COMMUNITY_TAB:
//                if (mCommunityTab == null) return;
//                mCommunityTab.setChecked(true);
//                break;
//            case SHOP_TAB:
//                if (mShopTab == null) return;
//                mShopTab.setChecked(true);
//                break;
//            case MESSAGE_TAB:
//                if (mMessageTab == null) return;
//                mMessageTab.setChecked(true);
//                break;
//            case MINE_TAB:
//                if (mMineTab == null) return;
//                mMineTab.setChecked(true);
//                break;
//        }
    }
}

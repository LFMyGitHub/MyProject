package com.example.mainlibrary;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.chatlibrary.ChatFragment;
import com.example.commonlibrary.base.BaseApplication;
import com.example.commonlibrary.base.BaseToolbarActivity;
import com.example.commonlibrary.utils.ActivityUtils;
import com.example.mainlibrary.utils.TableLayoutUtils;
import com.example.minelibrary.MineFragment;
import com.example.newslibrary.NewsFragment;
import com.example.shoplibrary.ShopFragment;

import static com.example.commonlibrary.config.AppConstant.NavigationModule.COMMUNITY_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.HOME_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.MESSAGE_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.MINE_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.SHOP_TAB;

@Route(path = "/mainlibrary/mainactivity")
public class MainActivity extends BaseToolbarActivity{
    private Context mContext;

    private Fragment mMineFragment;
    private Fragment mChatFragment;
    private Fragment mMainFragment;
    private Fragment mShopFragment;
    private Fragment mNewsFragment;

    private String mCurrentTab = HOME_TAB;

    @BindView(com.example.commonlibrary.R2.id.commlib_toolbar_view)
    View mTopView;
    @BindView(com.example.commonlibrary.R2.id.commlib_rg_bottom)
    RadioGroup mRadioGroup;
    @BindView(com.example.commonlibrary.R2.id.commlib_home_tab)
    RadioButton mHomeTab;
    @BindView(com.example.commonlibrary.R2.id.commlib_news_tab)
    RadioButton mNewsTab;
    @BindView(com.example.commonlibrary.R2.id.commlib_shop_tab)
    RadioButton mShopTab;
    @BindView(com.example.commonlibrary.R2.id.commlib_message_tab)
    RadioButton mMessageTab;
    @BindView(com.example.commonlibrary.R2.id.commlib_mine_tab)
    RadioButton mMineTab;

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
        mContext = BaseApplication.getInstance().getApplicationContext();
        //初始化导航栏
        initTab(savedInstanceState);
        defaultTheme();
    }

    /**
     * 初始化首页Tab
     */
    private void initTab(Bundle savedInstanceState) {
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

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == com.example.commonlibrary.R.id.commlib_home_tab){
                    mTopView.setVisibility(View.GONE);
                    changeTab(HOME_TAB);
                }else if(checkedId == com.example.commonlibrary.R.id.commlib_news_tab){
                    mTopView.setVisibility(View.VISIBLE);
                    showIv(1, false);
                    showTv(3, true);
                    setText(3, "资讯");
                    changeTab(COMMUNITY_TAB);
                }else if(checkedId == com.example.commonlibrary.R.id.commlib_shop_tab){
                    mTopView.setVisibility(View.GONE);
                    changeTab(SHOP_TAB);
                }else if(checkedId == com.example.commonlibrary.R.id.commlib_message_tab){
                    mTopView.setVisibility(View.GONE);
                    changeTab(MESSAGE_TAB);
                }else if(checkedId == com.example.commonlibrary.R.id.commlib_mine_tab){
                    mTopView.setVisibility(View.GONE);
                    changeTab(MINE_TAB);
                }
            }
        });

        //初始化TAB选项
        checkTab(HOME_TAB);
    }

    /**
     * 点击底部RadioButton切换选项卡
     *
     * @param tab
     */
    private void changeTab(String tab) {
        mCurrentTab = tab;
        ActivityUtils.switchFragmentInMainPage(
                getSupportFragmentManager(),
                tab
        );
    }

    /**
     * 非点击底部RadioButton切换选项卡
     *
     * @param tab
     */
    public void checkTab(String tab) {
        if (TextUtils.isEmpty(tab)) return;
        switch (tab) {
            case HOME_TAB:
                if (mHomeTab == null) return;
                mHomeTab.setChecked(true);
                break;
            case COMMUNITY_TAB:
                if (mNewsTab == null) return;
                mNewsTab.setChecked(true);
                break;
            case SHOP_TAB:
                if (mShopTab == null) return;
                mShopTab.setChecked(true);
                break;
            case MESSAGE_TAB:
                if (mMessageTab == null) return;
                mMessageTab.setChecked(true);
                break;
            case MINE_TAB:
                if (mMineTab == null) return;
                mMineTab.setChecked(true);
                break;
        }
    }

    /**
     * 默认风格
     */
    private void defaultTheme() {
        TableLayoutUtils.addSelectorFromDrawable(mContext, com.example.commonlibrary.R.drawable.cx_tab_icon_hhome_n, com.example.commonlibrary.R.drawable.cx_tab_icon_hhome_s, mHomeTab);
        TableLayoutUtils.addSelectorFromDrawable(mContext, com.example.commonlibrary.R.drawable.cx_tab_icon_news_n, com.example.commonlibrary.R.drawable.cx_tab_icon_news_s, mNewsTab);
        TableLayoutUtils.addSelectorFromDrawable(mContext, com.example.commonlibrary.R.drawable.cx_tab_icon_shop_n, com.example.commonlibrary.R.drawable.cx_tab_icon_shop_s, mShopTab);
        TableLayoutUtils.addSelectorFromDrawable(mContext, com.example.commonlibrary.R.drawable.cx_tab_icon_message_n, com.example.commonlibrary.R.drawable.cx_tab_icon_message_s, mMessageTab);
        TableLayoutUtils.addSelectorFromDrawable(mContext, com.example.commonlibrary.R.drawable.cx_tab_icon_me_n, com.example.commonlibrary.R.drawable.cx_tab_icon_me_s, mMineTab);
        TableLayoutUtils.addTVSeletor(MainActivity.class, "#97a0ab", "#2E7BEF", mHomeTab);
        TableLayoutUtils.addTVSeletor(MainActivity.class, "#97a0ab", "#2E7BEF", mNewsTab);
        TableLayoutUtils.addTVSeletor(MainActivity.class, "#97a0ab", "#2E7BEF", mShopTab);
        TableLayoutUtils.addTVSeletor(MainActivity.class, "#97a0ab", "#2E7BEF", mMessageTab);
        TableLayoutUtils.addTVSeletor(MainActivity.class, "#97a0ab", "#2E7BEF", mMineTab);
    }
}

package com.example.commonlibrary.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.example.commonlibrary.config.AppConstant.NavigationModule.COMMUNITY_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.HOME_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.MESSAGE_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.MINE_TAB;
import static com.example.commonlibrary.config.AppConstant.NavigationModule.SHOP_TAB;

public class ActivityUtils {

    /**
     * 将fragment添加到容器中,由fragmentManager执行
     *
     * @param fragmentManager
     * @param fragment
     * @param frameId
     */
    public static void addFragmenttoActivity(
            @NonNull FragmentManager fragmentManager,
            @NonNull Fragment fragment,
            int frameId,
            String tag
    ) {
        if (fragmentManager == null || fragment == null) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment, tag);
        transaction.commitNowAllowingStateLoss();
    }

    public static void addFragmenttoActivity(
            @NonNull FragmentManager fragmentManager,
            @NonNull Fragment fragment,
            int frameId
    ) {
        addFragmenttoActivity(
                fragmentManager,
                fragment,
                frameId,
                null
        );
    }


    /**
     * 替换fragment
     *
     * @param fragmentManager
     * @param fragment
     * @param frameId
     */
    public static void replaceFragment(
            @NonNull FragmentManager fragmentManager,
            @NonNull Fragment fragment,
            int frameId
    ) {
        if (fragment == null || fragmentManager == null) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commitNowAllowingStateLoss();
    }

    /**
     * 切换首页选项卡的显示
     *
     * @param fragmentManager
     * @param fragmentTag
     */
    public static void switchFragmentInMainPage(
            @NonNull FragmentManager fragmentManager,
            @NonNull String fragmentTag
    ) {
        if (fragmentManager == null || fragmentTag == null) {
            return;
        }
        Fragment homeFragment = fragmentManager.findFragmentByTag(HOME_TAB);
        Fragment communityFragment = fragmentManager.findFragmentByTag(COMMUNITY_TAB);
        Fragment shopFragment = fragmentManager.findFragmentByTag(SHOP_TAB);
        Fragment messageFragment = fragmentManager.findFragmentByTag(MESSAGE_TAB);
        Fragment mineFragment = fragmentManager.findFragmentByTag(MINE_TAB);
        if (homeFragment == null || communityFragment == null || shopFragment == null || messageFragment == null || mineFragment == null) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (transaction == null) {
            return;
        }
        switch (fragmentTag) {
            case HOME_TAB:
                transaction.hide(communityFragment);
                transaction.hide(shopFragment);
                transaction.hide(messageFragment);
                transaction.hide(mineFragment);
                transaction.show(homeFragment);
                transaction.commitNowAllowingStateLoss();
                break;
            case COMMUNITY_TAB:
                transaction.show(communityFragment);
                transaction.hide(shopFragment);
                transaction.hide(messageFragment);
                transaction.hide(mineFragment);
                transaction.hide(homeFragment);
                transaction.commitNowAllowingStateLoss();
                break;
            case SHOP_TAB:
                transaction.hide(communityFragment);
                transaction.show(shopFragment);
                transaction.hide(messageFragment);
                transaction.hide(mineFragment);
                transaction.hide(homeFragment);
                transaction.commitNowAllowingStateLoss();
                break;
            case MESSAGE_TAB:
                transaction.hide(communityFragment);
                transaction.hide(shopFragment);
                transaction.show(messageFragment);
                transaction.hide(mineFragment);
                transaction.hide(homeFragment);
                transaction.commitNowAllowingStateLoss();
                break;
            case MINE_TAB:
                transaction.hide(communityFragment);
                transaction.hide(shopFragment);
                transaction.hide(messageFragment);
                transaction.show(mineFragment);
                transaction.hide(homeFragment);
                transaction.commitNowAllowingStateLoss();
                break;
        }
    }
}

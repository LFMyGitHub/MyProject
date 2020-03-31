package com.example.commonlibrary.config;

public class AppConstant {
    //做一个开关用来打印日志0:打印1:不打印
    public static final int SWITCH = 0;

    //当前服务器
    public static final String SERVER = ServerKey.DEV;

    //主域名
    public static String NEW_API = "";

    public static void getServer() {
        if (SERVER.equals(ServerKey.DEV)) {
            devApi();
        } else if (SERVER.equals(ServerKey.TEST)) {
            testApi();
        } else {
            //默认开发环境
            devApi();
        }
    }

    public static class ServerKey {
        //开发环境
        public static final String DEV = "dev";
        //测试环境
        public static final String TEST = "test";
    }

    public static class ApiModule {
        //获取快捷登录列表
        public static final String QUICK_LIST_API = "app/home/quickLogin";
    }

    public static class NavigationModule {
        //首页选项卡
        public static final String HOME_TAB = "homeTab";
        //社区选项卡
        public static final String COMMUNITY_TAB = "communityTab";
        //商城条选项卡
        public static final String SHOP_TAB = "shopTab";
        //消息选项卡
        public static final String MESSAGE_TAB = "messageTab";
        //我的选项卡
        public static final String MINE_TAB = "mineTab";
    }

    //保存的SharedPreferences静态常量
    public static class SharedModule {
        //保存的星城园丁版本名
        public static final String SAVEVERSION = "SAVEVERSION";
        //保存的星城园丁版本号
        public static final String SAVEVERSIONCODE = "SAVEVERSIONCODE";
    }

    public static class WebViewModule {

    }

    //用户相关信息
    public static class UserInfoModule {
        public static final String USER_INFO = "user_info";
    }

    //地图相关
    public static class MapModule {
    }

    private static void testApi() {
        NEW_API = "https://uc-csgatest.xcydhn.com";
    }

    private static void devApi() {
        NEW_API = "http://uc-csga.xcydhn.com";
    }

    //缓存
    public static class Cache {
    }
}

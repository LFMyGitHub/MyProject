package com.example.mainlibrary.entity;

import java.util.List;

public class HomeDataEntity {

    private List<MessagesBean> messages;
    private List<AdsBean> ads;

    public List<MessagesBean> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesBean> messages) {
        this.messages = messages;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public static class MessagesBean {
        /**
         * title : 本周6上班
         * create_date : 1970/05/09 22:25
         * type : 2
         */

        private String title;
        private String create_date;
        private String type;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class AdsBean {
        /**
         * name : 泰康人寿
         * cover : https://res-csga.xcydhn.com/eba20d3c6cd6d3b82f6db24e41aa8f71.jpg
         * url : https://v.xiumi.us/board/v5/4vEGF/173523645
         */

        private String name;
        private String cover;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

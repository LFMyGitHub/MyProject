package com.example.newslibrary.entity;

import java.util.List;

public class NewsEntity {

    /**
     * result : [{"content":"楼主大四女生，这几天和同一宿舍的女生一起去找工作，在火车站，碰到一个大姐，带着一个四五岁的小男孩侯车，小男孩总是粘着我，要坐我腿上，同宿舍的女生很是羡慕我有人缘，我得意的问小男孩：\u201c你为什么老是喜欢坐姐姐腿上？\u201d 小男孩用稚嫩的口气回答：\u201c姐姐腿上肉多，坐着舒服\u201d 我：\u201c尼玛，这是谁家小哔崽子，快点领走！\u201d","hashId":"8d914207de87e464bc99055a02160d27","unixtime":"1554778627","updatetime":"2019-04-09 10:57:07"},{"content":"女：\u201c我购物车里的那些水果牛奶饮料零食你赶紧给我买！\u201d 男：\u201c着什么急呀？\u201d 女：\u201c天越来越热了，会放坏的。\u201d","hashId":"7236a1fe92605a8b5540c4279bd8f973","unixtime":"1554778627","updatetime":"2019-04-09 10:57:07"},{"content":"朋友问我：有一种鸟，好笑又神经，它是什么鸟？我：我不知道。。沙雕！","hashId":"ef96e378ef21de4e38056b28d9e3dbe8","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"},{"content":"昨天在家看抗日神剧，我问六岁的小侄女：\u201c宝宝，你知道为什么曰本人头盔两耳边有两块布么？\u201d 她不假思索的瞟了我一眼：\u201c叔叔你真笨，他们设计这两块布肯定是防止被长官打耳光的！\u201d 我。。。","hashId":"4c57f4f968e3c169149d7e86da5e36b3","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"},{"content":"昨天哥哥和嫂子有事出门，把小侄子留给我了，我带他去街上，非要拉着我给他买玩具，我给他说：\u201c姑姑兜里没带钱。\u201d 小侄子从自己兜里掏出三百块钱说：\u201c就知道你小气，花我的钱。\u201d 我俩去玩具店，给侄子买了好多玩具，又去吃了顿饭，三百块终于造完了。 摸着肚子问侄子：\u201c这钱是你妈留给你的吗？\u201d 侄子摸摸头说：\u201c不是啊！来的时候趁你不注意，在你包里拿的。\u201d","hashId":"26c80f07d746ca16261079ba2ed412d1","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"},{"content":"今天不巧看见前女友，更不巧的是我俩都穿的以前买的情侣装。。。 我寻思见面总得打个招呼吧，就贱贱的过去了，本想说\u201c好巧啊，咱俩竟还能然穿情侣装\u201d，没想到被她抢先一句\u201c呦～还有跟老娘穿亲子装的！\u201d 。。。","hashId":"548aae5b3b2630ee8353c1cc13741265","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"},{"content":"今天坐高铁回家注意到身边一名男子，他穿得干净、得体，脸庞留下少许岁月痕迹。 他忧郁的眼神，时而静静望窗外，像是思考过往人生；时而双眼微闭，让疲倦的身体有片刻歇息。 根据个人多年行为模式研究、心理学观察及社会经验判断\u2014\u2014\u2015\u2015这人十有八九是手机没电了。","hashId":"f812b44e0fc9c87278ae74d325c4b207","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"},{"content":"家里大拜祖先。小明不拜，说：\u201c拜祖先有什么用，祖先又不会保佑的！\u201d爸爸：\u201c你个死孩子，不要乱说！\u201d小明：\u201c谁乱说了啊。\u201d他指着供桌上的猪头：\u201c要是祖先会保佑的话，这猪的祖先天蓬元帅怎么会让自己的后辈子孙给人宰了当祭品。\u201d","hashId":"822796875b1503824bb55bbce022d4df","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"},{"content":"三毛去发型屋做发型，对发型师说：给我编个麻花辫。发型师不小心弄掉了三毛的一根头发。三毛叹口气说：那来个中分好拉。可是发型师不小心又弄掉了根。三毛一看火了：你丫的想让我披头散发？","hashId":"64840fad250dc560a309537256d9b6d7","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"},{"content":"酒吧里，一个大汉侃侃而谈：\u201c我们出来 混社团，最重要的就是信用二字！\u201d旁边 几个小年轻赶紧上前，崇拜的为他点了 一支烟问：\u201c哥，不知您混的哪个社 团？\u201d大汉吸了口烟，眯着眼睛答道：\u201c铁 岭农村信用社。\u201d","hashId":"dcb79fee2ff3153d36377afed622311c","unixtime":"1554688803","updatetime":"2019-04-08 10:00:03"}]
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;
    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 楼主大四女生，这几天和同一宿舍的女生一起去找工作，在火车站，碰到一个大姐，带着一个四五岁的小男孩侯车，小男孩总是粘着我，要坐我腿上，同宿舍的女生很是羡慕我有人缘，我得意的问小男孩：“你为什么老是喜欢坐姐姐腿上？” 小男孩用稚嫩的口气回答：“姐姐腿上肉多，坐着舒服” 我：“尼玛，这是谁家小哔崽子，快点领走！”
         * hashId : 8d914207de87e464bc99055a02160d27
         * unixtime : 1554778627
         * updatetime : 2019-04-09 10:57:07
         */

        private String content;
        private String hashId;
        private String unixtime;
        private String updatetime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }
}

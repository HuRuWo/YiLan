package com.example.administrator.yilan000.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class NewsGson {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-10-11 10:53","title":"南京六合区：继续组织搜捕外逃眼镜蛇，幼蛇毒性不大过","description":"网易社会","picUrl":"","url":"http://news.163.com/16/1011/10/C33ET2G000014SEH.html#f=slist"},{"ctime":"2016-10-11 11:10","title":"山西长治8岁女童疑遭男老师性侵 警方：已移送检方起诉","description":"网易社会","picUrl":"","url":"http://news.163.com/16/1011/11/C33FTEJ300014SEH.html#f=slist"},{"ctime":"2016-10-11 11:14","title":"南京六合警方介入眼镜蛇外逃事件，涉事无证养殖场已被","description":"网易社会","picUrl":"","url":"http://news.163.com/16/1011/11/C33G4HLD00014SEH.html#f=slist"},{"ctime":"2016-10-11 11:26","title":"南京六合养殖场眼镜蛇大逃亡 搜蛇队紧急出动","description":"网易社会","picUrl":"","url":"http://news.163.com/16/1011/11/C33GR7U0000146BE.html#f=slist"},{"ctime":"2016-10-11 11:34","title":"南京楼市新政实施后：市民开具购房证明排队至凌晨","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/10/11/201610110945557d7b4.jpg.119x83.jpg","url":"http://news.163.com/16/1011/11/C33H93BT00014SEH.html#f=slist"},{"ctime":"2016-10-11 11:41","title":"盗刷团伙应聘饭店服务员窃取银行卡信息，连夜刷走254","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/10/11/20161011095547804bd.jpg.119x83.jpg","url":"http://news.163.com/16/1011/11/C33HL00L00014SEH.html#f=slist"},{"ctime":"2016-10-11 11:50","title":"广州一高中生宿舍楼坠亡 留遗书:感觉自己很累","description":"网易社会","picUrl":"http://cms-bucket.nosdn.127.net/catchpic/D/DD/DD6E9EE654C5759B1615B6CE51C846C2.jpg?imageView&thumbnail=119y83","url":"http://news.163.com/16/1011/11/C33I5EUS00011229.html#f=slist"},{"ctime":"2016-10-11 11:51","title":"男子蹲着如厕时马桶爆裂 血流成河缝合40余针","description":"网易社会","picUrl":"http://cms-bucket.nosdn.127.net/catchpic/7/7F/7F75D1627B9A82FD45EDB8430E92D027.jpg?imageView&thumbnail=119y83","url":"http://news.163.com/16/1011/11/C33I7JRC00011229.html#f=slist"},{"ctime":"2016-10-11 12:11","title":"广州地下试管婴儿市场暗潮涌动 花8万可选生男女","description":"网易社会","picUrl":"http://cms-bucket.nosdn.127.net/catchpic/7/70/70C730A86B3E5DE85B34281A663053E7.jpg?imageView&thumbnail=119y83","url":"http://news.163.com/16/1011/12/C33JCRC300011229.html#f=slist"},{"ctime":"2016-10-11 12:20","title":"河南偃师一男子酒后杀死父母 因不满父母催婚","description":"网易社会","picUrl":"http://cms-bucket.nosdn.127.net/catchpic/7/74/74D322C07A592CBDCF421D2EE6998B1F.jpg?imageView&thumbnail=119y83","url":"http://news.163.com/16/1011/12/C33JSUNC000146BE.html#f=slist"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-10-11 10:53
     * title : 南京六合区：继续组织搜捕外逃眼镜蛇，幼蛇毒性不大过
     * description : 网易社会
     * picUrl :
     * url : http://news.163.com/16/1011/10/C33ET2G000014SEH.html#f=slist
     */

    private List<NewslistBean> newslist;

    public static NewsGson objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, NewsGson.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public static NewslistBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, NewslistBean.class);
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

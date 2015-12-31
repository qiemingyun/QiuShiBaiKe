package com.my.qiushibaike.entities;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RACHEL on 2015/12/30.
 */
public class QiuShiItem {

    /**
     * high_url : http://qiubai-video.qiushibaike.com/5XA6QVPP3RS5U6R9.mp4
     * format : video
     * image : null
     * published_at : 1451430901
     * tag :
     * user : {"avatar_updated_at":1447941875,"last_visited_at":1429708225,"created_at":1429708225,"state":"active","email":"","last_device":"android_6.5.0","role":"n","login":"苏兰伊一","id":27848148,"icon":"20151119140435.jpg"}
     * image_size : null
     * id : 114473049
     * votes : {"down":-96,"up":3093}
     * created_at : 1451399444
     * pic_size : [480,480]
     * pic_url : http://qiubai-video.qiushibaike.com/5XA6QVPP3RS5U6R9.jpg
     * content : 最后一只小狗跳出了自己的风格 转自快手
     * state : publish
     * comments_count : 35
     * low_url : http://qiubai-video.qiushibaike.com/5XA6QVPP3RS5U6R9_3g.mp4
     * allow_comment : true
     * share_count : 900
     * type : hot
     * loop : 212880
     */

    private List<ItemsEntity> items;

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        private String format;
        private Object image;
        /**
         * avatar_updated_at : 1447941875
         * last_visited_at : 1429708225
         * created_at : 1429708225
         * state : active
         * email :
         * last_device : android_6.5.0
         * role : n
         * login : 苏兰伊一
         * id : 27848148
         * icon : 20151119140435.jpg
         */

        private UserEntity user;
        private int id;
        /**
         * down : -96
         * up : 3093
         */

        private VotesEntity votes;
        private String pic_url;
        private String content;
        private int comments_count;
        private int share_count;
        private String type;

        public void setFormat(String format) {
            this.format = format;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public Object getImage() {
            return image;
        }

        public UserEntity getUser() {
            return user;
        }

        public int getId() {
            return id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public String getPic_url() {
            return pic_url;
        }

        public String getContent() {
            return content;
        }

        public int getComments_count() {
            return comments_count;
        }

        public int getShare_count() {
            return share_count;
        }

        public String getType() {
            return type;
        }

        public static class UserEntity {
            private String login;
            private int id;
            private String icon;

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getLogin() {
                return login;
            }

            public int getId() {
                return id;
            }

            public String getIcon() {
                return icon;
            }
        }

        public static class VotesEntity {
            private int down;
            private int up;

            public void setDown(int down) {
                this.down = down;
            }

            public void setUp(int up) {
                this.up = up;
            }

            public int getDown() {
                return down;
            }

            public int getUp() {
                return up;
            }
        }


        // 通过正则 生成对应item icon 和 image 图片 url

        private static final Pattern pattern = Pattern.compile("(\\d+)\\d{4}");
        private static final String IMAGE_URL = "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";
        private static final String ICON_URL = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";


        public String getImageUrl(){
            if ( image!= null) {
                Matcher matcher = pattern.matcher(image.toString());
                matcher.find();
                // TODO: 2015/12/30 检查网络情况 加载small 或 middle 图片
                return String.format(IMAGE_URL, matcher.group(1), matcher.group(), "small", image);
            } else {
                return null;
            }
        }

        public String getIconUrl(){
            if (user != null) {
                return String.format(ICON_URL, user.id / 10000, user.id, user.icon);
            } else {
                return null;
            }
        }
    }

}

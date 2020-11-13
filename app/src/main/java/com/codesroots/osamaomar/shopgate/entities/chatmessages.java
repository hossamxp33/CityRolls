package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class chatmessages {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {



        /**
         * id : 9
         * post : hey you!!
         * message_id : 1
         * created : 2018-01-28T15:26:41+0000
         * modified : 2018-01-28T15:26:41+0000
         * too : 1
         * fromm : 2
         * photo :
         * frommm : {"id":2,"username":"osama","photo":null}
         * tooo : {"id":1,"username":"admin","photo":"15402985131278049313.jpg"}
         */

        private int id;
        private String post;
        private int message_id;
        private String created;
        private String modified;
        private int too;
        private int fromm;
        private String photo;
        private FrommmBean frommm;
        private ToooBean tooo;
        private int imageIsLocalOrOnline=1;///by default is online

        public DataBean(String post, int too, int fromm, String photo,int imageStatues,String time) {
            this.post = post;
            this.too = too;
            this.fromm = fromm;
            this.photo = photo;
            this.imageIsLocalOrOnline = imageStatues;
            this.created = time;
        }

        public int getImageIsLocalOrOnline() {
            return imageIsLocalOrOnline;
        }

        public void setImageIsLocalOrOnline(int imageIsLocalOrOnline) {
            this.imageIsLocalOrOnline = imageIsLocalOrOnline;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public int getMessage_id() {
            return message_id;
        }

        public void setMessage_id(int message_id) {
            this.message_id = message_id;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public int getToo() {
            return too;
        }

        public void setToo(int too) {
            this.too = too;
        }

        public int getFromm() {
            return fromm;
        }

        public void setFromm(int fromm) {
            this.fromm = fromm;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public FrommmBean getFrommm() {
            return frommm;
        }

        public void setFrommm(FrommmBean frommm) {
            this.frommm = frommm;
        }

        public ToooBean getTooo() {
            return tooo;
        }

        public void setTooo(ToooBean tooo) {
            this.tooo = tooo;
        }

        public static class FrommmBean {
            /**
             * id : 2
             * username : osama
             * photo : null
             */

            private int id;
            private String username;
            private Object photo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
            }
        }

        public static class ToooBean {
            /**
             * id : 1
             * username : admin
             * photo : 15402985131278049313.jpg
             */

            private int id;
            private String username;
            private String photo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }
}

package com.codesroots.osamaomar.shopgate.entities;

public class AddToFavModel {


    /**
     * postlike : {"user_id":115,"product_id":22,"created":"2019-06-23T10:22:59+0000","modified":"2019-06-23T10:22:59+0000","id":92}
     * likeid : 92
     */

    private PostlikeBean postlike;
    private int likeid;

    public PostlikeBean getPostlike() {
        return postlike;
    }

    public void setPostlike(PostlikeBean postlike) {
        this.postlike = postlike;
    }

    public int getLikeid() {
        return likeid;
    }

    public void setLikeid(int likeid) {
        this.likeid = likeid;
    }

    public static class PostlikeBean {
        /**
         * user_id : 115
         * product_id : 22
         * created : 2019-06-23T10:22:59+0000
         * modified : 2019-06-23T10:22:59+0000
         * id : 92
         */

        private int user_id;
        private int product_id;
        private String created;
        private String modified;
        private int id;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}

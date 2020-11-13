package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class ProductRate {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 30
         * name : zzzz
         * name_en : salt
         * productrates : [{"id":4,"user_id":5,"rate":3,"created":"2019-03-20T11:45:26+0000","modified":"2019-03-20T11:45:26+0000","comment":"gamel gdn","product_id":30,"user":{"id":5,"username":"admin"}},{"id":5,"user_id":5,"rate":3,"created":"2019-03-20T12:55:10+0000","modified":"2019-03-20T12:55:10+0000","comment":"gamel gdn","product_id":30,"user":{"id":5,"username":"admin"}},{"id":6,"user_id":5,"rate":5,"created":"2019-03-20T12:56:05+0000","modified":"2019-03-20T12:56:05+0000","comment":"gftjgft","product_id":30,"user":{"id":5,"username":"admin"}},{"id":7,"user_id":5,"rate":5,"created":"2019-03-20T13:02:36+0000","modified":"2019-03-20T13:02:36+0000","comment":"gftjgft","product_id":30,"user":{"id":5,"username":"admin"}},{"id":8,"user_id":5,"rate":3.5,"created":"2019-03-20T13:18:50+0000","modified":"2019-03-20T13:18:50+0000","comment":"gamel gdn","product_id":30,"user":{"id":5,"username":"admin"}},{"id":9,"user_id":5,"rate":0,"created":"2019-03-20T13:18:53+0000","modified":"2019-03-20T13:18:53+0000","comment":"تلب","product_id":30,"user":{"id":5,"username":"admin"}},{"id":10,"user_id":5,"rate":2.5,"created":"2019-03-20T13:19:19+0000","modified":"2019-03-20T13:19:19+0000","comment":"التقييم جيد جدا ","product_id":30,"user":{"id":5,"username":"admin"}},{"id":11,"user_id":5,"rate":3,"created":"2019-03-20T13:23:17+0000","modified":"2019-03-20T13:23:17+0000","comment":"المنتج جيد جدا ","product_id":30,"user":{"id":5,"username":"admin"}}]
         * total_rating : [{"product_id":30,"stars":25,"count":8}]
         */

        private int id;
        private String name;
        private String name_en;
        private List<ProductratesBean> productrates;
        private List<TotalRatingBean> total_rating;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public List<ProductratesBean> getProductrates() {
            return productrates;
        }

        public void setProductrates(List<ProductratesBean> productrates) {
            this.productrates = productrates;
        }

        public List<TotalRatingBean> getTotal_rating() {
            return total_rating;
        }

        public void setTotal_rating(List<TotalRatingBean> total_rating) {
            this.total_rating = total_rating;
        }

        public static class ProductratesBean {
            /**
             * id : 4
             * user_id : 5
             * rate : 3
             * created : 2019-03-20T11:45:26+0000
             * modified : 2019-03-20T11:45:26+0000
             * comment : gamel gdn
             * product_id : 30
             * user : {"id":5,"username":"admin"}
             */

            private int id;
            private int user_id;
            private float rate;
            private String created;
            private String modified;
            private String comment;
            private int product_id;
            private UserBean user;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public float getRate() {
                return rate;
            }

            public void setRate(int rate) {
                this.rate = rate;
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

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
                /**
                 * id : 5
                 * username : admin
                 */

                private int id;
                private String username;

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
            }
        }

        public static class TotalRatingBean {
            /**
             * product_id : 30
             * stars : 25
             * count : 8
             */

            private int product_id;
            private int stars;
            private int count;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getStars() {
                return stars;
            }

            public void setStars(int stars) {
                this.stars = stars;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}

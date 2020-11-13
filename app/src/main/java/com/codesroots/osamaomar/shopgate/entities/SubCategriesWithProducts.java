package com.codesroots.osamaomar.shopgate.entities;
import java.util.List;

public class SubCategriesWithProducts {


    private List<DataBean> data;
    private List<ProductsbyrateBean> productsbyrate;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<ProductsbyrateBean> getProductsbyrate() {
        return productsbyrate;
    }

    public void setProductsbyrate(List<ProductsbyrateBean> productsbyrate) {
        this.productsbyrate = productsbyrate;
    }

    public static class DataBean {
        /**
         * id : 3
         * name : بلزمة
         * name_en : food
         * photo : http://shopgate.codesroots.com/library/attachment/slider3.jpg
         */

        private int id;
        private String name;
        private String name_en;
        private String photo;

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

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }

    public static class ProductsbyrateBean {
        /**
         * total_result : 4
         * id : 3
         * start_price : 1
         * product_id : 31
         * size : 100
         * created : 2019-02-19T07:04:34+0000
         * modified : 2019-02-19T07:04:34+0000
         * current_price : 1
         * amount : 1
         * orderdetails : [{"productsize_id":3,"order_id":2,"count":4}]
         * product : {"id":31,"name":"zzzz","name_en":"salt","cat_id":2,"subcat_id":2,"color_hex":"#408080","created":"2019-02-19T08:20:47+0000","modified":"2019-02-19T08:20:47+0000","description":"axa","description_en":"xaxa","red":"64","green":"128","blue":"128","visible":null,"favourites":[{"id":73,"product_id":31,"user_id":2}],"total_rating":[{"product_id":31,"stars":5,"count":2}],"productphotos":[{"product_id":31,"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg"}]}
         */

        private int total_result;
        private int id;
        private String start_price;
        private int product_id;
        private String size;
        private String img;

        private String created;
        private String modified;
        private String current_price;
        private int amount;
        private ProductBean product;
        private List<OrderdetailsBean> orderdetails;


        public int getTotal_result() {
            return total_result;
        }

        public void setTotal_result(int total_result) {
            this.total_result = total_result;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStart_price() {
            return start_price;
        }

        public void setStart_price(String start_price) {
            this.start_price = start_price;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
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

        public String getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(String current_price) {
            this.current_price = current_price;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public List<OrderdetailsBean> getOrderdetails() {
            return orderdetails;
        }

        public void setOrderdetails(List<OrderdetailsBean> orderdetails) {
            this.orderdetails = orderdetails;
        }

        public static class ProductBean {
            /**
             * id : 31
             * name : zzzz
             * name_en : salt
             * cat_id : 2
             * subcat_id : 2
             * color_hex : #408080
             * created : 2019-02-19T08:20:47+0000
             * modified : 2019-02-19T08:20:47+0000
             * description : axa
             * description_en : xaxa
             * red : 64
             * green : 128
             * blue : 128
             * visible : null
             * favourites : [{"id":73,"product_id":31,"user_id":2}]
             * total_rating : [{"product_id":31,"stars":5,"count":2}]
             * productphotos : [{"product_id":31,"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg"}]
             */

            private int id;
            private String name;
            private String name_en;
            private int cat_id;
            private int subcat_id;
            private String color_hex;
            private String created;
            private String modified;
            private String description;
            private String description_en;
            private String img;

            private String red;
            private String green;
            private String blue;
            private Object visible;
            private List<FavouritesBean> favourites;
            private List<TotalRatingBean> total_rating;
            private List<ProductphotosBean> productphotos;


            public void setImg(String img) {
                this.img = img;
            }

            public String getImg() {
                return img;
            }
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

            public int getCat_id() {
                return cat_id;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }

            public int getSubcat_id() {
                return subcat_id;
            }

            public void setSubcat_id(int subcat_id) {
                this.subcat_id = subcat_id;
            }

            public String getColor_hex() {
                return color_hex;
            }

            public void setColor_hex(String color_hex) {
                this.color_hex = color_hex;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDescription_en() {
                return description_en;
            }

            public void setDescription_en(String description_en) {
                this.description_en = description_en;
            }

            public String getRed() {
                return red;
            }

            public void setRed(String red) {
                this.red = red;
            }

            public String getGreen() {
                return green;
            }

            public void setGreen(String green) {
                this.green = green;
            }

            public String getBlue() {
                return blue;
            }

            public void setBlue(String blue) {
                this.blue = blue;
            }

            public Object getVisible() {
                return visible;
            }

            public void setVisible(Object visible) {
                this.visible = visible;
            }

            public List<FavouritesBean> getFavourites() {
                return favourites;
            }

            public void setFavourites(List<FavouritesBean> favourites) {
                this.favourites = favourites;
            }

            public List<TotalRatingBean> getTotal_rating() {
                return total_rating;
            }

            public void setTotal_rating(List<TotalRatingBean> total_rating) {
                this.total_rating = total_rating;
            }

            public List<ProductphotosBean> getProductphotos() {
                return productphotos;
            }

            public void setProductphotos(List<ProductphotosBean> productphotos) {
                this.productphotos = productphotos;
            }

            public static class FavouritesBean {
                public FavouritesBean(int id) {
                    this.id = id;
                }

                /**
                 * id : 73
                 * product_id : 31
                 * user_id : 2
                 */


                private int id;
                private int product_id;
                private int user_id;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }
            }

            public static class TotalRatingBean {
                /**
                 * product_id : 31
                 * stars : 5
                 * count : 2
                 */

                private int product_id;
                private float stars;
                private int count;

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public float getStars() {
                    return stars;
                }

                public void setStars(float stars) {
                    this.stars = stars;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class ProductphotosBean {
                /**
                 * product_id : 31
                 * id : 20
                 * photo : http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg
                 */

                private int product_id;
                private int id;
                private String photo;

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
            }
        }

        public static class OrderdetailsBean {
            /**
             * productsize_id : 3
             * order_id : 2
             * count : 4
             */

            private int productsize_id;
            private int order_id;
            private int count;

            public int getProductsize_id() {
                return productsize_id;
            }

            public void setProductsize_id(int productsize_id) {
                this.productsize_id = productsize_id;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
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

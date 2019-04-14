package com.example.osamaomar.shopgate.entities;

import java.util.List;

public class MainView {

    private List<SlidersBean> sliders;
    private List<CategoryBean> category;
    private List<ProductsbyrateBean> productsbyrate;
    private List<SubcatsBeanX> subcats;
    private CurrencyBean currency;

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public List<SlidersBean> getSliders() {
        return sliders;
    }

    public void setSliders(List<SlidersBean> sliders) {
        this.sliders = sliders;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public List<ProductsbyrateBean> getProductsbyrate() {
        return productsbyrate;
    }

    public void setProductsbyrate(List<ProductsbyrateBean> productsbyrate) {
        this.productsbyrate = productsbyrate;
    }

    public List<SubcatsBeanX> getSubcats() {
        return subcats;
    }

    public void setSubcats(List<SubcatsBeanX> subcats) {
        this.subcats = subcats;
    }

    public static class CurrencyBean {
        /**
         * id : 1
         * name : dollar
         * value : 18
         * basic_value : 1
         * name_ar : دولار
         */

        private int id;
        private String name;
        private int value;
        private int basic_value;
        private String name_ar;

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

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getBasic_value() {
            return basic_value;
        }

        public void setBasic_value(int basic_value) {
            this.basic_value = basic_value;
        }

        public String getName_ar() {
            return name_ar;
        }

        public void setName_ar(String name_ar) {
            this.name_ar = name_ar;
        }
    }

    public static class SlidersBean {
        /**
         * photo : http://shopgate.codesroots.com/library/attachment/1545749814_Perfumes-ar.jpg
         */

        private String photo;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }

    public static class CategoryBean {
        /**
         * id : 2
         * name : العنايةبالشعر
         * name_en : hair care
         * photo : http://shopgate.codesroots.com/library/attachment/categori1.png
         * subcats : [{"id":1,"name":"كيرلي","name_en":"food","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/subcat8.png","icon":"http://shopgate.codesroots.com/library/attachment/seshwar.jpg"},{"id":2,"name":"ليز","name_en":"food","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/cat2.png","icon":"http://shopgate.codesroots.com/library/attachment/seshwar.jpg"}]
         */

        private int id;
        private String name;
        private String name_en;
        private String photo;
        private List<SubcatsBean> subcats;

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

        public List<SubcatsBean> getSubcats() {
            return subcats;
        }

        public void setSubcats(List<SubcatsBean> subcats) {
            this.subcats = subcats;
        }

        public static class SubcatsBean {
            /**
             * id : 1
             * name : كيرلي
             * name_en : food
             * category_id : 2
             * photo : http://shopgate.codesroots.com/library/attachment/subcat8.png
             * icon : http://shopgate.codesroots.com/library/attachment/seshwar.jpg
             */

            private int id;
            private String name;
            private String name_en;
            private int category_id;
            private String photo;
            private String icon;

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

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }

    public static class ProductsbyrateBean {
        /**
         * total_result : 4
         * id : 3
         * start_price : 300
         * product_id : 31
         * size : 100
         * created : 2019-02-19T07:04:34+0000
         * modified : 2019-02-19T07:04:34+0000
         * current_price : 1
         * amount : 1
         * orderdetails : [{"productsize_id":3,"order_id":1,"count":4}]
         * product : {"id":31,"name":"zzzz","name_en":"salt","cat_id":2,"subcat_id":2,"color_hex":"#408080","created":"2019-02-19T08:20:47+0000","modified":"2019-02-19T08:20:47+0000","description":"axa","description_en":"xaxa","red":"64","green":"128","blue":"128","visible":null,"total_rating":[{"product_id":31,"stars":38.5,"count":14}],"productphotos":[{"product_id":31,"id":3,"photo":"http://shopgate.codesroots.com/library/attachment/pd3.jpg"},{"product_id":31,"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/pd20.jpg"}]}
         */

        private int total_result;
        private int id;
        private String start_price;
        private int product_id;
        private String size;
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
             * total_rating : [{"product_id":31,"stars":38.5,"count":14}]
             * productphotos : [{"product_id":31,"id":3,"photo":"http://shopgate.codesroots.com/library/attachment/pd3.jpg"},{"product_id":31,"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/pd20.jpg"}]
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
            private String red;
            private String green;
            private String blue;
            private Object visible;
            private List<TotalRatingBean> total_rating;
            private List<ProductphotosBean> productphotos;

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

            public static class TotalRatingBean {
                /**
                 * product_id : 31
                 * stars : 38.5
                 * count : 14
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
                 * id : 3
                 * photo : http://shopgate.codesroots.com/library/attachment/pd3.jpg
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
             * order_id : 1
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

    public static class SubcatsBeanX {
        /**
         * id : 6
         * name : تبيض
         * name_en : ؤسؤس
         * category_id : 4
         * photo : http://shopgate.codesroots.com/library/attachment/subcat6.jpg
         * created : 2019-02-21T07:20:49+0000
         * modified : 2019-02-21T07:20:49+0000
         * icon : http://shopgate.codesroots.com/library/attachment/seshwar.jpg
         */

        private int id;
        private String name;
        private String name_en;
        private int category_id;
        private String photo;
        private String created;
        private String modified;
        private String icon;

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

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}

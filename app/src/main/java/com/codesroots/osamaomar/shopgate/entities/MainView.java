package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class MainView {


    private CurrencyBean currency;
    private List<SlidersBean> sliders;
    private List<CategoryBean> category;
    private  List<Newdata> newdata;
    private List<Productsbysales> productsbysales;
    private List<RandproductsBean> offernew;

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

    public List<Newdata> getProductsbyrate() {
        return newdata;
    }

    public void setProductsbyrate(List<Newdata> productsbyrate) {
        this.newdata = productsbyrate;
    }

    public List<RandproductsBean> getRandproducts() {
        return offernew;
    }

    public void setRandproducts(List<RandproductsBean> randproducts) {
        this.offernew = randproducts;
    }

    public List<Productsbysales> getProductsbysales() {
        return productsbysales;
    }

    public void setProductsbysales(List<Productsbysales> productsbysales) {
        this.productsbysales = productsbysales;
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
        private float value;
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

        public float getValue() {
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
         * photo : http://shopgate.codesroots.com/library/attachment/1545749814.jpg
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

        private int id;
        private String name;
        private String name_en;
        private String created;
        private String photo;
        private String modified;
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

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public List<SubcatsBean> getSubcats() {
            return subcats;
        }

        public void setSubcats(List<SubcatsBean> subcats) {
            this.subcats = subcats;
        }

        public static class SubcatsBean {
            /**
             * name : الأقنعة وتنظيف الوجه
             * category_id : 22
             * id : 11
             * photo : http://shopgate.codesroots.com/library/attachment/15567450491791302463.jpg
             */

            private String name;
            private int category_id;
            private int id;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
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

    public static class Newdata {

        private int id;
        private String name_en;
        private String name;
        private String description;
        private String img;

        private MatchingDataBean _matchingData;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_en() {
            return name_en;
        }

        public void setTotal_result(String total_result) {
            this.name_en = total_result;
        }

        public String getName() {
            return name;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getImg() {
            return img;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public MatchingDataBean get_matchingData() {
            return _matchingData;
        }

        public void set_matchingData(MatchingDataBean _matchingData) {
            this._matchingData = _matchingData;
        }





        public static class MatchingDataBean {
            /**
             * Productsizes : {"start_price":15}
             */

            private ProductsizesBean Productsizes;

            public ProductsizesBean getProductsizes() {
                return Productsizes;
            }

            public void setProductsizes(ProductsizesBean Productsizes) {
                this.Productsizes = Productsizes;
            }

            public static class ProductsizesBean {
                /**
                 * start_price : 15
                 */

                private int start_price;

                public int getStart_price() {
                    return start_price;
                }

                public void setStart_price(int start_price) {
                    this.start_price = start_price;
                }
            }
        }




    }

    public static class RandproductsBean {
        /**
         * id : 18
         * name : منتج تبييض الأسنان
         * description : منتج تبييض الأسنان
         * total_rating : [{"product_id":18,"stars":5,"count":1}]
         * productphotos : [{"id":59,"photo":"http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg","main":"","created":"2019-05-01T17:35:53+0000","modified":"2019-05-01T17:35:53+0000","product_id":18}]
         * productsizes : [{"id":126,"product_id":18,"size":"1","created":"2019-05-01T17:36:04+0000","modified":"2019-05-01T17:36:04+0000","current_price":15,"start_price":15,"amount":20}]
         */

        private int id;
        private String name;
        private String description;
        private String img;
        private List<TotalRatingBeanX> total_rating;
        private List<ProductphotosBeanX> productphotos;
        private List<ProductsizesBeanX> productsizes;
        private ProductBean product;

        public int getId() {
            return id;
        }
        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
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

        public void setImg(String img) {
            this.img = img;
        }

        public String getImg() {
            return img;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<TotalRatingBeanX> getTotal_rating() {
            return total_rating;
        }

        public void setTotal_rating(List<TotalRatingBeanX> total_rating) {
            this.total_rating = total_rating;
        }

        public List<ProductphotosBeanX> getProductphotos() {
            return productphotos;
        }

        public void setProductphotos(List<ProductphotosBeanX> productphotos) {
            this.productphotos = productphotos;
        }

        public List<ProductsizesBeanX> getProductsizes() {
            return productsizes;
        }

        public void setProductsizes(List<ProductsizesBeanX> productsizes) {
            this.productsizes = productsizes;
        }

        public static class TotalRatingBeanX {
            /**
             * product_id : 18
             * stars : 5
             * count : 1
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

        public static class ProductphotosBeanX {
            /**
             * id : 59
             * photo : http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg
             * main :
             * created : 2019-05-01T17:35:53+0000
             * modified : 2019-05-01T17:35:53+0000
             * product_id : 18
             */

            private int id;
            private String photo;
            private String main;
            private String created;
            private String modified;
            private int product_id;

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

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
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

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }
        }

        public static class ProductsizesBeanX {
            /**
             * id : 126
             * product_id : 18
             * size : 1
             * created : 2019-05-01T17:36:04+0000
             * modified : 2019-05-01T17:36:04+0000
             * current_price : 15
             * start_price : 15
             * amount : 20
             */

            private int id;
            private int product_id;
            private String size;
            private String created;
            private String modified;
            private double current_price;
            private int start_price;
            private int amount;

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

            public double getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(double current_price) {
                this.current_price = current_price;
            }

            public int getStart_price() {
                return start_price;
            }

            public void setStart_price(int start_price) {
                this.start_price = start_price;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }
        }

        public static class ProductBean {
            /**
             * id : 24
             * name : كريم الكولاجين
             * name_en : Collagen Cream
             * cat_id : 22
             * subcat_id : 13
             * created : 2019-05-01T17:48:15+0000
             * modified : 2019-05-01T17:48:15+0000
             * description : كريم الكولاجين
             * description_en : Collagen Cream
             * red : 0
             * green : 0
             * blue : 0
             * visible : 1
             * total_rating : [{"product_id":24,"stars":4,"count":1}]
             * productphotos : [{"product_id":24,"id":65,"photo":"http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg"}]
             * productsizes : [{"id":132,"product_id":24,"size":"114g","created":"2019-05-01T17:48:33+0000","modified":"2019-05-01T17:48:33+0000","current_price":7,"start_price":7,"amount":5}]
             */

            private int id;
            private String name;
            private String name_en;
            private  String img;
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





        }
    }

    public static class Productsbysales {
        /**
         * total_result : 6
         * id : 132
         * start_price : 7
         * product_id : 24
         * size : 114g
         * created : 2019-05-01T17:48:33+0000
         * modified : 2019-05-01T17:48:33+0000
         * current_price : 7
         * amount : 5
         * orderdetails : [{"productsize_id":132,"order_id":567,"count":6}]
         * product : {"id":24,"name":"كريم الكولاجين","name_en":"Collagen Cream","cat_id":22,"subcat_id":13,"created":"2019-05-01T17:48:15+0000","modified":"2019-05-01T17:48:15+0000","description":"كريم الكولاجين","description_en":"Collagen Cream","red":"0","green":"0","blue":"0","visible":"1","total_rating":[{"product_id":24,"stars":4,"count":1}],"productphotos":[{"product_id":24,"id":65,"photo":"http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg"}],"productsizes":[{"id":132,"product_id":24,"size":"114g","created":"2019-05-01T17:48:33+0000","modified":"2019-05-01T17:48:33+0000","current_price":7,"start_price":7,"amount":5}]}
         */

        private int total_result;
        private int id;
        private int start_price;
        private int product_id;
        private String size;
        private String created;
        private String modified;
        private double current_price;
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

        public int getStart_price() {
            return start_price;
        }

        public void setStart_price(int start_price) {
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

        public double getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(double current_price) {
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
             * id : 24
             * name : كريم الكولاجين
             * name_en : Collagen Cream
             * cat_id : 22
             * subcat_id : 13
             * created : 2019-05-01T17:48:15+0000
             * modified : 2019-05-01T17:48:15+0000
             * description : كريم الكولاجين
             * description_en : Collagen Cream
             * red : 0
             * green : 0
             * blue : 0
             * visible : 1
             * total_rating : [{"product_id":24,"stars":4,"count":1}]
             * productphotos : [{"product_id":24,"id":65,"photo":"http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg"}]
             * productsizes : [{"id":132,"product_id":24,"size":"114g","created":"2019-05-01T17:48:33+0000","modified":"2019-05-01T17:48:33+0000","current_price":7,"start_price":7,"amount":5}]
             */

            private int id;
            private String name;
            private String name_en;
            private int cat_id;
            private int subcat_id;
            private String created;
            private String modified;
            private String description;
            private String description_en;
            private String red;
            private String green;
            private String blue;
            private String visible;

            private List<TotalRatingBeanXX> total_rating;
            private List<ProductphotosBeanXX> productphotos;
            private List<ProductsizesBeanXX> productsizes;
            private  String img;
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

            public String getVisible() {
                return visible;
            }

            public void setVisible(String visible) {
                this.visible = visible;
            }

            public List<TotalRatingBeanXX> getTotal_rating() {
                return total_rating;
            }

            public void setTotal_rating(List<TotalRatingBeanXX> total_rating) {
                this.total_rating = total_rating;
            }

            public List<ProductphotosBeanXX> getProductphotos() {
                return productphotos;
            }

            public void setProductphotos(List<ProductphotosBeanXX> productphotos) {
                this.productphotos = productphotos;
            }

            public List<ProductsizesBeanXX> getProductsizes() {
                return productsizes;
            }

            public void setProductsizes(List<ProductsizesBeanXX> productsizes) {
                this.productsizes = productsizes;
            }

            public static class TotalRatingBeanXX {
                /**
                 * product_id : 24
                 * stars : 4
                 * count : 1
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

            public static class ProductphotosBeanXX {
                /**
                 * product_id : 24
                 * id : 65
                 * photo : http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg
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

            public static class ProductsizesBeanXX {
                /**
                 * id : 132
                 * product_id : 24
                 * size : 114g
                 * created : 2019-05-01T17:48:33+0000
                 * modified : 2019-05-01T17:48:33+0000
                 * current_price : 7
                 * start_price : 7
                 * amount : 5
                 */

                private int id;
                private int product_id;
                private String size;
                private String created;
                private String modified;
                private double current_price;
                private int start_price;
                private int amount;

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

                public double getCurrent_price() {
                    return current_price;
                }

                public void setCurrent_price(double current_price) {
                    this.current_price = current_price;
                }

                public int getStart_price() {
                    return start_price;
                }

                public void setStart_price(int start_price) {
                    this.start_price = start_price;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }
            }
        }

        public static class OrderdetailsBean {
            /**
             * productsize_id : 132
             * order_id : 567
             * count : 6
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

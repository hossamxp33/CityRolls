package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class Sidemenu {


    private List<CategoryBean> category;

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public static class CategoryBean {
        /**
         * id : 2
         * name : اكل
         * name_en : food
         * subcats : [{"id":1,"name":"hussen","name_en":"food","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/1550503543939991611.jpg"},{"id":2,"name":"تجارب للبرامجج","name_en":"food","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/15505038591890264978.jpg"},{"id":3,"name":"hussen","name_en":"food","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/15505746241167366907.jpg"},{"id":4,"name":"axas","name_en":"xasxas","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/1550581363177037925.jpg"},{"id":5,"name":"hussen","name_en":"food","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/15507514801343021850.jpg"},{"id":6,"name":"شسشس","name_en":"ؤسؤس","category_id":2,"photo":"http://shopgate.codesroots.com/library/attachment/15507516491359244236.jpg"}]
         */

        private int id;
        private String name;
        private String name_en;
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

        public List<SubcatsBean> getSubcats() {
            return subcats;
        }

        public void setSubcats(List<SubcatsBean> subcats) {
            this.subcats = subcats;
        }

        public static class SubcatsBean {
            /**
             * id : 1
             * name : hussen
             * name_en : food
             * category_id : 2
             * photo : http://shopgate.codesroots.com/library/attachment/1550503543939991611.jpg
             */

            private int id;
            private String name;
            private String name_en;
            private int category_id;
            private String photo;
            private String icon;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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
        }
    }
}

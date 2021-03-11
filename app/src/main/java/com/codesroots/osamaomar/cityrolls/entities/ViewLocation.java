package com.codesroots.osamaomar.cityrolls.entities;

public class ViewLocation {


    /**
     * success : true
     * data : {"billing_id":2,"customer_id":1,"first_name":"Rahimeen ","last_name":"Iftikhar","company_name":"ShapeGlobe","address":"Behind Khan Bar B. Q","town_city":"Hyderabad","state_country":"Pakistan","post_zip":"71000","email_address":"rahimeen.saleem@gmail.com","phone":"03163110068","status":0,"created_at":"2018-09-10T10:54:58+0000","updated_at":"2018-09-10T12:49:07+0000"}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * billing_id : 2
         * customer_id : 1
         * first_name : Rahimeen
         * last_name : Iftikhar
         * company_name : ShapeGlobe
         * address : Behind Khan Bar B. Q
         * town_city : Hyderabad
         * state_country : Pakistan
         * post_zip : 71000
         * email_address : rahimeen.saleem@gmail.com
         * phone : 03163110068
         * status : 0
         * created_at : 2018-09-10T10:54:58+0000
         * updated_at : 2018-09-10T12:49:07+0000
         */

        private int billing_id;
        private int customer_id;
        private String first_name;
        private String last_name;
        private String company_name;
        private String address;
        private String town_city;
        private String state_country;
        private String post_zip;
        private String email_address;
        private String phone;
        private int status;
        private String created_at;
        private String updated_at;
        private String notes;

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public int getBilling_id() {
            return billing_id;
        }

        public void setBilling_id(int billing_id) {
            this.billing_id = billing_id;
        }

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTown_city() {
            return town_city;
        }

        public void setTown_city(String town_city) {
            this.town_city = town_city;
        }

        public String getState_country() {
            return state_country;
        }

        public void setState_country(String state_country) {
            this.state_country = state_country;
        }

        public String getPost_zip() {
            return post_zip;
        }

        public void setPost_zip(String post_zip) {
            this.post_zip = post_zip;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}

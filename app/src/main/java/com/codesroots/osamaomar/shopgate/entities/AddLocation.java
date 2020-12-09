package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class AddLocation {

    /**
     * success : true
     * data : []
     */

    private boolean success;
    private List<?> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}

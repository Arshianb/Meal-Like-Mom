package com.yj.app.MainPage.networking;

import com.google.gson.annotations.SerializedName;

public class ServerResponseForImageUpload {
    // variable name should be same as in the json response from php
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("image_link")
    String image_link;

    public String getImage_link() {
        return image_link;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

}

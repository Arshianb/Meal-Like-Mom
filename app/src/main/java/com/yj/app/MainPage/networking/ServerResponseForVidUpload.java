package com.yj.app.MainPage.networking;

import com.google.gson.annotations.SerializedName;

public class ServerResponseForVidUpload {
    // variable name should be same as in the json response from php
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    @SerializedName("vid_link")
    String vid_link;

    public String getVideo_link() {
        return vid_link;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

}

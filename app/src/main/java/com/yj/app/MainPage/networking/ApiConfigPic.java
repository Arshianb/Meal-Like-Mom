package com.yj.app.MainPage.networking;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface ApiConfigPic {
    @Multipart
    @POST("CronetMainForPics.php")
    Call<ServerResponseForImageUpload> upload(
            @Header("Authorization") String authorization,
            @PartMap Map<String, RequestBody> map
    );

}

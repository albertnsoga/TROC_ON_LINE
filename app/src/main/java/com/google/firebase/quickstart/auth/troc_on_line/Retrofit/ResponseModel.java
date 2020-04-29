package com.google.firebase.quickstart.auth.troc_on_line.Retrofit;

import com.google.firebase.quickstart.auth.troc_on_line.Model.Troc;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("result")
    private List<Troc> trocs;
    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;
    public String getCode() {
        return code;
    }
}

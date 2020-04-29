package com.google.firebase.quickstart.auth.troc_on_line.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 *
 *let's create an interface here for retrofit
 */
public interface RestApi {

    /**
     *
     *this method will allow us perform a httpget request tothe specidied url
     * the respond will be a response model object
     */

    @GET("index.php")
    Call<ResponseModel> retrieve();

    /**
     *
     *this method will allow us perform a http get request tothe specidied url
     * the respond will be a response model object
     */

    @FormUrlEncoded
    @POST("index.php")
    Call<ResponseModel> insertData(@Field("action") String action,
                                   @Field("name") String name,
                                   @Field("description") String description,
                                    @Field("dob") String dob,
                                    @Field( "dot")String dot);
    /**
     *
     *this method will allow update a http get request tothe specidied url
     * the respond will be a response model object
     */
    @FormUrlEncoded
    @POST("index.php")
    Call<ResponseModel> updateData (@Field("action") String action,
                                   @Field("name") String name,
                                   @Field("description") String description,
                                   @Field("dob") String dob,
                                   @Field( "dot")String dot);
/**
 *
 *this method will allow delete a http get request tothe specidied url
 * the respond will be a response model object
 */
@FormUrlEncoded
@POST("index.php")
Call<ResponseModel> remove(@Field("action") String action,
                           @Field("id") String id);

/**
 *
 *this method will allow search and pagination a http get request tothe specidied url
 * the respond will be a response model object
 */

@FormUrlEncoded
@POST("index.php")
Call<ResponseModel> search(@Field("action") String action,
                           @Field("query") String query,
                           @Field("start") String start,
                           @Field("limit") String limit);

}

package com.abtingramian.service.data.api;

public interface ExampleApi {
    /*
    @GET("form/")
    Call<CharactersResponse> getCharacters(@Query("page") Integer page);

    @GET("form/{id}")
    Call<Character> getCharacter(@Path("id") Integer id);

    @GET("episode/")
    Call<EpisodesResponse> getEpisodes(@Query("page") Integer page);

    @GET("episode/{id}")
    Call<Episode> getEpisode(@Path("id") Integer id);

    @POST("multipart")
    @Multipart
    Call<Void> multipart(@Header("Authorization") final String credentials,
                         @Part("from") final String from,
                         @Part("to") final String to,
                         @Part("subject") final String subject,
                         @Part("text") final String messagePlainText,
                         @Part("html") final String messageHtml,
                         @Part("o:testmode") final Boolean testMode);

    @POST("form/{id}")
    Call<User> createUser(@Body User payload);

    @GET("form")
    Call<User> getUser(@Query("limit") Integer limit);

    @PUT("form/{id}")
    Call<User> updateUser(@Path("id") String id, @Body User payload);

    @DELETE("form/{id}")
    Call<ResponseBody> deleteUser(@Path("id") String id);

    @PATCH("form/{id}")
    Call<User> updateUser(@Path("id") UUID id, @Body User payload);

    public Single<ResponseBody> attachReceiptSingle(@NonNull final String expenseId, @NonNull final File file, @NonNull final String mimeType) {
        return taxApi.attachReceipt(expenseId, RequestBody.create(MediaType.parse(mimeType), file)).firstOrError();
    }

    @PUT("tax/expenses/{id}/receipt")
    Observable<ResponseBody> attachReceipt(@Path("id") String id, @Body RequestBody file);
    */

}

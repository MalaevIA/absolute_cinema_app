package com.example.absolute_cinema_app.domain.RegisterRetrfit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/RegisterAPI;", "", "Login", "Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/User;", "userRequest", "Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/UserRequest;", "(Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Register", "addToFavorites", "Lretrofit2/Response;", "Ljava/lang/Void;", "token", "", "request", "Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/FavoriteRequest;", "(Ljava/lang/String;Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/FavoriteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/FavoriteResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "", "(Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/FavoriteRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface RegisterAPI {
    
    @retrofit2.http.POST(value = "/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object Login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.RegisterRetrfit.UserRequest userRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.domain.RegisterRetrfit.User> $completion);
    
    @retrofit2.http.POST(value = "/register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object Register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.RegisterRetrfit.UserRequest userRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.domain.RegisterRetrfit.User> $completion);
    
    @retrofit2.http.POST(value = "/favorites/add")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addToFavorites(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.RegisterRetrfit.FavoriteRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.Void>> $completion);
    
    @retrofit2.http.GET(value = "/favorites")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFavorites(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.absolute_cinema_app.domain.RegisterRetrfit.FavoriteResponse>> $completion);
    
    @retrofit2.http.HTTP(method = "DELETE", path = "/favorites/remove", hasBody = true)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeFromFavorites(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.RegisterRetrfit.FavoriteRequest request, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}
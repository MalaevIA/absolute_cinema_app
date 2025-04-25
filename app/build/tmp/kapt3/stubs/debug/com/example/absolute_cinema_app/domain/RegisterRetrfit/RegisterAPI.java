package com.example.absolute_cinema_app.domain.RegisterRetrfit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/RegisterAPI;", "", "Login", "Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/User;", "userRequest", "Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/UserRequest;", "(Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Register", "app_debug"})
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
}
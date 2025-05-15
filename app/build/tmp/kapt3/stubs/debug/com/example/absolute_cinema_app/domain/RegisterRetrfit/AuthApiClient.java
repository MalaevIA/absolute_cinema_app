package com.example.absolute_cinema_app.domain.RegisterRetrfit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/AuthApiClient;", "", "()V", "BASE_URL", "", "authApi", "Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/RegisterAPI;", "getAuthApi", "()Lcom/example/absolute_cinema_app/domain/RegisterRetrfit/RegisterAPI;", "authApi$delegate", "Lkotlin/Lazy;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "interceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "getInterceptor", "()Lokhttp3/logging/HttpLoggingInterceptor;", "interceptor$delegate", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "app_debug"})
public final class AuthApiClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "http://158.160.173.175:8080/";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy interceptor$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy client$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy retrofit$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy authApi$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.absolute_cinema_app.domain.RegisterRetrfit.AuthApiClient INSTANCE = null;
    
    private AuthApiClient() {
        super();
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor getInterceptor() {
        return null;
    }
    
    private final okhttp3.OkHttpClient getClient() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.absolute_cinema_app.domain.RegisterRetrfit.RegisterAPI getAuthApi() {
        return null;
    }
}
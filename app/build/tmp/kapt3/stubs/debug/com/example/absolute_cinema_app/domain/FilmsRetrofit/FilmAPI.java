package com.example.absolute_cinema_app.domain.FilmsRetrofit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\"\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u001b\u001a\u00020\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001f"}, d2 = {"Lcom/example/absolute_cinema_app/domain/FilmsRetrofit/FilmAPI;", "", "getAwardsToFilmById", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilmById", "Lcom/example/absolute_cinema_app/data/models/filmsModels/Film;", "getFilmsByGenre", "Lcom/example/absolute_cinema_app/data/models/filmsModels/FilmResponseForGenre;", "genreId", "getFilmsByKeyword", "Lcom/example/absolute_cinema_app/data/models/filmsModels/FilmResponseForSearch;", "keyword", "", "page", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPremieres", "Lcom/example/absolute_cinema_app/data/models/filmsModels/PremiereResponse;", "year", "month", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviewsToFilmById", "Lcom/example/absolute_cinema_app/data/models/filmsModels/ResponseForReviews;", "getSimilarsFilmsById", "Lcom/example/absolute_cinema_app/data/models/filmsModels/FilmResponseForSimilars;", "getTopPopularFilms", "Lcom/example/absolute_cinema_app/data/models/filmsModels/FilmCollectionResponse;", "type", "getVideoForFilmById", "app_debug"})
public abstract interface FilmAPI {
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFilmById(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.Film> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFilmsByGenre(@retrofit2.http.Query(value = "genres")
    int genreId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.FilmResponseForGenre> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.1/films/search-by-keyword")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFilmsByKeyword(@retrofit2.http.Query(value = "keyword")
    @org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.FilmResponseForSearch> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films/{id}/similars")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSimilarsFilmsById(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.FilmResponseForSimilars> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films/{id}/videos")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVideoForFilmById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films/{id}/reviews")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getReviewsToFilmById(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.ResponseForReviews> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films/{id}/awards")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAwardsToFilmById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films/collections")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopPopularFilms(@retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.NotNull()
    java.lang.String type, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.FilmCollectionResponse> $completion);
    
    @retrofit2.http.Headers(value = {"X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a"})
    @retrofit2.http.GET(value = "api/v2.2/films/premieres")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPremieres(@retrofit2.http.Query(value = "year")
    int year, @retrofit2.http.Query(value = "month")
    @org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.PremiereResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}
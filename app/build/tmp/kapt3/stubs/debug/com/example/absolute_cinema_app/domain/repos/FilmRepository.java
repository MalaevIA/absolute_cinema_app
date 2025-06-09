package com.example.absolute_cinema_app.domain.repos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/absolute_cinema_app/domain/repos/FilmRepository;", "", "api", "Lcom/example/absolute_cinema_app/domain/FilmsRetrofit/FilmAPI;", "(Lcom/example/absolute_cinema_app/domain/FilmsRetrofit/FilmAPI;)V", "getFilm", "Lcom/example/absolute_cinema_app/data/models/filmsModels/Film;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviews", "", "Lcom/example/absolute_cinema_app/data/models/filmsModels/Review;", "filmId", "getSimilarFilms", "Lcom/example/absolute_cinema_app/data/models/filmsModels/FilmForSimilars;", "getVideos", "Lcom/example/absolute_cinema_app/data/models/filmsModels/VideoItem;", "app_debug"})
public final class FilmRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI api = null;
    
    public FilmRepository(@org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI api) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getReviews(int filmId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Review>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSimilarFilms(int filmId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.FilmForSimilars>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFilm(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.absolute_cinema_app.data.models.filmsModels.Film> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVideos(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.VideoItem>> $completion) {
        return null;
    }
}
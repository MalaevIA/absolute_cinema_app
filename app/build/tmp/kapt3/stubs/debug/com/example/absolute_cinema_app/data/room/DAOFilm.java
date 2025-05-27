package com.example.absolute_cinema_app.data.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/absolute_cinema_app/data/room/DAOFilm;", "", "deleteFilm", "", "filmEntity", "Lcom/example/absolute_cinema_app/data/room/FilmEntity;", "(Lcom/example/absolute_cinema_app/data/room/FilmEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFilms", "Lkotlinx/coroutines/flow/Flow;", "", "insertFilm", "app_debug"})
@androidx.room.Dao()
public abstract interface DAOFilm {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertFilm(@org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.data.room.FilmEntity filmEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteFilm(@org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.data.room.FilmEntity filmEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM ContinueFilms ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.absolute_cinema_app.data.room.FilmEntity>> getAllFilms();
}
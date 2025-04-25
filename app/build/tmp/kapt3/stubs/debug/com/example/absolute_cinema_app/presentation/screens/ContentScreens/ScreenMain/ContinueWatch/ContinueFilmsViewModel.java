package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ContinueWatch;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/absolute_cinema_app/presentation/screens/ContentScreens/ScreenMain/ContinueWatch/ContinueFilmsViewModel;", "Landroidx/lifecycle/ViewModel;", "database", "Lcom/example/absolute_cinema_app/domain/room/ContinueFilmsDB;", "(Lcom/example/absolute_cinema_app/domain/room/ContinueFilmsDB;)V", "getDatabase", "()Lcom/example/absolute_cinema_app/domain/room/ContinueFilmsDB;", "filmList", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/absolute_cinema_app/domain/room/FilmEntity;", "getFilmList", "()Lkotlinx/coroutines/flow/Flow;", "insertFilm", "Lkotlinx/coroutines/Job;", "id", "", "poster", "", "genre", "label", "Companion", "app_debug"})
public final class ContinueFilmsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.absolute_cinema_app.domain.room.ContinueFilmsDB database = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.absolute_cinema_app.domain.room.FilmEntity>> filmList = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.lifecycle.ViewModelProvider.Factory factory = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ContinueWatch.ContinueFilmsViewModel.Companion Companion = null;
    
    public ContinueFilmsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.room.ContinueFilmsDB database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.absolute_cinema_app.domain.room.ContinueFilmsDB getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.absolute_cinema_app.domain.room.FilmEntity>> getFilmList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertFilm(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String poster, @org.jetbrains.annotations.Nullable()
    java.lang.String genre, @org.jetbrains.annotations.Nullable()
    java.lang.String label) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/absolute_cinema_app/presentation/screens/ContentScreens/ScreenMain/ContinueWatch/ContinueFilmsViewModel$Companion;", "", "()V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory$annotations", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.ViewModelProvider.Factory getFactory() {
            return null;
        }
        
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @java.lang.Deprecated()
        public static void getFactory$annotations() {
        }
    }
}
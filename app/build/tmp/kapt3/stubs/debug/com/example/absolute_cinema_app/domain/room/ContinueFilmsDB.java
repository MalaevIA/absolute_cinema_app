package com.example.absolute_cinema_app.domain.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/absolute_cinema_app/domain/room/ContinueFilmsDB;", "Landroidx/room/RoomDatabase;", "()V", "dao", "Lcom/example/absolute_cinema_app/domain/room/DAOFilm;", "getDao", "()Lcom/example/absolute_cinema_app/domain/room/DAOFilm;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.absolute_cinema_app.domain.room.FilmEntity.class}, version = 2)
public abstract class ContinueFilmsDB extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.absolute_cinema_app.domain.room.ContinueFilmsDB.Companion Companion = null;
    
    public ContinueFilmsDB() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.absolute_cinema_app.domain.room.DAOFilm getDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/absolute_cinema_app/domain/room/ContinueFilmsDB$Companion;", "", "()V", "CreateDB", "Lcom/example/absolute_cinema_app/domain/room/ContinueFilmsDB;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.absolute_cinema_app.domain.room.ContinueFilmsDB CreateDB(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}
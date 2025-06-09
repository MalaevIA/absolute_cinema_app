package com.example.absolute_cinema_app.domain.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/example/absolute_cinema_app/domain/viewModels/FilmViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/absolute_cinema_app/domain/repos/FilmRepository;", "(Lcom/example/absolute_cinema_app/domain/repos/FilmRepository;)V", "_film", "Landroidx/compose/runtime/MutableState;", "Lcom/example/absolute_cinema_app/data/models/filmsModels/Film;", "_videos", "", "Lcom/example/absolute_cinema_app/data/models/filmsModels/VideoItem;", "film", "Landroidx/compose/runtime/State;", "getFilm", "()Landroidx/compose/runtime/State;", "videos", "getVideos", "loadFilm", "", "id", "", "app_debug"})
public final class FilmViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.absolute_cinema_app.domain.repos.FilmRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<com.example.absolute_cinema_app.data.models.filmsModels.Film> _film = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.absolute_cinema_app.data.models.filmsModels.Film> film = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.VideoItem>> _videos = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.VideoItem>> videos = null;
    
    public FilmViewModel(@org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.repos.FilmRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.absolute_cinema_app.data.models.filmsModels.Film> getFilm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.VideoItem>> getVideos() {
        return null;
    }
    
    public final void loadFilm(int id) {
    }
}
package com.example.absolute_cinema_app.domain.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/example/absolute_cinema_app/domain/viewModels/ReviewViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/absolute_cinema_app/domain/repos/FilmRepository;", "(Lcom/example/absolute_cinema_app/domain/repos/FilmRepository;)V", "_reviews", "Landroidx/compose/runtime/MutableState;", "", "Lcom/example/absolute_cinema_app/data/models/filmsModels/Review;", "reviews", "Landroidx/compose/runtime/State;", "getReviews", "()Landroidx/compose/runtime/State;", "loadReviews", "", "filmId", "", "app_debug"})
public final class ReviewViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.absolute_cinema_app.domain.repos.FilmRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Review>> _reviews = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Review>> reviews = null;
    
    public ReviewViewModel(@org.jetbrains.annotations.NotNull()
    com.example.absolute_cinema_app.domain.repos.FilmRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Review>> getReviews() {
        return null;
    }
    
    public final void loadReviews(int filmId) {
    }
}
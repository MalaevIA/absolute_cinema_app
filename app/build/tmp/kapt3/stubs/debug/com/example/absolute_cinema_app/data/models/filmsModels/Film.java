package com.example.absolute_cinema_app.data.models.filmsModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bJ\b\u0087\b\u0018\u00002\u00020\u0001B\u00f3\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020\u0018\u00a2\u0006\u0002\u0010%J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u000eH\u00c6\u0003J\t\u0010I\u001a\u00020\u000eH\u00c6\u0003J\t\u0010J\u001a\u00020\u0005H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0005H\u00c6\u0003J\t\u0010M\u001a\u00020\u0005H\u00c6\u0003J\t\u0010N\u001a\u00020\u0005H\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0018H\u00c6\u0003J\t\u0010R\u001a\u00020\u0005H\u00c6\u0003J\t\u0010S\u001a\u00020\u0005H\u00c6\u0003J\t\u0010T\u001a\u00020\u0005H\u00c6\u0003J\t\u0010U\u001a\u00020\u0005H\u00c6\u0003J\t\u0010V\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0018H\u00c6\u0003J\t\u0010[\u001a\u00020\u0018H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0018H\u00c6\u0003J\t\u0010]\u001a\u00020\u0005H\u00c6\u0003J\t\u0010^\u001a\u00020\u0005H\u00c6\u0003J\t\u0010_\u001a\u00020\u0005H\u00c6\u0003J\t\u0010`\u001a\u00020\u0005H\u00c6\u0003J\t\u0010a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010c\u001a\u00020\u0003H\u00c6\u0003J\u00b1\u0002\u0010d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020\u0018H\u00c6\u0001J\u0013\u0010e\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010g\u001a\u00020\u0003H\u00d6\u0001J\t\u0010h\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010$\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010!\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0011\u0010\u001c\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0011\u0010\u001b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0011\u0010\"\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\'R\u0011\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010)R\u0011\u0010#\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\'R\u0011\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0011\u0010 \u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0011\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010)R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010)R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010-\u00a8\u0006i"}, d2 = {"Lcom/example/absolute_cinema_app/data/models/filmsModels/Film;", "", "kinopoiskId", "", "nameRu", "", "nameEn", "nameOriginal", "posterUrl", "posterUrlPreview", "coverUrl", "logoUrl", "reviewsCount", "ratingKinopoisk", "", "ratingImdb", "webUrl", "year", "filmLength", "slogan", "description", "shortDescription", "editorAnnotation", "isTicketsAvailable", "", "productionStatus", "type", "ratingMpaa", "ratingAgeLimits", "genres", "", "Lcom/example/absolute_cinema_app/data/models/filmsModels/Genre;", "startYear", "endYear", "serial", "shortFilm", "completed", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFFLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIZZZ)V", "getCompleted", "()Z", "getCoverUrl", "()Ljava/lang/String;", "getDescription", "getEditorAnnotation", "getEndYear", "()I", "getFilmLength", "getGenres", "()Ljava/util/List;", "getKinopoiskId", "getLogoUrl", "getNameEn", "getNameOriginal", "getNameRu", "getPosterUrl", "getPosterUrlPreview", "getProductionStatus", "getRatingAgeLimits", "getRatingImdb", "()F", "getRatingKinopoisk", "getRatingMpaa", "getReviewsCount", "getSerial", "getShortDescription", "getShortFilm", "getSlogan", "getStartYear", "getType", "getWebUrl", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Film {
    private final int kinopoiskId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nameRu = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nameEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nameOriginal = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String posterUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String posterUrlPreview = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String coverUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String logoUrl = null;
    private final int reviewsCount = 0;
    private final float ratingKinopoisk = 0.0F;
    private final float ratingImdb = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String webUrl = null;
    private final int year = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String filmLength = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String slogan = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String shortDescription = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String editorAnnotation = null;
    private final boolean isTicketsAvailable = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String productionStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ratingMpaa = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ratingAgeLimits = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Genre> genres = null;
    private final int startYear = 0;
    private final int endYear = 0;
    private final boolean serial = false;
    private final boolean shortFilm = false;
    private final boolean completed = false;
    
    public Film(int kinopoiskId, @org.jetbrains.annotations.NotNull()
    java.lang.String nameRu, @org.jetbrains.annotations.NotNull()
    java.lang.String nameEn, @org.jetbrains.annotations.NotNull()
    java.lang.String nameOriginal, @org.jetbrains.annotations.NotNull()
    java.lang.String posterUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String posterUrlPreview, @org.jetbrains.annotations.NotNull()
    java.lang.String coverUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String logoUrl, int reviewsCount, float ratingKinopoisk, float ratingImdb, @org.jetbrains.annotations.NotNull()
    java.lang.String webUrl, int year, @org.jetbrains.annotations.NotNull()
    java.lang.String filmLength, @org.jetbrains.annotations.NotNull()
    java.lang.String slogan, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String shortDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String editorAnnotation, boolean isTicketsAvailable, @org.jetbrains.annotations.NotNull()
    java.lang.String productionStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String ratingMpaa, @org.jetbrains.annotations.NotNull()
    java.lang.String ratingAgeLimits, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Genre> genres, int startYear, int endYear, boolean serial, boolean shortFilm, boolean completed) {
        super();
    }
    
    public final int getKinopoiskId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNameRu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNameEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNameOriginal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPosterUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPosterUrlPreview() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCoverUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLogoUrl() {
        return null;
    }
    
    public final int getReviewsCount() {
        return 0;
    }
    
    public final float getRatingKinopoisk() {
        return 0.0F;
    }
    
    public final float getRatingImdb() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWebUrl() {
        return null;
    }
    
    public final int getYear() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilmLength() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSlogan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShortDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEditorAnnotation() {
        return null;
    }
    
    public final boolean isTicketsAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProductionStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRatingMpaa() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRatingAgeLimits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Genre> getGenres() {
        return null;
    }
    
    public final int getStartYear() {
        return 0;
    }
    
    public final int getEndYear() {
        return 0;
    }
    
    public final boolean getSerial() {
        return false;
    }
    
    public final boolean getShortFilm() {
        return false;
    }
    
    public final boolean getCompleted() {
        return false;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final float component10() {
        return 0.0F;
    }
    
    public final float component11() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Genre> component24() {
        return null;
    }
    
    public final int component25() {
        return 0;
    }
    
    public final int component26() {
        return 0;
    }
    
    public final boolean component27() {
        return false;
    }
    
    public final boolean component28() {
        return false;
    }
    
    public final boolean component29() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.absolute_cinema_app.data.models.filmsModels.Film copy(int kinopoiskId, @org.jetbrains.annotations.NotNull()
    java.lang.String nameRu, @org.jetbrains.annotations.NotNull()
    java.lang.String nameEn, @org.jetbrains.annotations.NotNull()
    java.lang.String nameOriginal, @org.jetbrains.annotations.NotNull()
    java.lang.String posterUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String posterUrlPreview, @org.jetbrains.annotations.NotNull()
    java.lang.String coverUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String logoUrl, int reviewsCount, float ratingKinopoisk, float ratingImdb, @org.jetbrains.annotations.NotNull()
    java.lang.String webUrl, int year, @org.jetbrains.annotations.NotNull()
    java.lang.String filmLength, @org.jetbrains.annotations.NotNull()
    java.lang.String slogan, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String shortDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String editorAnnotation, boolean isTicketsAvailable, @org.jetbrains.annotations.NotNull()
    java.lang.String productionStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String ratingMpaa, @org.jetbrains.annotations.NotNull()
    java.lang.String ratingAgeLimits, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.absolute_cinema_app.data.models.filmsModels.Genre> genres, int startYear, int endYear, boolean serial, boolean shortFilm, boolean completed) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}
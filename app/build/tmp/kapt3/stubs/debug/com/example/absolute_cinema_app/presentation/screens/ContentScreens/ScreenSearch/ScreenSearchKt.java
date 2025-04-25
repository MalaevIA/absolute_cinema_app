package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenSearch;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a$\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"HISTORY_PREF", "", "KEY_HISTORY", "ScreenSearch", "", "navController", "Landroidx/navigation/NavController;", "getHistory", "", "prefs", "Landroid/content/SharedPreferences;", "gson", "Lcom/google/gson/Gson;", "saveHistory", "history", "app_debug"})
public final class ScreenSearchKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HISTORY_PREF = "exHistory";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_HISTORY = "History";
    
    @android.annotation.SuppressLint(value = {"NewApi"})
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ScreenSearch(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    public static final void saveHistory(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> history) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.String> getHistory(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
}
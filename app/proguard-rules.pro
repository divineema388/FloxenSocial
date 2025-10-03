# Add your ProGuard rules here

# Compose specific rules
-keep class androidx.compose.runtime.internal.ComposableLambdaImpl { *; }

# Firebase rules
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Kotlin specific rules
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**

# Material3 rules
-keep class androidx.compose.material3.** { *; }

# Navigation rules
-keep class androidx.navigation.** { *; }

# Keep data classes
-keepclassmembers class ** {
    @androidx.compose.runtime.ReadOnlyComposable <methods>;
}

# Keep ViewModels
-keep class * extends androidx.lifecycle.ViewModel { *; }

# Keep Composables
-keep @androidx.compose.runtime.Composable class * {
    @androidx.compose.runtime.Composable <methods>;
}
import java.util.Properties

plugins {
    id("com.android.application")
}

// Optionaler Release-Schlüssel: keystore.properties (nicht im Repository) mit
// storeFile, storePassword, keyAlias, keyPassword. Fehlt die Datei, wird mit dem Debug-Schlüssel signiert.
val keyProps = Properties().apply {
    val f = rootProject.file("keystore.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}

android {
    namespace = "de.fristenrechner.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "de.fristenrechner.app"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        if (!keyProps.isEmpty) {
            create("release") {
                storeFile = rootProject.file(keyProps.getProperty("storeFile"))
                storePassword = keyProps.getProperty("storePassword")
                keyAlias = keyProps.getProperty("keyAlias")
                keyPassword = keyProps.getProperty("keyPassword")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = if (!keyProps.isEmpty) signingConfigs.getByName("release") else signingConfigs.getByName("debug")
        }
    }

    // Die Web-Seite wird direkt aus ../fristenrechner übernommen (eine gemeinsame Quelle für Web und App).
    sourceSets {
        getByName("main") {
            assets.setSrcDirs(listOf("../../fristenrechner"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

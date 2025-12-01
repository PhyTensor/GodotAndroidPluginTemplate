plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

// TODO: Update value to your plugin's name.
val pluginName = "GodotAndroidPluginTemplate"

// TODO: Update value to match your plugin's package name.
val pluginPackageName = "org.godotengine.plugin.android.template"

android {
    namespace = "org.godotengine.plugin.android.template"
    compileSdk {
        version = release(36)
    }

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 24
//        targetSdk = 36

        manifestPlaceholders["godotPluginName"] = pluginName
        manifestPlaceholders["godotPluginPackageName"] = pluginPackageName
        buildConfigField("String", "GODOT_PLUGIN_NAME", "\"${pluginName}\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "pluginPackageName", "\"${pluginPackageName}\"")
            buildConfigField("String", "pluginName", "\"${pluginName}\"")
        }
        debug {
            buildConfigField("String", "pluginPackageName", "\"${pluginPackageName}\"")
            buildConfigField("String", "pluginName", "\"${pluginName}\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.godot)
}

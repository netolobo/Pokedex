plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.netoloboapps.pokedex"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.netoloboapps.pokedex"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")
    implementation ("androidx.compose.ui:ui:1.4.3")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation ("androidx.compose.material3:material3:1.1.1")
    implementation ("androidx.paging:paging-common-ktx:3.1.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.4.3")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.4.3")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.4.3")

    //Material icons extended
    implementation ("androidx.compose.material:material-icons-extended:1.4.3")
    implementation ("androidx.compose.material:material-icons-core:1.4.3")

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.45")
    kapt ("com.google.dagger:hilt-compiler:2.45")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("com.google.dagger:dagger:2.45")
    kapt ("com.google.dagger:dagger-compiler:2.45")

    //ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //Moshi
    implementation ("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    //Coil
    implementation ("io.coil-kt:coil-compose:2.2.2")
    //Navigation components
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    //Pallete
    implementation ("androidx.palette:palette:1.0.0")
}
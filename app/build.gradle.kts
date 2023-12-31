plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.courseworktwo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.courseworktwo"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    dependencies {
        // Room components
        implementation ("androidx.room:room-runtime:2.4.2")
        annotationProcessor ("androidx.room:room-compiler:2.4.2")
        // For Kotlin use kapt instead of annotationProcessor

        // Retrofit for network requests
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")


        // other necessary dependencies like lifecycle, etc.
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation ("com.github.bumptech.glide:glide:4.12.0") // Use the latest version available
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")


}
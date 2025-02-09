// Файл: build.gradle.kts (на уровне проекта)
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        val kotlinVersion = "1.8.10"
        classpath("com.android.tools.build:gradle:8.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

// Если в файле были блоки allprojects { repositories { ... } }, их можно удалить,
// чтобы избежать конфликтов, если вы используете dependencyResolutionManagement в settings.gradle.kts.


// Если есть блок allprojects { repositories { ... } } — удалите его


allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

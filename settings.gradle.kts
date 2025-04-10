pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CoursesApp"
include(":app")
include(":core")

include(":features:courses:domain")
include(":features:onboarding:domain")
include(":features:onboarding:ui")
include(":features:account2")
include(":features:authorization")
include(":features:favorites")
include(":features:home:ui")

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net") {
            name = "Fabric"
        }
        maven("https://server.bbkr.space/artifactory/libs-release/") {
            name = "Cotton"
        }
        gradlePluginPortal()
    }
}

rootProject.name = "TerraFabriCraft"


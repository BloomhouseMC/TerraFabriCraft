plugins {
    id("fabric-loom") version "0.10.27"
    id("maven-publish")
    id("io.github.juuxel.loom-quiltflower") version "1.3.0"
}

version = "${project.property("mod_version")}"
group = "${project.property("maven_group")}"

repositories {
    maven("https://ladysnake.jfrog.io/artifactory/mods") {
        name = "Cardinal Components"
    }
    maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/") {
        "GeckoLib"
    }
    maven("https://maven.shedaniel.me") {
        "Roughly Enough Items"
    }
    maven("https://maven.blamejared.com") {
        "Patchouli"
    }
    maven("https://jitpack.io") {
        "JitPack"
    }
    maven("https://server.bbkr.space/artifactory/libs-release") {
        name = "LibGui"
        content {
            includeGroup("io.github.cottonmc")
        }
    }
}

val modInclude: Configuration by configurations.creating
configurations {
    include.get().extendsFrom(modInclude)
    modImplementation.get().extendsFrom(modInclude)
}

dependencies {
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${project.property("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${project.property("loader_version")}")

    //Fabric API
    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_version")}")

    //CCA
    modApi("io.github.onyxstudios.Cardinal-Components-API:cardinal-components-base:${project.property("cc_version")}")
    include("io.github.onyxstudios.Cardinal-Components-API:cardinal-components-base:${project.property("cc_version")}")
    modInclude("io.github.onyxstudios.Cardinal-Components-API:cardinal-components-entity:${project.property("cc_version")}")
    modInclude("io.github.onyxstudios.Cardinal-Components-API:cardinal-components-world:${project.property("cc_version")}")
    modInclude("io.github.onyxstudios.Cardinal-Components-API:cardinal-components-item:${project.property("cc_version")}")

    //Geckolib
    modImplementation("software.bernie.geckolib:geckolib-fabric-${project.property("gecko_version")}")

    //Patchouli
    modImplementation("vazkii.patchouli:Patchouli:${project.property("patchouli_version")}")

    //REI
    modCompileOnly("me.shedaniel:RoughlyEnoughItems-api-fabric:${project.property("rei_version")}")
    modRuntimeOnly("me.shedaniel:RoughlyEnoughItems-fabric:${project.property("rei_version")}")

    include(modImplementation("io.github.cottonmc:LibGui:${project.property("libgui_version")}")!!)

    modApi("com.github.GiantLuigi4:ShaderUtil:4b79bb79b5")
    include("com.github.GiantLuigi4:ShaderUtil:4b79bb79b5")
}

loom {
    accessWidenerPath.set(file("src/main/resources/terrafabricraft.aw"))
}

val targetJavaVersion = 16

tasks {
    processResources {
        inputs.property("version", project.version)
        filteringCharset = "UTF-8"

        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        if (targetJavaVersion >= 10 || JavaVersion.current().isJava10Compatible()) {
            options.release.set(targetJavaVersion)
        };
    }

    java {
        val javaVersion = JavaVersion.toVersion(targetJavaVersion)
        if (JavaVersion.current() < javaVersion) {
            toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion))
        }
        base.archivesName.set("${project.property("archives_base_name")}")
        withSourcesJar()
    }

    jar {
        from("LICENSE") {
            rename {
                "${it}_${project.base.archivesName}"
            }
        }
    }
}

publishing {

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    publications {
        register("mavenJava", MavenPublication::class) {
            // add all the jars that should be included when publishing to maven
//            artifact(remapJar.get()) {
//                builtBy(remapJar)
//            }
//            artifact(sourcesJar.get()) {
//                builtBy(remapSourcesJar)
//            }
        }
    }
    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for
        // retrieving dependencies.
    }
}
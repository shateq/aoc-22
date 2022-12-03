include("common")
setOf("1", "2", "3").forEach {
    include("day-$it")
}
rootProject.name = "aoc2022"

// https://adventofcode.com/2022/day/3
fun main() {
    val lines = readLines("day3.txt")
    val dbg = readLines("test3.txt")
    first(lines)
    println("Stickers priority value is ${second(lines)}")
}

fun second(lines: List<String>) = lines.chunked(3)
    .flatMap {
        it[0].toSet() intersect it[1].toSet() intersect it[2].toSet()
    }
    .sumOf { it.number() }

fun first(lines: List<String>) {
    var total = 0
    for (line in lines) {
        val one = line.substring(0, line.length / 2)
        val two = line.substring((line.lastIndex / 2) + 1, line.length)
        val revised = mutableSetOf<Char>()

        for (char in one) {
            for (string in two) {
                if (revised.contains(char)) continue
                if (char.equals(string, false)) {
                    revised.add(char)
                    total += char.number()
                }
            }
        }
    }
    println("Sum of priorities of the item types is $total")
}

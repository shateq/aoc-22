// https://adventofcode.com/2022/day/3
var total = 0
val map = priority()

fun main() {
    val lines = readLines("day3.txt")
    first(lines)
}

fun first(lines: List<String>) {
    println(priority())
    for (line in lines) {
        val one = line.substring(0, line.length/2)
        val two = line.substring((line.lastIndex/2) +1, line.length)
        val revised = mutableSetOf<Char>()

        for (char in one) {
            for (string in two) {
                if (revised.contains(char)) continue
                if (char.equals(string, false)) {
                    revised.add(char)
                    //println("$char (${map[char.toString()]!!})")
                    total += map[char.toString()]!!
                }
            }
        }
    }
    println("Sum of priorities of the item types is $total")
}

fun priority(): Map<String, Int> {
    val map = mutableMapOf<String, Int>()
    var i = 0
    for (ch in 'a'..'z') {
        i++
        map[ch.toString()] = i
    }
    i = 26
    for (ch in 'A'..'Z') {
        i++
        map[ch.toString()] = i
    }
    return map.toMap()
}

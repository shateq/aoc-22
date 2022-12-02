// https://adventofcode.com/2022/day/2

val map = mapOf(
    Pair("A", RPS.Rock),
    Pair("B", RPS.Paper),
    Pair("C", RPS.Scissors),
    Pair("X", RPS.Rock),
    Pair("Y", RPS.Paper),
    Pair("Z", RPS.Scissors),
)

val needTo = mapOf(
    Pair("X", Outcome.LOSE),
    Pair("Y", Outcome.DRAW),
    Pair("Z", Outcome.WIN)
)
// TODO naming ftw
val whatWins = mapOf(
    Pair(RPS.Paper, RPS.Rock),
    Pair(RPS.Rock, RPS.Scissors),
    Pair(RPS.Scissors, RPS.Paper)
)

val whatLoses = mapOf(
    Pair(RPS.Paper, RPS.Scissors),
    Pair(RPS.Rock, RPS.Paper),
    Pair(RPS.Scissors, RPS.Rock)
)

var total = 0

fun main() {
    val lines = readLines("input.txt")
    one(lines)
    total = 0
    two(lines)
}

fun one(list: List<String>) {
    for (line in list) {
        if (line.isEmpty() || line.isBlank()) continue
        val option = line.trim().split(" ")

        val opponent = map[option[0]]!!
        val mine = map[option[1]]!!
        val outcome = mine.verdict(opponent)

        total += mine.score
        total += outcome.score
    }
    println("My total score is $total")
}

fun two(list: List<String>) {
    for (line in list) {
        if (line.isEmpty() || line.isBlank()) continue
        val option = line.trim().split(" ")

        val opponent = map[option[0]]!!
        val need = needTo[option[1]]!!
        //println("-- $opponent so that $need")
        val myMove: RPS = when (need) {
            Outcome.LOSE -> whatWins[opponent]!!
            Outcome.WIN -> whatLoses[opponent]!!
            Outcome.DRAW -> opponent
        }

        val out = myMove.verdict(opponent)

        total += myMove.score
        total += out.score

        //println("Need $myMove ${myMove.score} \nOut $out ${out.score}")
    }
    println("Strategy is $total")
}

fun RPS.verdict(other: RPS): Outcome {
    if (this == other) return Outcome.DRAW
    if (whatWins[this] == other) return Outcome.WIN
    if (whatWins[this] != other) return Outcome.LOSE
    return Outcome.DRAW
}

fun readLines(fileName: String): List<String> {
    return object {}.javaClass.getResourceAsStream(fileName)?.reader()?.readLines() ?: listOf()
}
// https://adventofcode.com/2022/day/2

val map = mapOf(
    "A" to RPS.Rock,
    "B" to RPS.Paper,
    "C" to RPS.Scissors,
    "X" to RPS.Rock,
    "Y" to RPS.Paper,
    "Z" to RPS.Scissors,
)

val needTo = mapOf(
    "X" to Outcome.LOSE,
    "Y" to Outcome.DRAW,
    "Z" to Outcome.WIN
)
// TODO naming ftw
val whatWins = mapOf(
    RPS.Paper to RPS.Rock,
    RPS.Rock to RPS.Scissors,
    RPS.Scissors to RPS.Paper
)

val whatLoses = mapOf(
    RPS.Paper to RPS.Scissors,
    RPS.Rock to RPS.Paper,
    RPS.Scissors to RPS.Rock
)

var total = 0

fun main() {
    val lines = readLines("day2.txt")
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

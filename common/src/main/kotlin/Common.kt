fun readLines(fileName: String): List<String> {
    return object {}.javaClass.getResourceAsStream(fileName)?.reader()?.readLines() ?: listOf()
}
// Day 3
fun Char.number() = if (this.isUpperCase()) this - 'A' + 27 else this - 'a' + 1


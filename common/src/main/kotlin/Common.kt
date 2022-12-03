fun readLines(fileName: String): List<String> {
    return object {}.javaClass.getResourceAsStream(fileName)?.reader()?.readLines() ?: listOf()
}

fun readRomanNumeral(inputNumeral: String): Int {
    val numerals = inputNumeral.toCharArray()
    val numeralsAsIntegers = numerals.map { romanNumeralToInteger(it.toString()) ?: 0 }
    var runningTotal = 0

    for (n in numeralsAsIntegers.indices) {
        val comparator = minOf(n+1,numeralsAsIntegers.size-1)
        if (numeralsAsIntegers[comparator] > numeralsAsIntegers[n])
            runningTotal -= numeralsAsIntegers[n]
        else
            runningTotal +=numeralsAsIntegers[n]
    }
    return runningTotal
}
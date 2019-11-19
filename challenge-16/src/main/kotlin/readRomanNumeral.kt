fun readRomanNumeral(inputNumeral: String): Int {
    val numerals = inputNumeral.toCharArray()
    val numeralsAsIntegers = numerals.map { romanNumeralToInteger(it.toString()) }
    var runningTotal = 0

    for (n in numeralsAsIntegers.indices) {
        if  (n < numeralsAsIntegers.size -1 && numeralsAsIntegers[n+1] > numeralsAsIntegers[n])
            runningTotal -= numeralsAsIntegers[n]
        else
            runningTotal +=numeralsAsIntegers[n]
    }
    return runningTotal
}
<<<<<<< HEAD
fun readRomanNumeral(inputNumeral: String): Int {
    val numerals = inputNumeral.toCharArray()
    val numeralsAsIntegers = numerals.map { romanNumeralToInteger(it.toString()) }
    var runningTotal = 0

    for (n in numeralsAsIntegers.indices) {
        val comparator = minOf(n+1,numeralsAsIntegers.size-1)
        if (numeralsAsIntegers[comparator] > numeralsAsIntegers[n])
            runningTotal -= numeralsAsIntegers[n]
        else
            runningTotal +=numeralsAsIntegers[n]
    }
    return runningTotal
=======
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
>>>>>>> 09de515767c6b01f1b49a1ab6debebb29a25f55c
}
fun readRomanNumeral(inputNumeral:String):Int {
    val numerals = inputNumeral.toCharArray()
    var runningTotal = 0

    for (n in numerals) {
        val numeralAsInteger = romanNumeralToInteger(n.toString())
        runningTotal += numeralAsInteger ?: 0
    }
    return runningTotal
}
fun readRomanNumeral(inputNumeral:String):Int {
    val numerals = inputNumeral.toCharArray()
    val numeralsAsIntegers = numerals.map{ romanNumeralToInteger(it.toString()) ?: 0}

    return numeralsAsIntegers.sum()
}
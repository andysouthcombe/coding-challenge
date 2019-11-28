fun addRomanNumerals(numeralA:String,numeralB: String):String {
    return integerToRomanNumeral(readRomanNumeral(numeralA) + readRomanNumeral(numeralB))
}
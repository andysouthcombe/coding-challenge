fun addRomanNumerals(numeralA:String,numeralB: String):String {
    return integerToRomanNumeral(romanNumeralToInteger(numeralA) + romanNumeralToInteger(numeralB))
}
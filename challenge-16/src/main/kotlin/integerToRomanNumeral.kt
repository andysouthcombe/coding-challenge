fun integerToRomanNumeral(inputInteger: Int): String{
    var remainder = inputInteger
    var outputNumeral = ""
    while(remainder > 0)
    {
        var largestNumeral =  numeralMap.floorValue(remainder)
        remainder -= romanNumeralToInteger(largestNumeral)
        outputNumeral += largestNumeral
    }
    return outputNumeral
}
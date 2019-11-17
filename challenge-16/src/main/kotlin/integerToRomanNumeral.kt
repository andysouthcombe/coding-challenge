fun integerToRomanNumeral(inputInteger: Int): String{
    val keys = numeralMap.filterValues { it == inputInteger }.keys
    return keys.first()
}
val numeralMap = sortedMapOf(
    "I" to 1,
    "IV" to 4,
    "V" to 5,
    "IX" to 9,
    "X" to 10,
    "XL" to 40,
    "L" to 50,
    "XC" to 90,
    "C" to 100,
    "CD" to 400,
    "D" to 500,
    "CM" to 900,
    "M" to 1000
)

fun Map<String,Int>.floorValue(inputValue:Int):String {
    var returnKey = ""
    for((k,v) in this) {
        if(v <= inputValue) {
            returnKey = k
        }
    }
    return returnKey
}
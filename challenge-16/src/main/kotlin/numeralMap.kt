val numeralMap = sortedMapOf(
    "I" to 1,
    "V" to 5,
    "X" to 10,
    "L" to 50,
    "C" to 100,
    "D" to 500,
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
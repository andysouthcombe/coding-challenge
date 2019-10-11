fun myFold(inputList:List<Int>, acc:String,f:(String, Int)->String): String {
    var output = acc
    for(i in inputList) {
        output = f(output,i)
    }
    return output
}

fun <ListType,ReturnType>myGenericFold(inputList:List<ListType>, acc:ReturnType,f:(ReturnType,ListType)->ReturnType):ReturnType {
    var output = acc
            for(i in inputList) {
                output = f(output,i)
            }
    return output
}
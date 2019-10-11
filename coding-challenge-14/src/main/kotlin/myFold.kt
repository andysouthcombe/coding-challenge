fun myFold(inputList:List<Int>, acc:String,f:(String, Int)->String): String {
    var output = acc
    for(i in inputList) {
        output = f(output,i)
    }
    return output
}
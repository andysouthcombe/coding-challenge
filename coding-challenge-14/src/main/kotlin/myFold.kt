fun myFold(inputList:List<Int>, acc:String,f:(String, Int)->String): String {
    return acc + inputList[0].toString()
}
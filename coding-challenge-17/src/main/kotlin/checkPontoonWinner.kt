fun checkPontoonWinner(playerHandString:String,dealerHandString:String) {

}

fun cardStringToCardObject(cardString:String):Card{
    val charList = cardString.toCharArray()
    return Card(CardName.fromString(charList[0].toString()), Suit.HEARTS)
}
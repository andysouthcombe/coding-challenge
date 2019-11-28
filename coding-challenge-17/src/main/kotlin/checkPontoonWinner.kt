fun checkPontoonWinner(playerHandString:String,dealerHandString:String) {

}

fun cardStringToCardObject(cardString:String):Card{
    val cardNameString = cardString.first().toString()
    val suitNameString = cardString.last().toString()
    return Card(CardName.fromString(cardNameString), Suit.fromString(suitNameString))
}

fun handStringToHandList(playerHandString: Array<String>):Hand {
    return playerHandString.map{cardStringToCardObject(it)}
}
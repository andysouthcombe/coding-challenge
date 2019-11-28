const val bustValue = 21

fun checkPontoonWinner(playerHandString: Array<String>, dealerHandString: Array<String>):Pair<String,String> {
    return Pair("a","b")
}

fun cardStringToCardObject(cardString: String): Card {
    val cardNameString = cardString.first().toString()
    val suitNameString = cardString.last().toString()
    return Card(CardName.fromString(cardNameString), Suit.fromString(suitNameString))
}

fun handStringToHandList(playerHandString: Array<String>): Hand {
    return playerHandString.map { cardStringToCardObject(it) }
}


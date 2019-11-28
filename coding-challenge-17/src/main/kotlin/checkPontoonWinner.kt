const val bustValue = 21

fun checkPontoonWinner(playerHandString: Array<String>, dealerHandString: Array<String>): Pair<String, String> {
    val playerHand = handStringToHandList(playerHandString)
    val dealerHand = handStringToHandList(dealerHandString)

    return if (playerHand.rank() > dealerHand.rank()) {
        Pair("The player", playerHand.printName())
    } else {
        Pair("The dealer", dealerHand.printName())
    }
}

fun cardStringToCardObject(cardString: String): Card {
    val cardNameString = cardString.first().toString()
    val suitNameString = cardString.last().toString()
    return Card(CardName.fromString(cardNameString), Suit.fromString(suitNameString))
}

fun handStringToHandList(playerHandString: Array<String>): Hand {
    return playerHandString.map { cardStringToCardObject(it) }
}


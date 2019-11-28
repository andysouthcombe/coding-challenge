const val bustValue = 21

fun checkPontoonWinner(playerHandString: String, dealerHandString: String) {

}

fun cardStringToCardObject(cardString: String): Card {
    val cardNameString = cardString.first().toString()
    val suitNameString = cardString.last().toString()
    return Card(CardName.fromString(cardNameString), Suit.fromString(suitNameString))
}

fun handStringToHandList(playerHandString: Array<String>): Hand {
    return playerHandString.map { cardStringToCardObject(it) }
}

fun calculateHandValue(hand: Hand): Int {
    val highValue = hand.sumBy { it.cardName.cardValue }
    return if (highValue > bustValue && hand.containsAce()) {
        hand.sumBy {
            when (it.cardName) {
                CardName.ACE -> 1
                else -> it.cardName.cardValue
            }
        }
    } else {
        highValue
    }
}
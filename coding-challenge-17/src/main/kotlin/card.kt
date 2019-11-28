data class Card(val cardName: CardName, val suit: Suit) {
    override fun toString(): String {
        return "${this.cardName.cardName} of ${this.suit.suitName}"
    }
}

typealias Hand = List<Card>

fun Hand.containsAce ():Boolean{
    for(card in this) {
        if (card.cardName == CardName.ACE) {
            return true
        }
    }
    return false
}

fun Hand.calculateValue(): Int {
    val highValue = this.sumBy { it.cardName.cardValue }
    return if (highValue > bustValue && this.containsAce()) {
        this.sumBy {
            when (it.cardName) {
                CardName.ACE -> 1
                else -> it.cardName.cardValue
            }
        }
    } else {
        highValue
    }
}

fun Hand.isBust():Boolean {
    return this.calculateValue() > bustValue
}

fun Hand.printName():String {
    return this.joinToString { it.toString()}
}
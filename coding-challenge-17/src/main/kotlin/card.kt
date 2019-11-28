data class Card(val cardName: CardName, val suit: Suit) {
    override fun toString(): String {
        return "${this.cardName.cardName} of ${this.suit.suitName}"
    }
}

typealias Hand = List<Card>

fun Hand.containsAce ():Boolean{
    return this.any{ it.cardName == CardName.ACE}
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

fun Hand.containsPictureCard():Boolean {
    return this.any{ it.cardName == CardName.JACK || it.cardName == CardName.KING || it.cardName ==CardName.QUEEN }
}
fun Hand.isPontoon():Boolean {
    return this.containsAce() && this.containsPictureCard()
}

fun Hand.isFiveCardTrick():Boolean {
    return this.count() == 5 && !this.isBust()
}

fun Hand.rank() : Int {
    if (this.isPontoon()) {
        return 100
    }
    if (this.isFiveCardTrick()) {
        return 101
    }
    if (this.isBust()) {
        return -1
    }
    return this.calculateValue()
}
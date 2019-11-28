data class Card(val cardName: CardName, val suit: Suit) {

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


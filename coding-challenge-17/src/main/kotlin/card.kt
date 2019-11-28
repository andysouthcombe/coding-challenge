data class Card(val suit: Suit, val cardName: CardName)

typealias Hand = Pair<Card,Card>
data class Card(val cardName: CardName, val suit: Suit)

typealias Hand = Pair<Card,Card>
import java.lang.IllegalArgumentException

enum class Suit (val suitCode:String, val suitName:String){
    CLUBS("C","Clubs"),
    DIAMONDS("D","Diamonds"),
    HEARTS("H","Hearts"),
    SPADES("S","Spades");

    companion object {
        private val map = Suit.values().associateBy(Suit::suitCode)
        fun fromString(suitName:String) = map[suitName] ?: throw Exception("Invalid Suit Code")
    }
}

enum class CardName (val cardNameCode:String,val cardName:String,val cardValue:Int){
    TWO("2","Two",2),
    THREE("3","Three",3),
    FOUR("4","Four",4),
    FIVE("5","Five",5),
    SIX("6","Six",6),
    SEVEN("7","Seven",7),
    EIGHT("8","Eight",8),
    NINE("9","Nine",9),
    TEN("T","Ten",10),
    JACK("J","Jack",10),
    QUEEN("Q","Queen",10),
    KING("K","King",10),
    ACE("A","Ace",10);

    companion object {
        private val map = CardName.values().associateBy(CardName::cardNameCode)
        fun fromString(cardName:String) = map[cardName] ?: throw Exception("Invalid cardName Code")
    }
}
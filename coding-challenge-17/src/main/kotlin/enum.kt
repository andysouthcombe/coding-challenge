import java.lang.IllegalArgumentException

enum class Suit (val suitCode:String, val suitName:String){
    CLUBS("C","Clubs"),
    DIAMONDS("D","Diamonds"),
    HEARTS("H","Hearts"),
    SPADES("S","Spades");
}

enum class CardName (val cardNameCode:String,val cardName:String){
    TWO("2","Two"),
    THREE("3","Three"),
    FOUR("4","Four"),
    FIVE("5","Five"),
    SIX("6","Six"),
    SEVEN("7","Seven"),
    EIGHT("8","Eight"),
    NINE("9","Nine"),
    TEN("T","Ten"),
    JACK("J","Ten"),
    QUEEN("Q","Ten"),
    KING("K","Ten"),
    ACE("A","Ten");

    companion object {
        private val map = CardName.values().associateBy(CardName::cardNameCode)
        fun fromString(cardName:String) = map[cardName] ?: throw Exception("Invalid cardName Code")
    }
}
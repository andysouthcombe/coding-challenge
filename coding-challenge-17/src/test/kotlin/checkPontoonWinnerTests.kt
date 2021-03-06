import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

val eightOfClubs = Card(CardName.EIGHT,Suit.CLUBS)
val threeOfSpades = Card(CardName.THREE,Suit.SPADES)
val twoOfHearts = Card(CardName.TWO, Suit.HEARTS)
val aceOfHearts = Card(CardName.ACE, Suit.HEARTS)
val jackOfDiamonds = Card(CardName.JACK, Suit.DIAMONDS)
val queenOfSpades = Card(CardName.QUEEN, Suit.SPADES)
val fourOfClubs = Card(CardName.FOUR, Suit.CLUBS)

class CheckPontoonWinnerTests {
    @Test
    fun `should declare player the winner if dealer is bust` () {
        val playerHand = arrayOf("5D","JC")
        val dealerHand = arrayOf("QC","TH","TH")
        val result = checkPontoonWinner(playerHand,dealerHand)
        assertThat(result).isEqualTo(Pair("The player","Five of Diamonds, Jack of Clubs"))
    }
    @Test
    fun `should declare dealer the winner if player is bust` () {
        val playerHand = arrayOf("QC","TH","TS")
        val dealerHand = arrayOf("7D","KC")
        val result = checkPontoonWinner(playerHand,dealerHand)
        assertThat(result).isEqualTo(Pair("The dealer","Seven of Diamonds, King of Clubs"))
    }
    @Test
    fun `should declare player the winner if player has pontoon and dealer has 21` () {
        val playerHand = arrayOf("QC","AS")
        val dealerHand = arrayOf("TH","9S","2C")
        val result = checkPontoonWinner(playerHand,dealerHand)
        assertThat(result).isEqualTo(Pair("The player","Queen of Clubs, Ace of Spades"))
    }
    @Test
    fun `should declare player the winner if player has five card trick and dealer has 21` () {
        val playerHand = arrayOf("2C","6C","5D","3S","4H")
        val dealerHand = arrayOf("TH","9S","2C")
        val result = checkPontoonWinner(playerHand,dealerHand)
        assertThat(result).isEqualTo(Pair("The player","Two of Clubs, Six of Clubs, Five of Diamonds, Three of Spades, Four of Hearts"))
    }
    @Test
    fun `should declare player the winner if player has higher score` () {
        val playerHand = arrayOf("2C","TD")
        val dealerHand = arrayOf("2C","9S")
        val result = checkPontoonWinner(playerHand,dealerHand)
        assertThat(result).isEqualTo(Pair("The player","Two of Clubs, Ten of Diamonds"))
    }
    @Test
    fun `should declare dealer winner if tie ` () {
        val playerHand = arrayOf("KH","AC")
        val dealerHand = arrayOf("KC","AS")
        val result = checkPontoonWinner(playerHand,dealerHand)
        assertThat(result).isEqualTo(Pair("The dealer","King of Clubs, Ace of Spades"))
    }
}

class CardStringToCardsTests {
    @Test
    fun `should parse alphanumeric heart card string to card object`(){
        assertThat(cardStringToCardObject("2H")).isEqualTo(twoOfHearts)
    }
    @Test
    fun `should parse alpha heart card string to card object`(){
        assertThat(cardStringToCardObject("AH")).isEqualTo(aceOfHearts)
    }
    @Test
    fun `should parse alpha non heart card string to card object`(){
        assertThat(cardStringToCardObject("JD")).isEqualTo(jackOfDiamonds)
    }
}

class HandStringToHandObjectTests {
    @Test
    fun `should parse alphanumeric hand string of two cards to hand list for player`(){
        val requiredHand:Hand = listOf(eightOfClubs,threeOfSpades)
        assertThat(handStringToHandList(arrayOf("8C","3S"))).isEqualTo(requiredHand)
    }
    @Test
    fun `should parse alphanumeric hand string of three cards to hand list for player`(){
        val requiredHand:Hand = listOf(twoOfHearts,jackOfDiamonds,queenOfSpades)
        assertThat(handStringToHandList(arrayOf("2H","JD","QS"))).isEqualTo(requiredHand)
    }
}

class HandValueTests {
    @Test
    fun `should add two numeric cards to get the value as the sum` () {
        val hand:Hand = listOf(eightOfClubs,threeOfSpades)
        assertThat((hand.calculateValue())).isEqualTo(11)
    }
    @Test
    fun `should add numeric and picture cards to get the value as the sum` () {
        val hand:Hand = listOf(twoOfHearts,jackOfDiamonds,queenOfSpades)
        assertThat(hand.calculateValue()).isEqualTo(22)
    }
    @Test
    fun `should handle value for aces high` () {
        val hand:Hand = listOf(fourOfClubs,aceOfHearts)
        assertThat(hand.calculateValue()).isEqualTo(15)
    }
    @Test
    fun `should handle value for aces low` () {
        val hand:Hand = listOf(fourOfClubs,aceOfHearts,eightOfClubs)
        assertThat(hand.calculateValue()).isEqualTo(13)
    }
}

class ContainsAceTests {
    @Test
    fun `should return true for hand containing an ace` () {
        val hand:Hand = listOf(fourOfClubs,aceOfHearts,eightOfClubs)
        assertThat(hand.containsAce()).isTrue()
    }
    @Test
    fun `should return false for hand not containing an ace` () {
        val hand:Hand = listOf(twoOfHearts,jackOfDiamonds,queenOfSpades)
        assertThat(hand.containsAce()).isFalse()
    }
}

class IsBustTests {
    @Test
    fun `should return false for hand less than 22 with no aces` () {
        val hand:Hand = listOf(eightOfClubs,threeOfSpades)
        assertThat(hand.isBust()).isFalse()
    }
    @Test
    fun `should return false for hand less than 22 with an ace` () {
        val hand:Hand = listOf(fourOfClubs,aceOfHearts)
        assertThat(hand.isBust()).isFalse()
    }
    @Test
    fun `should return true for hand over 21 with no aces` () {
        val hand:Hand = listOf(twoOfHearts,jackOfDiamonds,queenOfSpades)
        assertThat(hand.isBust()).isTrue()
    }
    @Test
    fun `should return true for hand over 21 with an aces` () {
        val hand:Hand = listOf(twoOfHearts,jackOfDiamonds,queenOfSpades,aceOfHearts)
        assertThat(hand.isBust()).isTrue()
    }

}

class CardTests {
    @Test
    fun `should display card name` () {
        assertThat(eightOfClubs.toString()).isEqualTo("Eight of Clubs")
    }
}

class HandPrintNameTests {
    @Test
    fun `should print name for hand of two cards` () {
        val hand:Hand = listOf(fourOfClubs,aceOfHearts)
        assertThat(hand.printName()).isEqualTo("Four of Clubs, Ace of Hearts")
    }
}
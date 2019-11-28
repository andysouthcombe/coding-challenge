import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

val eightOfClubs = Card(CardName.EIGHT,Suit.CLUBS)
val threeOfSpades = Card(CardName.THREE,Suit.SPADES)
val twoOfHearts = Card(CardName.TWO, Suit.HEARTS)
val aceOfHearts = Card(CardName.ACE, Suit.HEARTS)
val jackOfDiamonds = Card(CardName.JACK, Suit.DIAMONDS)
val queenOfSpades = Card(CardName.QUEEN, Suit.SPADES)

class CheckPontoonWinnerTests {

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

class CalculateHandValueTests {
    @Test
    fun `should add two numeric cards to get the value as the sum` () {
        val hand:Hand = listOf(eightOfClubs,threeOfSpades)
        assertThat(calculateHandValue(hand)).isEqualTo(11)
    }
}
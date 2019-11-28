import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CheckPontoonWinnerTests {

}

class CardStringToCardsTests {
    @Test
    fun `should parse alphanumeric heart card string to card object`(){
        val requiredCard = Card(CardName.TWO, Suit.HEARTS)
        assertThat(cardStringToCardObject("2H")).isEqualTo(requiredCard)
    }
    @Test
    fun `should parse alpha heart card string to card object`(){
        val requiredCard = Card(CardName.ACE, Suit.HEARTS)
        assertThat(cardStringToCardObject("AH")).isEqualTo(requiredCard)
    }
    @Test
    fun `should parse alpha non heart card string to card object`(){
        val requiredCard = Card(CardName.JACK, Suit.DIAMONDS)
        assertThat(cardStringToCardObject("JD")).isEqualTo(requiredCard)
    }
}

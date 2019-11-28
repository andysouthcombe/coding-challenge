import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CheckPontoonWinnerTests {

}

class CardStringToCardsTests {
    @Test
    fun `should parse alphanumeric hand string to cards`(){
        val requiredCard = Card(CardName.TWO, Suit.HEARTS)
        assertThat(cardStringToCardObject("2H")).isEqualTo(requiredCard)
    }
    @Test
    fun `should parse alpha hand string to cards`(){
        val requiredCard = Card(CardName.ACE, Suit.HEARTS)
        assertThat(cardStringToCardObject("AH")).isEqualTo(requiredCard)
    }
}

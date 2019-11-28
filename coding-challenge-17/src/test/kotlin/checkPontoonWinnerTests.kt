import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CheckPontoonWinnerTests {

}

class CardStringToCardsTests {
    @Test
    fun `should parse alphanumeric hand string to cards`(){
        val requiredCard = Card(Suit.HEARTS,CardName.TWO)
        assertThat(cardStringToCardObject("2H")).isEqualTo(requiredCard)
    }
}

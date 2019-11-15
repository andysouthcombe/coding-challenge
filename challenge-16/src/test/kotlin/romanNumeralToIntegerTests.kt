import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RomanNumeralToIntegerTests {
    @Test
    fun `should convert I to 1` () {
        assertThat(romanNumeralToInteger("I")).isEqualTo(1)
    }
    @Test
    fun `should convert II to 2` () {
        assertThat(romanNumeralToInteger("II")).isEqualTo(2)
    }
    @Test
    fun `should convert III to 3` () {
        assertThat(romanNumeralToInteger("III")).isEqualTo(3)
    }
}
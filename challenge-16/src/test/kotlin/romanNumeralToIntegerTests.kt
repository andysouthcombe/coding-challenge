import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RomanNumeralToIntegerTests {
    @Test
    fun `should convert I to 1` () {
        assertThat(romanNumeralToInteger("I")).isEqualTo(1)
    }
}
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RomanNumeralToIntegerTests {
    @Test
    fun `should convert I to 1` () {
        assertThat(romanNumeralToInteger("I")).isEqualTo(1)
    }
    @Test
    fun `should convert V to 5` () {
        assertThat(romanNumeralToInteger("V")).isEqualTo(5)
    }
    @Test
    fun `should convert X to 10` () {
        assertThat(romanNumeralToInteger("X")).isEqualTo(10)
    }
    @Test
    fun `should convert L to 50` () {
        assertThat(romanNumeralToInteger("L")).isEqualTo(50)
    }
}
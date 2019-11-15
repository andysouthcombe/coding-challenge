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
    @Test
    fun `should convert IV to 4` () {
        assertThat(romanNumeralToInteger("IV")).isEqualTo(4)
    }
    @Test
    fun `should convert V to 5` () {
        assertThat(romanNumeralToInteger("V")).isEqualTo(5)
    }
}
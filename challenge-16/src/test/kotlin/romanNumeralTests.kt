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
    @Test
    fun `should convert C to 100` () {
        assertThat(romanNumeralToInteger("C")).isEqualTo(100)
    }
    @Test
    fun `should convert D to 500` () {
        assertThat(romanNumeralToInteger("D")).isEqualTo(500)
    }
    @Test
    fun `should convert M to 1000` () {
        assertThat(romanNumeralToInteger("M")).isEqualTo(1000)
    }
}

class ReadRomanNumeralTests {
    @Test
    fun `should convert I to 1` () {
        assertThat(readRomanNumeral("I")).isEqualTo(1)
    }
    @Test
    fun `should convert II to 2` () {
        assertThat(readRomanNumeral("II")).isEqualTo(2)
    }
    @Test
    fun `should convert IV to 4` () {
        assertThat(readRomanNumeral("IV")).isEqualTo(4)
    }


}
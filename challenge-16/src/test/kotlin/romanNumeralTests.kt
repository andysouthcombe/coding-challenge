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
    @Test
    fun `should convert LXXXV to 85` () {
        assertThat(readRomanNumeral("LXXXV")).isEqualTo(85)
    }
    @Test
    fun `should convert XCV to 95` () {
        assertThat(readRomanNumeral("XCV")).isEqualTo(95)
    }

}

class IntegerToRomanNumeralTests {
    @Test
    fun `should convert 1 to I` (){
        assertThat(integerToRomanNumeral(1)).isEqualTo("I")
    }
    @Test
    fun `should convert 2 to II` (){
        assertThat(integerToRomanNumeral(2)).isEqualTo("II")
    }

    @Test
    fun `should convert 3 to III` (){
        assertThat(integerToRomanNumeral(3)).isEqualTo("III")
    }

    @Test
    fun `should convert 4 to IV` (){
        assertThat(integerToRomanNumeral(4)).isEqualTo("IV")
    }

    @Test
    fun `should convert 97 to XCVII` (){
        assertThat(integerToRomanNumeral(97)).isEqualTo("XCVII")
    }


}

class AddRomanNumeralTests{
    @Test
    fun `should add I and I to get II` () {
        assertThat(addRomanNumerals("I","I")).isEqualTo("II")
    }
    @Test
    fun `should add I and II to get III` () {
        assertThat(addRomanNumerals("I","II")).isEqualTo("III")
    }
    @Test
    fun `should add C and IX to get CIX` () {
        assertThat(addRomanNumerals("C","IX")).isEqualTo("CIX")
    }



}
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test


class MyFoldTests (){
    @Test
    fun `should work on a list with one integer`() {
        assertThat(myFold(listOf(1),"Number is ") { acc, element -> acc + element.toString()}).isEqualTo("Number is 1")
    }


}
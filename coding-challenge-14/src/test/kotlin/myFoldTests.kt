import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test


class MyFoldTests (){
    @Test
    fun `should work on a list with one integer`() {
        assertThat(myFold(listOf(1),"Number is ") { acc, element -> acc + element.toString()}).isEqualTo("Number is 1")
    }

    @Test
    fun `should work on a list with two integers` () {
        assertThat(myFold(listOf(1,2),"Number is ") { acc, element -> acc + element.toString()}).isEqualTo("Number is 12")
    }
}

class MyGenericFoldTests() {
    @Test
    fun `should work on a list with strings` () {
        val stringList = listOf<String>("a","b","c")
        assertThat(myGenericFold(stringList,"") {acc, element -> acc + element.toString()}).isEqualTo("abc")
    }

    @Test
    fun `should work on a list with integers` () {
        val  intList = listOf<Int>(4,5,6)
        assertThat(myGenericFold(intList,"") {acc, element -> acc + element.toString()}).isEqualTo("456")
    }
}
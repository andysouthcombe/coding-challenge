import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class GetPubsInAreasTests {
    @Test
    fun `empty input returns empty list of pubs`() {
        val emptyListOfPubs: List<Pub> = emptyList()
        assertThat(getPubsInArea("")).isEqualTo(emptyListOfPubs)
    }
}
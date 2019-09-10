import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class GetPubsInAreasTests {
    @Test
    fun `should return empty list of pubs for empty input`() {
        val emptyListOfPubs: List<Pub> = emptyList()
        assertThat(getPubsInArea("{}")).isEqualTo(emptyListOfPubs)
    }
    @Test
    fun `should parse json containing pub with no beers` () {
        val pubsInArea = getPubsInArea(PubsTestData().pubWithNoBeer)
        assertThat(pubsInArea.size).isEqualTo(1)
        assertThat(pubsInArea[0].name).isEqualTo("Phoenix")
        assertThat(pubsInArea[0].id).isEqualTo("16185")
        assertThat(pubsInArea[0].branch).isEqualTo("WLD")
        assertThat(pubsInArea[0].createTS).isEqualTo("2019-05-16 19:31:20")
        assertThat(pubsInArea[0].pubService).isEqualTo("https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London")


    }
}
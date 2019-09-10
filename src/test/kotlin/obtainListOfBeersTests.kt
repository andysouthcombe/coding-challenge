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
        assertThat(pubsInArea[0].regularBeers.size).isEqualTo(0)
        assertThat(pubsInArea[0].guestBeers.size).isEqualTo(0)
    }
    @Test
    fun `should parse json containing pub with a single beer` () {
        val pubsInArea = getPubsInArea(PubsTestData().pubWithOneRegularBeer)
        assertThat(pubsInArea.size).isEqualTo(1)
        assertThat(pubsInArea[0].name).isEqualTo("Phoenix")
        assertThat(pubsInArea[0].id).isEqualTo("16185")
        assertThat(pubsInArea[0].branch).isEqualTo("WLD")
        assertThat(pubsInArea[0].createTS).isEqualTo("2019-05-16 19:31:20")
        assertThat(pubsInArea[0].pubService).isEqualTo("https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London")
        assertThat(pubsInArea[0].regularBeers).isEqualTo(listOf("Young#039;s Bitter"))
        assertThat(pubsInArea[0].guestBeers.size).isEqualTo(0)
    }
    @Test
    fun `should parse json containing pub with two regular and three guest beers` () {
        val pubsInArea = getPubsInArea(PubsTestData().pubWithTwoRegularAndThreeGuestBeers)
        assertThat(pubsInArea.size).isEqualTo(1)
        assertThat(pubsInArea[0].name).isEqualTo("Phoenix")
        assertThat(pubsInArea[0].id).isEqualTo("16185")
        assertThat(pubsInArea[0].branch).isEqualTo("WLD")
        assertThat(pubsInArea[0].createTS).isEqualTo("2019-05-16 19:31:20")
        assertThat(pubsInArea[0].pubService).isEqualTo("https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London")
        assertThat(pubsInArea[0].regularBeers).isEqualTo(listOf("Doom Bar", "Otter Ale"))
        assertThat(pubsInArea[0].guestBeers).isEqualTo(listOf("Westerham Viceroy", "Westerham Summer Perle","Oxted Crystal"))
    }
    @Test
    fun `should handle list of multiple pubs` () {
        val pubsInArea = getPubsInArea(PubsTestData().threePubsWithVariousBeers)
        assertThat(pubsInArea.size).isEqualTo(3)
        assertThat(pubsInArea[0].name).isEqualTo("Phoenix")
        assertThat(pubsInArea[0].id).isEqualTo("16185")
        assertThat(pubsInArea[0].branch).isEqualTo("WLD")
        assertThat(pubsInArea[0].createTS).isEqualTo("2019-05-16 19:31:20")
        assertThat(pubsInArea[0].pubService).isEqualTo("service one")
        assertThat(pubsInArea[0].regularBeers.size).isEqualTo(2)
        assertThat(pubsInArea[0].guestBeers.size).isEqualTo(3)

        assertThat(pubsInArea[1].name).isEqualTo("Windsor Castle")
        assertThat(pubsInArea[1].id).isEqualTo("16186")
        assertThat(pubsInArea[1].branch).isEqualTo("WLD")
        assertThat(pubsInArea[1].createTS).isEqualTo("2019-05-17 19:31:20")
        assertThat(pubsInArea[1].pubService).isEqualTo("service two")
        assertThat(pubsInArea[1].regularBeers.size).isEqualTo(2)
        assertThat(pubsInArea[1].guestBeers.size).isEqualTo(1)

        assertThat(pubsInArea[2].name).isEqualTo("Brass Monkey")
        assertThat(pubsInArea[2].id).isEqualTo("16187")
        assertThat(pubsInArea[2].branch).isEqualTo("WLD")
        assertThat(pubsInArea[2].createTS).isEqualTo("2019-05-18 19:31:20")
        assertThat(pubsInArea[2].pubService).isEqualTo("service three")
        assertThat(pubsInArea[2].regularBeers.size).isEqualTo(2)
        assertThat(pubsInArea[2].guestBeers.size).isEqualTo(0)


    }
}

class obtainListOfBeersTests {
    @Test
    fun `should output empty list for a single pub with no beers` () {
        val beersInArea = obtainListOfBeers(PubsTestData().pubWithNoBeer)
        val emptyListOfBeers: List<Beer> = emptyList()
        assertThat(beersInArea).isEqualTo(emptyListOfBeers)
    }
    @Test
    fun `should output one pub and one beer for single pub with one beer` () {
        val beersInArea = obtainListOfBeers(PubsTestData().pubWithOneRegularBeer)
        val expectedListOfBeers = listOf(Beer("Young#039;s Bitter","Phoenix","https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London",true))
        assertThat(beersInArea).isEqualTo(expectedListOfBeers)
    }
    @Test
    fun `should set regular beer flag to false for guest beers` () {
        val beersInArea = obtainListOfBeers(PubsTestData().pubWithOneRegularBeerAndOneGuestBeer)
        val expectedListOfBeers = listOf(Beer("Doom Bar","Phoenix","https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London",false),
                                        Beer("Young#039;s Bitter","Phoenix","https://pubcrawlapi.appspot.com/pub/?v=1&id=16185&branch=WLD&uId=mike&pubs=no&realAle=yes&memberDiscount=no&town=London",true)
                                         )
        assertThat(beersInArea).isEqualTo(expectedListOfBeers)
    }

}
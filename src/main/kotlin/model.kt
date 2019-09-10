data class Pub(
    val name: String,
    val id: String,
    val branch: String,
    val createTS: String,
    val pubService: String,
    val regularBeers: List<String> = listOf(),
    val guestBeers: List<String> = listOf()
)

data class PubsInArea(val pubs:List<Pub>)
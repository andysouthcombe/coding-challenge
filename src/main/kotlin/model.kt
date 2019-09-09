data class Beer(val name: String)

data class Pub(
    val name: String,
    val id: String,
    val branch: String,
    val createTS: String,
    val pubService: String,
    val regularBeers: List<Beer> = listOf(),
    val guestBeers: List<Beer> = listOf()
)
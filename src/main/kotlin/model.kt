data class Beer(val name: String)

data class Pub(
    val name: String,
    val id: String,
    val branch: String,
    val createTS: String,
    val pubService: String,
    val regularBeers: List<Beer> = emptyList(),
    val guestBeers: List<Beer> = emptyList()
)
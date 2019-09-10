import com.beust.klaxon.FieldRenamer
import com.beust.klaxon.Klaxon
import java.lang.Exception

fun getPubsInArea(inputJson: String): List<Pub> {
    val renamer = object: FieldRenamer {
        override fun toJson(fieldName: String) = fieldName.capitalize()
        override fun fromJson(fieldName: String) = fieldName.toLowerCase()
    }
    val klaxon = Klaxon().fieldRenamer(renamer)
    return try {
    val pubsInArea = klaxon.parse<PubsInArea>(inputJson)
        pubsInArea?.pubs?.sortedByDescending {it.createTS}?.distinctBy {Pair(it.name,it.id)} ?: listOf()
    } catch (e: Exception) {
        listOf()
    }

}

fun obtainListOfBeers(inputJson: String): List<Beer> {
    val pubsInArea = getPubsInArea(inputJson)
    val beersInArea = pubsInArea.flatMap{pub -> pub.regularBeers.map {name -> Beer(name,pub.name,pub.pubService,true)}} + pubsInArea.flatMap{pub -> pub.guestBeers.map {name -> Beer(name,pub.name,pub.pubService,false)}}
    return beersInArea.sortedWith(compareBy({it.name},{it.pubName}))
}
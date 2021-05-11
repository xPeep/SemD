package generator

import model.Person

class PersonMockGenerator {

	private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

	private fun generateName(size: Int): String {
		return (1..size)
			.map { kotlin.random.Random.nextInt(0, charPool.size) }
			.map(charPool::get)
			.joinToString("")
	}

	fun createPersons(size: Int): List<Person> {
		val persons = mutableListOf<Person>()
		for (x in 0..126) {
			persons.add(createPerson(x))
		}
		return persons
	}

	fun createPerson(id: Int): Person {
		return Person(
			id,
			generateName(5),
		)
	}


}

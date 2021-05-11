import generator.PersonMockGenerator
import model.Person
import structure.Table
import java.util.*


fun main() {
	vizualize()
	testItems()
}

fun testItems() {
	val personMockGenerator = PersonMockGenerator()
	var table = Table<Person>()
	val persons = personMockGenerator.createPersons(127)


	val results = mutableListOf<Int>()

	for (x in 1..1000) {
		persons.forEach { table.add(it) }
		results.add(table.depth())
		table = Table()
	}

	println("Průměrná   mohutnost: " + results.average())
	println("Maximální  mohutnost: " + results.maxOrNull())
	println("Minimální  mohutnost: " + results.minOrNull())
	println("Modus     mohutnosti: " + mode(results))
	println("Kumulativní četnosti:\n" + countFreq(results, 1000))
}

fun vizualize() {
	val personMockGenerator = PersonMockGenerator()
	val table = Table<Person>()

	personMockGenerator.createPersons(10).forEach { table.add(it) }
	table.printTree()
}

fun countFreq(a: MutableList<Int>, n: Int) {
	val hm = HashMap<Int, Int>()
	for (i in 0 until n) hm[a[i]] = if (hm[a[i]] == null) 1 else hm[a[i]]!! + 1

	val st: SortedMap<Int, Int> = TreeMap()

	for ((key, value) in hm) {
		st[key] = value
	}
	var cumul = 0

	for ((key, value) in st) {
		cumul += value
		println("$key $cumul")
	}
}

fun mode(array: MutableList<Int>): Int {
	val hm = HashMap<Int, Int?>()
	var max = 1
	var temp = 0
	for (i in array.indices) {
		if (hm[array[i]] != null) {
			var count = hm[array[i]]!!
			count++
			hm[array[i]] = count
			if (count > max) {
				max = count
				temp = array[i]
			}
		} else hm[array[i]] = 1
	}
	return temp
}

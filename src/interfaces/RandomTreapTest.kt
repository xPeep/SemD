package interfaces

import structure.RandomTreap
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class RandomTreapTest {

	@Test
	fun add() {
		val randomTreap = RandomTreap<Int, String>()

		randomTreap.add(1, "FIRST")
		randomTreap.add(2, "SECOND")
		randomTreap.add(3, "THIRD")
		randomTreap.add(4, "FOURTH")

		assertTrue(randomTreap.contains(1))
		assertTrue(randomTreap.contains(2))
		assertTrue(randomTreap.contains(3))
		assertTrue(randomTreap.contains(4))
		assertTrue(!randomTreap.contains(5))
	}

	@Test
	fun addString() {
		val randomTreap = RandomTreap<String, String>()
		randomTreap.add("FIRST", "FIRST")
		randomTreap.add("SECOND", "SECOND")
		randomTreap.add("THIRD", "THIRD")
		randomTreap.add("FOURTH", "FOURTH")

		assertTrue(randomTreap.contains("FIRST"))
		assertTrue(randomTreap.contains("SECOND"))
		assertTrue(randomTreap.contains("THIRD"))
		assertTrue(randomTreap.contains("FOURTH"))
		assertTrue(!randomTreap.contains("HAHAHA"))
	}


	@Test
	fun depth() {
		val randomTreap = RandomTreap<Int, String>()

		randomTreap.add(1, "FIRST")
		randomTreap.add(2, "SECOND")
		randomTreap.add(3, "THIRD")
		randomTreap.add(4, "FOURTH")

		assertTrue(randomTreap.maxDepth() == 4)
	}

	@Test
	fun find() {
		val randomTreap = RandomTreap<Int, String>()

		randomTreap.add(1, "FIRST")
		randomTreap.add(2, "SECOND")
		randomTreap.add(3, "THIRD")
		randomTreap.add(4, "FOURTH")

		assertTrue(randomTreap.find(1) == "FIRST")
		assertTrue(randomTreap.find(2) == "SECOND")
		assertTrue(randomTreap.find(3) == "THIRD")
		assertTrue(randomTreap.find(4) == "FOURTH")
		assertTrue(randomTreap.find(5) == null)
	}

	@Test
	fun remove() {
		val randomTreap = RandomTreap<Int, String>()

		randomTreap.add(1, "FIRST")
		randomTreap.add(2, "SECOND")
		randomTreap.add(3, "THIRD")
		randomTreap.add(4, "FOURTH")

		assertTrue(!randomTreap.remove(5))

		assertTrue(randomTreap.contains(1))
		assertTrue(randomTreap.remove(1))
		assertTrue(!randomTreap.contains(1))


		assertTrue(randomTreap.contains(2))
		assertTrue(randomTreap.remove(2))
		assertTrue(!randomTreap.contains(2))

		assertTrue(randomTreap.contains(3))
		assertTrue(randomTreap.remove(3))
		assertTrue(!randomTreap.contains(3))

		assertTrue(randomTreap.contains(4))
		assertTrue(randomTreap.remove(4))
		assertTrue(!randomTreap.contains(4))

		assertTrue(!randomTreap.remove(5))
	}
}

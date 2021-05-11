package test

import structure.Table
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TableTest {

	@Test
	fun add() {
		val table = Table<String>()
		table.add("OMEGALULW")
		table.add("KEKW")
		table.add("OMG")
		table.add("NEVIM")
		table.add("POGCHAMP")

		assertTrue(table.size() == 5)
		println(table.printTree())
	}

	@Test
	fun remove() {
		val table = Table<String>()
		table.add("OMEGALULW")
		table.add("KEKW")
		table.add("OMG")
		table.add("NEVIM")
		table.add("POGCHAMP")


		table.remove(0)
		table.remove(1)
		table.remove(2)
		table.remove(3)
		table.remove(4)

		assertTrue(table.size() == 0)
	}

	@Test
	fun find() {
		val table = Table<String>()
		table.add("OMEGALULW")
		table.add("KEKW")
		table.add("OMG")
		table.add("NEVIM")
		table.add("POGCHAMP")

		val testedResult = listOf("KEKW", "OMG", "NEVIM")


		assertTrue(testedResult.containsAll(table.find(2,4)))
	}
}

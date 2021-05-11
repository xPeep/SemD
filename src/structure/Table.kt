package structure

import interfaces.ITable

class Table<T> : ITable<Int, T> {

	private var treap: RandomTreap<Int, T> = RandomTreap()
	private var index = 0

	override fun add(data: T) = treap.add(index++, data)
	override fun remove(key: Int) {
		if (treap.remove(key)) {
			index--
		}
	}

	override fun find(firstKey: Int, secondKey: Int): List<T> {
		return (firstKey - 1 until secondKey).mapNotNull { x ->
			treap.find(x)
		}
	}

	override fun isEmpty() = index == 0
	override fun size() = index

	fun depth(): Int = treap.maxDepth()

	fun printTree() = treap.toString()
}

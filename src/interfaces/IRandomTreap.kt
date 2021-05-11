package interfaces

interface IRandomTreap<K : Comparable<K>, T> {
	fun add(key: K, data: T)
	fun find(key: K): T?
	fun remove(key: K): Boolean
}

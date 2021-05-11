package interfaces

interface ITable<K : Comparable<K>, T> {
	fun add(data: T)
	fun find(firstKey: K, secondKey: K): List<T>
	fun remove(key: K)
	fun isEmpty(): Boolean
	fun size(): Int
}

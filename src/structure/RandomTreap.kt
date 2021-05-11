package structure

import interfaces.IRandomTreap
import java.lang.StrictMath.abs
import java.util.*

class RandomTreap<K : Comparable<K>, T> : IRandomTreap<K, T> {

	private var root: Node<K, T>? = null

	private class Node<K : Comparable<K>, T>(
		var key: K,
		var data: T
	) {
		var right: Node<K, T>? = null
		var left: Node<K, T>? = null
		val priority = abs(rand.nextInt())

		override fun toString(): String {
			return "Node{item=$data, priority=$priority, left=$left, right=$right}"
		}
	}

	companion object {
		private val rand: Random = Random()
	}

	override fun add(key: K, data: T) {
		root = add(root, Node(key, data))
	}

	override fun find(key: K): T? {
		var node = root
		while (node != null) {
			val compare = key.compareTo(node.key)
			node = when {
				compare < 0 -> node.left
				compare > 0 -> node.right
				else -> return node.data
			}
		}
		return null
	}

	override fun remove(key: K): Boolean {
		val result = contains(key)
		if (result) {
			root = remove(root, key)
		}
		return result
	}

	private fun add(node: Node<K, T>?, newNode: Node<K, T>): Node<K, T>? {
		if (node == null) return newNode

		val compare: Int = newNode.key.compareTo(node.key)

		if (compare < 0) {
			node.left = add(node.left, newNode)
			if (node.priority > node.left!!.priority) return rotateRight(node)
		} else if (compare > 0) {
			node.right = add(node.right, newNode)
			if (node.priority > node.right!!.priority) return rotateLeft(node)
		}
		return node
	}

	private fun rotateRight(node: Node<K, T>): Node<K, T>? {
		val leftNode = node.left
		node.left = leftNode?.right
		leftNode?.right = node
		return leftNode
	}

	private fun rotateLeft(node: Node<K, T>): Node<K, T>? {
		val rightNode = node.right
		node.right = rightNode?.left
		rightNode?.left = node
		return rightNode
	}

	private fun remove(node: Node<K, T>?, key: K): Node<K, T>? {
		if (node != null) {
			val compare: Int = key.compareTo(node.key)
			when {
				compare < 0 -> {
					node.left = remove(node.left, key)
				}
				compare > 0 -> {
					node.right = remove(node.right, key)
				}
				else -> {
					when {
						node.left == null -> {
							return node.right
						}
						node.right == null -> {
							return node.left
						}
						else -> {
							val first = first(node.right)
							node.data = first?.data!!
							node.key = first.key
							node.right = remove(node.right, node.key)
						}
					}
				}
			}
		}
		return node
	}

	operator fun contains(key: K): Boolean {
		var node = root
		while (node != null) {
			val compare = key.compareTo(node.key)
			node = when {
				compare < 0 -> node.left
				compare > 0 -> node.right
				else -> return true
			}
		}
		return false
	}

	fun maxDepth(): Int {
		return maxDepth(root)
	}

	private fun maxDepth(node: Node<K, T>?): Int {
		return if (node == null) 0 else {
			val leftDepth = maxDepth(node.left)
			val rightDepth = maxDepth(node.right)

			if (leftDepth > rightDepth) leftDepth + 1 else rightDepth + 1
		}
	}


	private fun first(searchNode: Node<K, T>?): Node<K, T>? {
		var node = searchNode
		while (node?.left != null) node = node.left
		return node
	}

	override fun toString(): String {
		return "Treap{root=$root}"
	}

}

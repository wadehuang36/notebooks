/**
 * from https://leetcode.com/problems/binary-tree-right-side-view/
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * ---------------------------------
 * The question is asking the first right node on each level
 * 1. use breadth frist search
 * 2. use a queue to store the node of next level
 * 3. put the last value of the queue to result for each loop
 **/

class Solution199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        var result = mutableListOf<Int>()

        if (root != null) {
            var queue = mutableListOf<TreeNode>(root)

            while (queue.isNotEmpty()) {
                // the last node is the first right node 
                result.add(queue.last().`val`)

                // put the children nodes to queue
                for (index in 1..queue.size) {
                    var node = queue.removeAt(0)
                    if (node.left != null) {
                        queue.add(node.left!!)
                    }

                    if (node.right != null) {
                        queue.add(node.right!!)
                    }
                }
            }
        }

        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// testing
fun test(inputs: List<Int?>, expect: List<Int>) {
    var root = buildTree(inputs)
    var actual = Solution199().rightSideView(root)

    println("actual: $actual, except:$expect, result:${expect.toIntArray().contentEquals(actual.toIntArray())}")
}

fun buildTree(inputs: List<Int?>): TreeNode? {
    var tree = mutableListOf<TreeNode>()

    for (index in 0..inputs.size - 1) {
        var node = TreeNode(inputs[index] ?: 0)
        tree.add(node)

        if (index > 0) {
            var parentIndex = Math.ceil(index.toDouble() / 2).toInt() - 1
            var parent = tree[parentIndex]
            if (index % 2 == 1) {
                parent.left = node
            } else {
                parent.right = node
            }
        }
    }

    return tree.firstOrNull()
}

fun main() {
    test(listOf(1, 2), listOf(1, 2))
    test(listOf(1, 2, 3, null, 5, null, 4), listOf(1, 3, 4))
}


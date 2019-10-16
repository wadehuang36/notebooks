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
        val result = mutableListOf<Int>()

        if (root != null) {
            val queue = mutableListOf<TreeNode>(root)

            while (queue.isNotEmpty()) {
                // the last node is the first right node 
                result.add(queue.last().`val`)

                // put the children nodes to queue
                for (index in 1..queue.size) {
                    val node = queue.removeAt(0)
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
    val start = System.currentTimeMillis()

    val root = buildTree(inputs)
    val actual = Solution199().rightSideView(root)

    val spend = System.currentTimeMillis() - start
    println("spend: $spend ms, result:${actual.contentEquals(expect)}, actual: $actual, except:$expect")
}

fun buildTree(inputs: List<Int?>): TreeNode? {
    val tree = mutableListOf<TreeNode>()

    for (index in 0..inputs.size - 1) {
        val node = TreeNode(inputs[index] ?: 0)
        tree.add(node)

        if (index > 0) {
            val parentIndex = Math.ceil(index.toDouble() / 2).toInt() - 1
            val parent = tree[parentIndex]
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


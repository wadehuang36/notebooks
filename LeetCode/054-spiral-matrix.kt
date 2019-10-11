/**
 * https://leetcode.com/problems/spiral-matrix/
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 **/

class Solution054 {
    companion object {
        const val LeftToRight = 0
        const val TopToBottom = 1
        const val RightToLeft = 2
        const val BottomToTop = 3
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()

        if (matrix.isEmpty()) {
            return result
        }

        var ti = 0
        var bi = matrix.size - 1
        var li = 0
        var ri = matrix[0].size - 1

        var direction = LeftToRight

        while (ti <= bi && li <= ri) {
            when (direction) {
                LeftToRight -> {
                    for (i in li..ri) {
                        result.add(matrix[ti][i])
                    }
                    ti++
                }

                TopToBottom -> {
                    for (i in ti..bi) {
                        result.add(matrix[i][ri])
                    }
                    ri--
                }

                RightToLeft -> {
                    for (i in ri downTo li) {
                        result.add(matrix[bi][i])
                    }
                    bi--
                }

                BottomToTop -> {
                    for (i in bi downTo ti) {
                        result.add(matrix[i][li])
                    }
                    li++
                }
            }

            direction = (direction + 1) % 4
        }

        return result
    }
}

// testing
fun test(input: Array<IntArray>, expect: List<Int>) {
    val start = System.currentTimeMillis()
    val actual = Solution054().spiralOrder(input)

    val spend = System.currentTimeMillis() - start
    println("spend: $spend ms, result:${actual.contentEquals(expect)}, actual: $actual, expect: $expect")
}

fun main() {
    test(
        arrayOf(),
        listOf()
    )
    test(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        ),
        listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
    )
    test(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        ),
        listOf(1, 2, 3, 6, 5, 4)
    )

    test(
        arrayOf(
            intArrayOf(1, 2, 3)
        ),
        listOf(1, 2, 3)
    )
}


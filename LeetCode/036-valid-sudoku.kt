/**
 * from https://leetcode.com/problems/valid-sudoku/
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 **/

class Solution036 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // use there three arrays to store the check history
        // 9 rows, cols and boxes
        val rows = Array(9) { _ -> BooleanArray(10) }
        val cols = Array(9) { _ -> BooleanArray(10) }
        val boxes = Array(9) { _ -> BooleanArray(10) }

        for (ri in 0..8) {
            for (ci in 0..8) {
                val value = board[ri][ci]
                if (value == '.') {
                    continue
                }

                val num = value - '0'
                // calculate cell in which box, the box index is like
                // 0 1 2
                // 3 4 5
                // 6 7 8
                val bi = (ci / 3) + (3 * (ri / 3))
                val row = cols[ri]
                val col = rows[ci]
                val box = boxes[bi]

                // check number is used or not
                if (row[num] || col[num] || box[num]) {
                    return false
                }

                row[num] = true
                col[num] = true
                box[num] = true
            }
        }

        return true
    }
}

// testing
fun test(board: Array<CharArray>, expect: Boolean) {
    val start = System.currentTimeMillis()
    val actual = Solution036().isValidSudoku(board)

    val spend = System.currentTimeMillis() - start
    println("spend: $spend ms, actual: $actual, expect: $expect")
}

fun main() {
    test(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        ),
        true
    )
}


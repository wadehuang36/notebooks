/**
 * from https://leetcode.com/problems/friends-of-appropriate-ages/
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.
 *
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 *
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 *
 * Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
 *
 * How many total friend requests are made?
 * ---------------------------------
 * 
 * 1. the soultion is mapping a map of age by first, for example [16,16] = [16] = 2
 * 2. the crawl the age from 0 to 120
 * 3. the check the same age, if count > 0, it true; total += count * (count - 1)
 * 4. check the ages below to meet the conidtion not(b > a)
 **/
class Solution825 {
    fun numFriendRequests(ages: IntArray): Int {
        var total = 0
        var ageMap = IntArray(121)

        for (age in ages) {
            ageMap[age] = ageMap[age] + 1
        }

        for (a in 1..120) {
            var countA = ageMap[a]

            if (countA == 0) {
                continue
            }

            // check the same age
            if (countA > 1 && hasFriendRequest(a, a)) {
                // println("a: $a, count: $countA")
                total += countA * (countA - 1)
            }

            // check the age below
            for (b in (a - 1) downTo 1) {
                var countB = ageMap[b]

                if (countB == 0) {
                    continue
                }

                if (hasFriendRequest(a, b)) {
                    // println("a: $a, b: $b, count:$countB")
                    total += countA * countB
                }
            }
        }

        return total
    }

    fun hasFriendRequest(a: Int, b: Int): Boolean {
        return !((b <= 0.5 * a + 7) || (b > 100 && a < 100))
    }
}

// testing
fun test(ages: IntArray, total: Int) {
    var actual = Solution825().numFriendRequests(ages)
    println("actual: $actual, except:$total, result:${actual == total}")
}

fun main(args: Array<String>) {
    test(intArrayOf(8, 24), 2)
    // test(intArrayOf(16, 16, 16), 6)
    // test(intArrayOf(18, 16, 17), 2)
    // test(intArrayOf(20, 30, 100, 110, 120), 3)
    test(intArrayOf(8, 85, 24, 85, 69), 4)
}


class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        val list = sizes.map { BusinessCard(it) }.toList()

        val maxOfMax = list.maxOf { it.max }
        val maxOfMin = list.maxOf { it.min }

        return maxOfMax * maxOfMin
    }
}

class BusinessCard(
    private val width: Int,
    private val length: Int
) {

    constructor(arr: IntArray): this(arr[0], arr[1])

    val max: Int
        get() {
            return this.width.coerceAtLeast(this.length)
        }

    val min: Int
        get() {
            return this.width.coerceAtMost(this.length)
        }
}

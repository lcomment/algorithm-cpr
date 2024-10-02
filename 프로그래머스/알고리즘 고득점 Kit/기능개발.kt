import java.util.*
import java.util.stream.IntStream

class Solution {

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val list: MutableList<Int> = ArrayList()
        var index = 0

        while (index < progresses.size) {
            val cal = (100 - progresses[index]) / speeds[index]
            val need = if ((100 - progresses[index]) % speeds[index] == 0) cal else cal + 1

            IntStream.range(index, progresses.size).forEach { idx: Int -> progresses[idx] += need * speeds[idx] }

            var count = 0
            for (i in index until progresses.size) {
                when {
                    progresses[i] < 100 -> {
                        index = i
                        break
                    }
                    i == progresses.size - 1 -> {
                        index = i + 1
                        count++
                    }
                    else -> count++
                }
            }

            list.add(count)
        }

        return list.toIntArray()
    }
}

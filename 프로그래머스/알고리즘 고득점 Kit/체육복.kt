import java.util.*

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var count = n - lost.size

        Arrays.sort(reserve)
        Arrays.sort(lost)

        for (i in lost.indices) {
            for (j in reserve.indices) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1
                    reserve[j] = -1
                    count++
                    break
                }
            }
        }

        for (i in lost.indices) {
            if (lost[i] == -1) {
                continue
            }

            for (j in reserve.indices) {
                if (reserve[j] == -1) {
                    continue
                }

                if (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    reserve[j] = -1
                    count++
                    break
                }
            }
        }

        return count
    }
}

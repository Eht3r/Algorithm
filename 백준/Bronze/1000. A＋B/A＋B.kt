import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    System.`in`.bufferedReader().use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            val nums = br.readLine().split(" ").map { it.toInt() }
            bw.write((nums[0] + nums[1]).toString())
            bw.flush()
        }
    }
}

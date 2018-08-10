package test1


/**
 * 简单案例
 * 不使用算法1加到100和使用算法1加到100的区别
 */
fun main(args: Array<String>) {
    initial()//不使用算法
    arithmetic()//使用算法
}

/**
 * 使用算法
 */
private fun arithmetic() {
    var sum: Int = 0//执行1次
    val n = 100//执行1次
    sum = (1 + n) * n / 2//执行1次
    println("$sum")//执行1次
}

/**
 * 不使用算法
 */
private fun initial() {
    var sum: Int = 0//执行1次
    for (i in 1..100) {
        sum += i//执行了100次
    }
    println("$sum")//执行1次
}

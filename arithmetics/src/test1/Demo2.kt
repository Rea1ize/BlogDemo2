package test1

/**
 * 简单案例
 * 不使用算法1加到十亿和使用算法1加到十亿的区别，看控制台的程序运行时间
 */
fun main(args: Array<String>) {
    initial()//不使用算法
    arithmetic()//使用算法
}
/**
 * 使用算法
 */
private fun arithmetic() {
    //使用高斯算法
    val startTime = System.currentTimeMillis()   //获取开始时间
    var sum= 0L//执行1次
    val n = 1000000000000//执行1次
    sum = (1 + n) * n / 2//执行1次
    println("$sum")
    val endTime = System.currentTimeMillis() //获取结束时间
    System.out.println("程序运行时间： " + (endTime - startTime) + "ms")
}

/**
 * 不使用算法
 */
private fun initial() {
//普通循环
    val startTime = System.currentTimeMillis()   //获取开始时间毫秒值
    var sum = 0L//总数
    for (i in 1..1000000000) {//遍历，从1加到10亿
        sum += i//sum和i相加
    }
    println("$sum")//输出
    val endTime = System.currentTimeMillis() //获取结束时间毫秒值
    System.out.println("程序运行时间： " + (endTime - startTime) + "ms")
}

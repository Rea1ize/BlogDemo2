package test2

/**
 * 线性阶
 */
fun main(args: Array<String>) {
    //输入字符串变量
    val n = readLine()
    /**
     * 1，线性阶
     * 将字符串n通过toInt方法转化为Int类型
     * 而后面的?:1看起来是三元运算符，其实不是的，这是Kotlin的ELvis操作符。
     * 它的作用是当检测到n变量的值为空时，使用默认值1
     */
    c(n?.toInt() ?: 1)//常量阶1
}

fun c(n: Int) {
    //循环，从1到n
    for (i in 1..n) {
        println(i)//执行次数是1
    }
}



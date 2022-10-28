fun main(args: Array<String>) {
    println("Insira o binário:");
    val input = readLine()

    print("This the decimal ${calc(Integer.parseInt(input))}");
}

fun calc(binary: Int): Int {
    val length: Int = binary.toString().length
    var result: Int = 0

    for (i in 0 until length) {
        result += Integer.parseInt(binary.toString().reversed()[i].toString()) * calcExponential(2, i)
    }

    return result
}

fun calcExponential(base: Int, exponent: Int): Int {
    var result: Int = base
    if(exponent == 0){
        result = 1
    }else{
        for (i in 1 until exponent) {
            result *= base
        }
    }
    return result
}
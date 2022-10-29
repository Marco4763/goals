package ao.marco.bin2dec.resources

class Calculator {

    fun binary(binary: Int): Int {
        val length: Int = binary.toString().length
        var result: Int = 0

        for (i in 0 until length) {
            result += Integer.parseInt(binary.toString().reversed()[i].toString()) * calcExponential(2, i)
        }

        return result
    }

    fun decimal(decimal: Int) : Int{
        var result: Int = decimal
        var rest: String = ""
        while (result != 0){
            var calc = result/2
            var math = result-(calc*2)
            result = calc
            rest += "$math"
        }

        return Integer.parseInt(rest.reversed())
    }

    private fun calcExponential(base: Int, exponent: Int): Int {
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
}
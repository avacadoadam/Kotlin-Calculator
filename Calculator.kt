import java.util.*

// Main function
fun main(args: Array<String>) {
    val calc = Calculator()
    calc.GetOption()
}


class Calculator {

    var Total: Int = 0
    //Takes in User input and process the Strin
    fun GetOption() {
        val scan = Scanner(System.`in`)
        println("Type in your problem")
        val equation: String = scan.nextLine()
        //Spilts the String into parts
        val nodes = equation.split(" ")
//        Theses parts are then feed into IsNumber and IsOperator to determine what the user whats
        Total += PerformOperation(
                IsNumber(Node = nodes[0]),
                IsOperator(Node = nodes[1]),
                IsNumber(Node = nodes[2]))
        //When the maths problem is identified PerformOperation execute it and return the result
        println(Total)
        Restart()  //Then restarts
    }

    fun IsNumber(Node: String): Int {
        try {
            val Number: Int = Integer.parseInt(Node.trim())
            return Number
        } catch (e: Exception) {
            Restart("Only Numbers")
        }
        return 0
    }

    //Function will return a lambda depending on the operation the user wants
    fun IsOperator(Node: String): (num1: Int, num2: Int) -> Int {

        if (Node.equals("+")) {
            return { a: Int, b: Int -> a + b }
        }
        if (Node.equals("-")) {
            return { a: Int, b: Int -> a - b }
        }
        if (Node.equals("*")) {
            return { a: Int, b: Int -> a * b }
        }
        if (Node.equals("/")) {
            return { a: Int, b: Int -> a / b }
        }
        Restart("Incorrect Operator")
        return { a: Int, b: Int -> a + b }
    }

    //If error occurs restart
    fun Restart(Error: String = "") {
        Total = 0
        println(Error)
        GetOption()
    }

    //Takes in the math operation the user wanted and the values to be performed on and then returns result
    fun PerformOperation(a: Int, operation: (num1: Int, num2: Int) -> Int, b: Int): Int {
        return operation(a, b)
    }

}



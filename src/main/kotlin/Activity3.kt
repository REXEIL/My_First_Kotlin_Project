fun main () {
    while (true) {
        println("1.Add name ")
        val value_1 = 1
        println("2.Exit ")
        val value_2 = 2
        print("Enter num: ")
        val num = readLine()?.toIntOrNull() ?: 0
        val answer = String
        when (num) {
            value_1 -> {
                print("Enter Your Name: ")
                val name = readLine()

                print("Enter Your Age: ")
                val age = readLine()?.toIntOrNull() ?: 0

                if (age <= 0) {
                    println("INVALID AGE!")

                }else if (age in 1..17) {
                    println(" $name is Under Aged")

                } else if (age in 18..30) {
                    println("$name is a Young Adult")

                } else if (age in 31..59) {
                    println("$name is an Adult")

                } else {
                    println("$name is a Senior")
                }
            }

            value_2 -> {
                println("Are You sure you want to exit?")
                val answer : String? = readLine()
                if(answer.equals("yes"))
                {
                    break
                }else{
                    return
                }



            }
        }
    }
}
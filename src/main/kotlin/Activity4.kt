/*
This Program will ask the user first to proceed or exit on the program. Once Proceed,
it will show the available products (GIVEN), then the user will choose a product
and inputs total stocks, salable, and unsalable. The sum of salable and unsalable
stocks must coincide with the total stocks as it is the maximum or minimum range of input.
If not, the user will make an input again.
*/
fun main () {
    println("-----------------------------")
    println("WELCOME TO INVENTORY CHECKER!")
    println("-----------------------------")

    while (true) {
        println("1. PROCEED TO PRODUCTS")
        val value_1 = 1
        println("2. EXIT PROGRAM")
        val value_2 = 2
        print("PLEASE SELECT 1 OR 2: ")
        val choice = readLine()?.toIntOrNull() ?: 0
        println("-----------------------------")
        val answer = String
        if (choice < 1 || choice > 2) {
            println("INVALID SELECTION!")
            println("-----------------------------")
        }
        when (choice) {
            value_1 -> {
                    println("AVAILABLE PRODUCTS:\n" +
                            "1. Computer Monitor\n" +
                            "2. Computer Keyboard\n" +
                            "3. Computer Mouse\n" +
                            "4. Computer System Unit Case")
                print("PLEASE CHOOSE FROM PRODUCT 1-4: ")
                val product = readLine()?.toIntOrNull() ?: 0
                if (product < 1 || product > 4) {
                    println("-----------------------------")
                    println("INVALID PRODUCT CHOICE!")
                    println("-----------------------------")
                }
                if (product == 1) {
                    println("-----------------------------")
                    println("COMPUTER MONITOR INVENTORY")
                    println("TOTAL STOCKS AVAILABLE: ")
                    val stocks = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF SALABLE STOCKS: ")
                    val salable = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF UNSALABLE STOCKS: ")
                    val unsalable = readLine()?.toIntOrNull() ?: 0

                    if (salable + unsalable == stocks) {
                        println("-----------------------------")
                        println("There are " + salable + " Computer Monitors available and in GOOD CONDITION! \n" +
                                "There are " + unsalable + " Computer Monitors that WERE NOT SALABLE AND DAMAGED!")
                        println("-----------------------------")

                    } else {
                        println("-----------------------------")
                        println("PLEASE INPUT VALID COUNT ACCORDING TO YOUR AVAILABLE STOCKS!")
                        println("-----------------------------")
                    }
                }
                if (product == 2) {
                    println("-----------------------------")
                    println("COMPUTER KEYBOARD INVENTORY")
                    println("TOTAL STOCKS AVAILABLE: ")
                    val stocks = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF SALABLE STOCKS: ")
                    val salable = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF UNSALABLE STOCKS: ")
                    val unsalable = readLine()?.toIntOrNull() ?: 0

                    if (salable + unsalable == stocks) {
                        println("-----------------------------")
                        println("There are " + salable + " Computer Keyboards available and in GOOD CONDITION! \n" +
                                "There are " + unsalable + " Computer Keyboards that WERE NOT SALABLE AND DAMAGED!")
                        println("-----------------------------")

                    } else {
                        println("-----------------------------")
                        println("PLEASE INPUT VALID COUNT ACCORDING TO YOUR AVAILABLE STOCKS!")
                        println("-----------------------------")
                    }

                }
                if (product == 3) {
                    println("-----------------------------")
                    println("COMPUTER MOUSE INVENTORY")
                    println("TOTAL STOCKS AVAILABLE: ")
                    val stocks = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF SALABLE STOCKS: ")
                    val salable = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF UNSALABLE STOCKS: ")
                    val unsalable = readLine()?.toIntOrNull() ?: 0

                    if (salable + unsalable == stocks) {
                        println("-----------------------------")
                        println("There are " + salable + " Computer Mouse available and in GOOD CONDITION! \n" +
                                "There are " + unsalable + " Computer Mouse that WERE NOT SALABLE AND DAMAGED!")
                        println("-----------------------------")

                    } else {
                        println("-----------------------------")
                        println("PLEASE INPUT VALID COUNT ACCORDING TO YOUR AVAILABLE STOCKS!")
                        println("-----------------------------")
                    }

                }

                if (product == 4) {
                    println("-----------------------------")
                    println("COMPUTER SYSTEM UNIT CASE INVENTORY")
                    println("TOTAL STOCKS AVAILABLE: ")
                    val stocks = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF SALABLE STOCKS: ")
                    val salable = readLine()?.toIntOrNull() ?: 0
                    println("NUMBER OF UNSALABLE STOCKS: ")
                    val unsalable = readLine()?.toIntOrNull() ?: 0

                    if (salable + unsalable == stocks) {
                        println("-----------------------------")
                        println("There are " + salable + " Computer System Unit Case available and in GOOD CONDITION! \n" +
                                "There are " + unsalable + " Computer System Unit Case that were NOT SALABLE AND DAMAGED!")
                        println("-----------------------------")

                    } else {
                        println("-----------------------------")
                        println("PLEASE INPUT VALID COUNT ACCORDING TO YOUR AVAILABLE STOCKS!")
                        println("-----------------------------")
                    }
                }
            }
            value_2 -> {
                println("ARE YOU SURE YOU WANT TO EXIT? [Y/N]")
                val answer: String? = readLine()
                println("-----------------------------")
                if (answer != null) {
                    if (answer.get(0).uppercase() == "Y") {
                        println("THANK YOU AND GOD BLESS!")
                        break
                    } else {
                        continue
                    }
                }
            }
        }
    }
}

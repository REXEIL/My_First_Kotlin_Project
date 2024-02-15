fun main() {
    println("!!Student Grades!!")
    println("===================")

    print("ENTER THE NUMBER OF STUDENTS: ")
    var numberOfStudents: Int
    while (true) {
        try {
            numberOfStudents = readLine()?.toInt() ?: 0
            break
        } catch (e: NumberFormatException) {
            println("!!Pls Enter A Number!!")
            println("===================")
            print("Enter the Number of Students: ")
        }
    }
    println("===================")
    for (i in 1..numberOfStudents){
        print("Students Name $i: ")
        val name = readLine()
        println("ENTER YOUR GRADES IN THE GIVEN SUBJECT")
        print("English: ")
        val eg = readLine()?.toDouble()?: 0.0

        print("Mathematics: ")
        val mg = readLine()?.toDouble()?: 0.0

        print("Science: ")
        val sg = readLine()?.toDouble()?: 0.0

        print("Filipino: ")
        val fg = readLine()?.toDouble()?: 0.0

        val sum :Double = eg + mg + sg + fg
        val avg :Double = sum.toDouble() /4
        println("===================")
        println("Students Name: $name ")
        println("Your Total Average is: $avg ")
        println("===================")

    }
    print("Thanks")
}
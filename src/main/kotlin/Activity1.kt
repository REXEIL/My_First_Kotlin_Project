


fun main(){
for(i in 1..5) {
    println("Enter your First Name: ")
    var first = readLine()

    println("Enter your Middle Name: ")
    var mi = readLine()

    println("Enter your Last Name: ")
    var lastName = readLine()

    println("Enter your Age: ")
    var age = readLine()?.toInt() ?: 0


    println(" $first $mi. $lastName")
    println("$age")
}

}
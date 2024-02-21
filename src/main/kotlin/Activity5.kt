/*
This program will ask first if you will borrow a book or exit the program. If you borrow,
it will collect information like; Name, Year Level, Course, Book Name, and Books Availability.
If it is available, it will print a RECEIPT, with your information in it, and the date you
borrowed the book, then it will ask if you will add more, or exit the program.
 */

import com.sun.jdi.Value
import java.text.SimpleDateFormat
import java.util.Date

fun main() {
    println("====================================")
    println("WELCOME TO THE LIBRARY!")
    println("====================================")
    while (true) {
        println("1. Borrow a book")
        println("2. Exit")
        print("Enter your choice: ")
        val choice: Int = readln().toInt()

        if(choice < 1 || choice > 2){
            println("====================================")
            println("INVALID CHOICE!")
            println("====================================")
        }

        var name: String? = null
        var book: String? = null
        var year: String? = null
        var course: String? = null
        var option: String? = null
        var borrow: String? = null

        val dateBorrowed: Date = Date()

        val value_1 = 1
        val value_2 = 2

        when (choice) {

            value_1 -> {
                println("---------------------------")
                print("Enter your name: ")
                name = readLine().toString()
                println("---------------------------")
                print("Enter your Year level: ")
                year = readLine().toString()
                println("---------------------------")
                print("Enter your course: ")
                course = readLine().toString()
                println("---------------------------")
                print("Enter book name: ")
                book = readLine().toString()
                println("---------------------------")
                print("Is this available to borrow (Y or N): ")
                option = readLine().toString()

                borrow = if (option.get(0).uppercase() == "Y") "Yes" else "Not"

                if (option.get(0).uppercase() == "Y") {
                    println("====================================")
                    println("!YOUR RECEIPT!\n")
                    println("Borrower: $name")
                    println("Year Level: $year")
                    println("Course: $course")
                    println("Book: $book")
                    if (option == "y" || option == "Y" || option == "Yes" || option == "yes") {
                        println("Available: Yes")
                    }
                    println("Date borrowed: " + SimpleDateFormat("MMMMM d, yyyy").format(dateBorrowed))
                    println("====================================")
                    println("You want to add more? (Y/N): ")
                    val ans = readLine()
                    println("====================================")
                    if (ans == "Y" || ans == "Yes" || ans == "y" || ans == "yes") {
                        continue
                    } else {
                        print("Thank you and have a good day!")
                        break
                    }

                } else {
                    println("====================================")
                    println("We're very sorry Mr./Ms. $name.\n" +
                            "This book is not available at this moment.\n" +
                            "Please come again next time.")
                    println("====================================")
                }
            }

            value_2 -> {
                println("====================================")
                print("Are you sure you want to exit? (Y/N): ")
                val answer = readLine()
                if (answer != null) {
                    if (answer.get(0).uppercase() == "Y") {
                        println("====================================")
                        println("THANK YOU!")
                        break
                    } else {
                        println("====================================")
                        continue
                    }
                }
            }
        }
    }
}
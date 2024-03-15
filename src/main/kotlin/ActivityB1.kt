/*
Activity B:1
Implement a process where someone can borrow a book into Array Structure. Keep track of book borrowed,
and how long it can be borrowed.

GROUP MEMBERS:
GEPAYA, REXEIL
MAGSALAY, MELVIN
BALTAZAR, MARJORIE
SARAMOSING, ALDRIN
 */
/*
ABOUT THE PROGRAM
This Library program will ask the user to enter name of the borrower, choose a course and year level.
Then it will ask what book to borrow (GIVEN LIST OF BOOKS), and how many days do the borrower intended
to borrow the book.Once the book is borrowed, it will record all information of the borrower including
the date borrowed, due date, and the name of the book. It will also remove the book from the list of
available books. Once it is returned, it will also show up again as available book.
 */

import java.text.SimpleDateFormat
import java.util.*

data class Transaction(
    val borrower: String,
    val book: String,
    val days: Int,
    val borrowDate: Date,
    val dueDate: Date,
    val course: String,
    val yearLevel: Int
)

class Library {
    // Store transactions
    private val transactions = mutableListOf<Transaction>()
    private var availableBooks = listOf("ENGLISH", "MATH", "SCIENCE", "FILIPINO", "VALUES")
    private val availableCourses = listOf("BSIT", "BSBA", "BEED", "BSED", "BSHM")
    private val availableYearLevels = listOf(1, 2, 3, 4)
    private val dateFormat = SimpleDateFormat("MM-dd-yyyy")

    fun borrowBook() {
        // Check if there are available books
        if (availableBooks.isEmpty()) {
            println("===============================")
            println("All books have been borrowed.\n" +
                    "No books are available at the moment.")
            return
        }
        println("===============================")
        println("Enter borrower's name:")
        val borrower = readLine() ?: ""

        println("===============================")
        println("Course:")
        availableCourses.forEachIndexed { index, course ->
            println("${index + 1}. $course")
        }
        print("Choose a course: ")
        val courseChoice = readLine()?.toIntOrNull() ?: 0
        if (courseChoice < 1 || courseChoice > availableCourses.size) {
            println("===============================")
            println("Invalid choice.")
            return
        }
        val course = availableCourses[courseChoice - 1]

        println("===============================")
        println("Year Level:")
        availableYearLevels.forEachIndexed { index, year ->
            println("${index + 1}. Year $year")
        }
        print("Choose a year level: ")
        val yearChoice = readLine()?.toIntOrNull() ?: 0
        if (yearChoice < 1 || yearChoice > availableYearLevels.size) {
            println("===============================")
            println("Invalid choice.")
            return
        }
        val yearLevel = availableYearLevels[yearChoice - 1]

        println("===============================")
        println("Available Books:")
        availableBooks.forEachIndexed { index, book ->
            println("${index + 1}. $book" )
        }
        print("Choose a book to borrow: ")
        val bookChoice = readLine()?.toIntOrNull() ?: 0
        if (bookChoice < 1 || bookChoice > availableBooks.size) {
            println("===============================")
            println("Invalid choice.")
            return
        }
        val book = availableBooks[bookChoice - 1]

        println("===============================")
        print("Enter number of days to borrow: ")
        val days = readLine()?.toIntOrNull() ?: 0
        val borrowDate = Date()
        val dueDate = calculateDueDate(borrowDate, days)
        // Add transaction
        transactions.add(Transaction(borrower, book, days, borrowDate, dueDate, course, yearLevel))
        // Remove borrowed book from available books
        availableBooks = availableBooks.filter { it != book }
        println("===============================")
        println("${book.toUpperCase()} book has been borrowed by ${borrower.toUpperCase()} \n" +
                "NUMBER OF DAYS TO BE BORROWED: $days days \n" +
                "DATE BORROWED: ${dateFormat.format(borrowDate)} \n" +
                "DUE DATE: ${dateFormat.format(dueDate)}.\n" +
                "COURSE: $course\n" +
                "YEAR LEVEL: $yearLevel")
    }

    fun returnBook() {
        if (transactions.isEmpty()) {
            println("===============================")
            println("MAKE A TRANSACTION FIRST!")
            return
        }
        println("===============================")
        println("RETURNABLE BOOKS")
        transactions.forEachIndexed { index, transaction ->
            println("${index + 1}. ${transaction.book.toUpperCase()}\n" +
                    "   Borrowed by: ${transaction.borrower.toUpperCase()}\n" +
                    "   Date Borrowed: ${dateFormat.format(transaction.borrowDate)}\n" +
                    "   Due Date: ${dateFormat.format(transaction.dueDate)}\n" +
                    "   Course: ${transaction.course}\n" +
                    "   Year Level: ${transaction.yearLevel}")
            println()
        }
        println()
        print("Choose a book to return:")
        val choice = readLine()?.toIntOrNull() ?: 0

        if (choice < 1 || choice > transactions.size) {
            println("===============================")
            println("Invalid choice.")
            return
        }

        val transaction = transactions[choice - 1]
        println("===============================")
        println("'${transaction.book}' book returned by ${transaction.borrower.toUpperCase()}.")
        // Remove transaction from the list
        transactions.removeAt(choice - 1)
        // Add returned book back to available books
        availableBooks += transaction.book
    }

    fun showTransactions() {
        if (transactions.isEmpty()) {
            println("===============================")
            println("NO TRANSACTIONS RECORDED!")
            return
        }
        println("===============================")
        println("RECORDED TRANSACTIONS")
        // Display recorded transactions
        transactions.forEachIndexed { index, transaction ->
            println("${index + 1}. Borrower: ${transaction.borrower.toUpperCase()}\n" +
                    "   Book: ${transaction.book.toUpperCase()}\n" +
                    "   Number of Days: ${transaction.days}\n" +
                    "   Date Borrowed: ${dateFormat.format(transaction.borrowDate)}\n" +
                    "   Due Date: ${dateFormat.format(transaction.dueDate)}\n" +
                    "   Course: ${transaction.course}\n" +
                    "   Year Level: ${transaction.yearLevel}")
            println()
        }
    }
    fun showAvailableBooks() {
        println("===============================")
        println("AVAILABLE BOOKS")
        availableBooks.forEachIndexed { index, book ->
            println("${index + 1}. $book")
        }
    }

    private fun calculateDueDate(startDate: Date, days: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = startDate
        calendar.add(Calendar.DAY_OF_YEAR, days)
        return calendar.time
    }
}

fun main() {
    val library = Library()
    while (true) {
        println("===============================")
        println("W E L C O M E")
        println("1. BORROW A BOOK")
        println("2. AVAILABLE BOOKS")
        println("3. RETURN A BOOK")
        println("4. SHOW TRANSACTION RECORDS")
        println("5. EXIT")
        print("Enter your choice: ")
        when (readLine()?.toIntOrNull() ?: 0) {
            1 -> library.borrowBook()
            2 -> library.showAvailableBooks()
            3 -> library.returnBook()
            4 -> library.showTransactions()
            5 -> return
            else -> println("=============================== \n" +
                    "INVALID CHOICE!")
        }
    }
}

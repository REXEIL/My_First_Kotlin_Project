/*
ACTIVITY B:2
Implement a process where items are added to the grocery cart, shows item in the cart,
and total cost.
 */
/*
In this program, the user is asked to add products, its price, and quantity. The user can
see the added products in the cart with its total price. The user can also remove a product.
If checked-out, it will show all products added with their prices and will ask for cash
amount as payment. After paying, it will print a receipt with the change and prompts to ask
the user to proceed to another or exit.
 */

import java.util.*

data class Item(val name: String, val price: Double, val quantity: Int)

class Grocery {
    private val groceryCart = mutableListOf<Item>()
    val dateFormat = java.text.SimpleDateFormat("MM-dd-yyyy")

    fun addToCart() {
        while (true) {
            println("===============================")
            println("1. ADD PRODUCTS")
            println("2. VIEW CART")
            println("3. REMOVE PRODUCT")
            println("4. CHECKOUT")
            println("5. EXIT")
            print("Enter your choice: ")
            val input = readLine()

            when (input) {
                "1" -> addProduct()
                "2" -> {
                    if (groceryCart.isEmpty()) {
                        println("===============================")
                        println("No items in the cart.")
                    } else {
                        println("===============================")
                        println("ITEMS IN THE CART")
                        println("===============================")
                        viewCart()
                    }
                }
                "3" ->{
                    if(groceryCart.isEmpty()){
                        println("===============================")
                        println("No items in the cart. Add first.")
                    }else {
                        println("===============================")
                        println("SELECT ITEMS TO REMOVE FROM THE CART")
                        println("===============================")
                        removeFromCart()
                    }
                }
                "4" -> {
                    if (groceryCart.isEmpty()) {
                        println("===============================")
                        println("No items in the cart. Cannot proceed to checkout.")
                    } else {
                        checkout()
                        println("===============================")
                        print("Press [1] to CONTINUE or [2] to EXIT: ")
                        val choice = readLine()
                        if (choice == "2") {
                            return
                        }
                    }
                }
                "5" -> {
                    println("===============================")
                    println("Thank you for shopping with us!")
                    println("===============================")
                    return
                }
                else -> {
                    println("===============================")
                    println("Invalid choice! Please enter a number from [1-4]")
                }
            }
        }
    }

    private fun addProduct() {
        println("===============================")
        print("Enter the name of the product: ")
        val name = readLine()

        if (name != null) {
            println("===============================")
            var price: Double
            while (true) {
                print("Enter the price of ${name.toUpperCase()}: Php")
                price = readLine()?.toDoubleOrNull() ?: continue
                if (price > 0) {
                    break
                } else {
                    println("===============================")
                    println("Invalid price! Please enter a valid price greater than 0.")
                }
            }
            println("===============================")
            var quantity: Int
            while (true) {
                print("Enter the quantity of ${name.toUpperCase()}: ")
                quantity = readLine()?.toIntOrNull() ?: continue
                if (quantity > 0) {
                    break
                } else {
                    println("===============================")
                    println("Invalid quantity! Please enter a valid quantity greater than 0.")
                }
            }

            println("===============================")
            println("${name.toUpperCase()} is Successfully Added to Cart!")

            val item = Item(name, price, quantity)
            groceryCart.add(item)
        }
    }

     private fun checkout() {
        println("===============================")
        println("PROCEEDING TO CHECKOUT...")
        println("===============================")
        viewCart()

        var cashAmount: Double
        while (true) {
            println("===============================")
            print("Enter cash amount: Php")
            cashAmount = readLine()?.toDoubleOrNull() ?: continue
            if (cashAmount < calculateTotalPrice()) {
                println("===============================")
                println("INSUFFICIENT CASH AMOUNT!")
            } else {
                break
            }
        }

        val totalPrice = calculateTotalPrice()
        val change = cashAmount - totalPrice
        println("===============================")
        println("Date: ${dateFormat.format(Date())}")
        println("Cash rendered: Php$cashAmount")
        println("Total price: Php$totalPrice")
        println("Change: Php$change")
        println("===============================")
        println("Thank you for shopping with us!")

        groceryCart.clear()
    }

    private fun calculateTotalPrice(): Double {
        var totalPrice = 0.0
        for (item in groceryCart) {
            totalPrice += item.price * item.quantity
        }
        return totalPrice
    }

    private fun removeFromCart(){
        viewCart()

        println("===============================")
        print("Select the number of the item to remove\n" +
                "or Press [0] to cancel: ")
        val input = readLine()?.toIntOrNull() ?: return

        if (input in 1..groceryCart.size) {
            val removedItem = groceryCart.removeAt(input - 1)
            println("===============================")
            println("${removedItem.name.toUpperCase()} removed from the cart.")
        } else if (input != 0) {
            println("===============================")
            println("Invalid input. No item removed.")
        }
    }

    private fun viewCart() {
        if (groceryCart.isEmpty()) {
            println("No items in the cart.")
            return
        }

        var totalPrice = 0.0
        for ((index, item) in groceryCart.withIndex()) {
            val itemTotalPrice = item.price * item.quantity
            println("${index + 1}. ${item.name.toUpperCase()}\n" +
                    "   Price: Php${item.price}\n" +
                    "   Quantity: ${item.quantity}\n" +
                    "   Total Price: Php$itemTotalPrice")
            println()
            totalPrice += itemTotalPrice
        }
        println("===============================")
        println("Overall Total Price: Php$totalPrice")
    }
}

fun main() {
    val grocery = Grocery()
    println("WELCOME TO OUR STORE!")
    grocery.addToCart()
}

fun main(){
    print("ENTER FIRST STRING: ")
    val string1 = readLine()!!

    print("ENTER SECOND STRING: ")
    val string2 = readLine()!!

    var ctr1 : Int = 0
    print("UNIQUE CHARACTERS FROM STRING 1 IS/ARE: ")
    for(char in string1){
        if(string1.count {it == char} == 1){
            print("$char, ")
            ctr1++
        }
    }
    println()

    var ctr2 : Int = 0
    print("UNIQUE CHARACTERS FROM STRING 2 IS/ARE: ")
    for(char in string2){
        if(string2.count {it == char} == 1){
            print("$char, ")
            ctr2++
        }
    }
    println()

    print("UNIQUE CHARACTERS FROM BOTH STRINGS IS/ARE: ")
    for(char in string1){
        if(string2.count {it == char} == 0 && string1.count {it == char} == 1){
            print("$char, ")
        }
    }
    for(char in string2){
        if(string1.count {it == char} == 0 && string2.count {it == char} == 1){
            print("$char, ")
        }
    }
    println()

    print("NUMBER OF NOT UNIQUE CHARACTERS FROM BOTH STRINGS: ")
    val count1 : Int = string1.length - ctr1
    val count2 : Int = string2.length - ctr2
    val result : Int = count1 + count2
    print("$result")
}
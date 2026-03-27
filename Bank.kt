import java.util.*

data class Account(
    val accNo: Int,
    var name: String,
    var balance: Double
)

class Bank {
    private val accounts = mutableListOf<Account>()

    fun createAccount(account: Account) {
        accounts.add(account)
        println("Account created successfully!")
    }

    fun viewAccounts() {
        if (accounts.isEmpty()) {
            println("No accounts found.")
        } else {
            println("\n--- Account List ---")
            for (acc in accounts) {
                println("AccNo: ${acc.accNo}, Name: ${acc.name}, Balance: ${acc.balance}")
            }
        }
    }

    fun deposit(accNo: Int, amount: Double) {
        val acc = accounts.find { it.accNo == accNo }
        if (acc != null) {
            acc.balance += amount
            println("Deposit successful! New Balance: ${acc.balance}")
        } else {
            println("Account not found.")
        }
    }

    fun withdraw(accNo: Int, amount: Double) {
        val acc = accounts.find { it.accNo == accNo }
        if (acc != null) {
            if (acc.balance >= amount) {
                acc.balance -= amount
                println("Withdrawal successful! New Balance: ${acc.balance}")
            } else {
                println("Insufficient balance!")
            }
        } else {
            println("Account not found.")
        }
    }

    fun searchAccount(accNo: Int) {
        val acc = accounts.find { it.accNo == accNo }
        if (acc != null) {
            println("Found: $acc")
        } else {
            println("Account not found.")
        }
    }

    fun deleteAccount(accNo: Int) {
        val removed = accounts.removeIf { it.accNo == accNo }
        if (removed) println("Account deleted.")
        else println("Account not found.")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val bank = Bank()

    while (true) {
        println("\n--- Bank Management System ---")
        println("1. Create Account")
        println("2. View Accounts")
        println("3. Deposit")
        println("4. Withdraw")
        println("5. Search Account")
        println("6. Delete Account")
        println("7. Exit")
        print("Enter choice: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Enter Account No: ")
                val accNo = scanner.nextInt()
                scanner.nextLine()

                print("Enter Name: ")
                val name = scanner.nextLine()

                print("Enter Initial Balance: ")
                val balance = scanner.nextDouble()

                bank.createAccount(Account(accNo, name, balance))
            }

            2 -> bank.viewAccounts()

            3 -> {
                print("Enter Account No: ")
                val accNo = scanner.nextInt()
                print("Enter Amount: ")
                val amount = scanner.nextDouble()
                bank.deposit(accNo, amount)
            }

            4 -> {
                print("Enter Account No: ")
                val accNo = scanner.nextInt()
                print("Enter Amount: ")
                val amount = scanner.nextDouble()
                bank.withdraw(accNo, amount)
            }

            5 -> {
                print("Enter Account No: ")
                val accNo = scanner.nextInt()
                bank.searchAccount(accNo)
            }

            6 -> {
                print("Enter Account No: ")
                val accNo = scanner.nextInt()
                bank.deleteAccount(accNo)
            }

            7 -> {
                println("Thank you!")
                break
            }

            else -> println("Invalid choice!")
        }
    }
}
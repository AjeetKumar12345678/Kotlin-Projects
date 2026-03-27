import java.util.*

data class Patient(val id: Int, val name: String, val age: Int, val disease: String)

class Hospital {
    private val patients = mutableListOf<Patient>()

    fun addPatient(patient: Patient) {
        patients.add(patient)
        println("Patient added successfully!")
    }

    fun viewPatients() {
        if (patients.isEmpty()) {
            println("No patients found.")
        } else {
            println("\n--- Patient List ---")
            for (p in patients) {
                println("ID: ${p.id}, Name: ${p.name}, Age: ${p.age}, Disease: ${p.disease}")
            }
        }
    }

    fun searchPatient(id: Int) {
        val patient = patients.find { it.id == id }
        if (patient != null) {
            println("Found: $patient")
        } else {
            println("Patient not found.")
        }
    }

    fun deletePatient(id: Int) {
        val removed = patients.removeIf { it.id == id }
        if (removed) println("Patient deleted.")
        else println("Patient not found.")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val hospital = Hospital()

    while (true) {
        println("\n--- Hospital Management System ---")
        println("1. Add Patient")
        println("2. View Patients")
        println("3. Search Patient")
        println("4. Delete Patient")
        println("5. Exit")
        print("Enter choice: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Enter ID: ")
                val id = scanner.nextInt()
		scanner.nextLine()
                print("Enter Name: ")
                val name = scanner.nextLine()
                print("Enter Age: ")
                val age = scanner.nextInt()
		scanner.nextLine()
                print("Enter Disease: ")
                val disease = scanner.nextLine()
                hospital.addPatient(Patient(id, name, age, disease))
            }
            2 -> hospital.viewPatients()
            3 -> {
                print("Enter Patient ID: ")
                val id = scanner.nextInt()
                hospital.searchPatient(id)
            }
            4 -> {
                print("Enter Patient ID: ")
                val id = scanner.nextInt()
                hospital.deletePatient(id)
            }
            5 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid choice!")
        }
    }
}
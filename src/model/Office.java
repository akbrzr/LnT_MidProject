package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Office {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public Office() {
        super();
        this.employees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
    }

    public void viewData() {
        // Sort employees by name
        Collections.sort(employees, Comparator.comparing(Employee::getName));

        // Display data horizontally
        System.out.println("No | Kode Karyawan | Nama Karyawan | Jenis Kelamin  | Jabatan    | Gaji");
        int counter = 1;
        for (Employee employeeToDisplay : employees) {
            System.out.printf("%-3d| %-14s| %-15s| %-14s| %-11s| %.2f%n", counter++,
                    employeeToDisplay.getId(),
                    employeeToDisplay.getName(),
                    employeeToDisplay.getGender(),
                    employeeToDisplay.getPosition(),
                    employeeToDisplay.getSalary());
        }
    }

    public void updateData() {
        // Display data
        viewData();

        // Input number of employee to update
        System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
        int employeeIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (employeeIndex < 1 || employeeIndex > employees.size()) {
            System.out.println("Nomor urutan tidak valid.");
            return;
        }

        // Input new employee details
        System.out.print("Input nama karyawan [>= 3] (Input 0 to keep existing): ");
        String name = scanner.nextLine();
        if (name.equals("0")) {
            // Keep the existing name
            name = employees.get(employeeIndex - 1).getName();
        }

        System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) (Input 0 to keep existing): ");
        String gender = scanner.nextLine();
        if (gender.equals("0")) {
            // Keep the existing gender
            gender = employees.get(employeeIndex - 1).getGender();
        }

        System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) (Input 0 to keep existing): ");
        String position = scanner.nextLine();
        if (position.equals("0")) {
            // Keep the existing position
            position = employees.get(employeeIndex - 1).getPosition();
        } else {
            double salary;
			// Check if user wants to update salary
            if (position.equals("0")) {
                // Keep the existing salary based on the employee's position
                salary = employees.get(employeeIndex - 1).getSalary();
            } else {
                // Set salary based on position
                salary = calculateSalary(position);
            }
        }

        // Update employee data
        Employee employeeToUpdate = employees.get(employeeIndex - 1);
        employeeToUpdate.setName(name.length() >= 3 ? name : employeeToUpdate.getName());
        employeeToUpdate.setGender(gender);
        employeeToUpdate.setPosition(position);

        System.out.println("Berhasil mengupdate karyawan dengan id " + employeeToUpdate.getId());
        System.out.println("ENTER to return");
        scanner.nextLine(); // Wait for ENTER
    }

    // Method to calculate salary based on position
    private double calculateSalary(String position) {
        switch (position.toLowerCase()) {
            case "manager":
                return 8000000;
            case "supervisor":
                return 6000000;
            case "admin":
                return 4000000;
            default:
                System.out.println("Invalid position specified.");
                return 0;
        }
    }

    
    public void deleteEmployee() {
        // Display data
        viewData();

        // Input number of employee to delete
        System.out.print("Input nomor karyawan yang ingin dihapus: ");
        int employeeIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (employeeIndex < 1 || employeeIndex > employees.size()) {
            System.out.println("Nomor urutan tidak valid.");
            return;
        }

        // Get the employee to delete
        Employee employeeToDelete = employees.get(employeeIndex - 1);
        String deletedEmployeeId = employeeToDelete.getId();

        // Remove the employee from the list
        employees.remove(employeeIndex - 1);

        System.out.println("Karyawan dengan kode " + deletedEmployeeId + " berhasil dihapus");
    }

}




package main;

import model.Employee;
import model.Office;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        Office kantor = new Office();

        boolean flag = true;

        while (flag) {
            System.out.println("+=================+");
            System.out.println("|Menu:            |");
            System.out.println("+=================+");
            System.out.println("|1. Insert Data   |");
            System.out.println("|2. View Data     |");
            System.out.println("|3. Update Data   |");
            System.out.println("|4. Delete Data   |");
            System.out.println("|5. Exit          |");
            System.out.println("+=================+");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    masukkanDataKaryawan(kantor, masukan);
                    break;
                case 2:
                    kantor.lihatData();
                    break;
                case 3:
                    kantor.perbaruiData();
                    break;
                case 4:
                    kantor.hapusKaryawan();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        masukan.close();
    }

    private static void masukkanDataKaryawan(Office kantor, Scanner masukan) {
        System.out.print("Masukkan nama karyawan [>= 3]: ");
        String nama = masukan.nextLine();

        System.out.print("Masukkan jenis kelamin [Laki-laki | Perempuan] (Huruf Besar): ");
        String jenisKelamin = masukan.nextLine();

        System.out.print("Masukkan jabatan [Manager | Supervisor | Admin] (Huruf Besar): ");
        String jabatan = masukan.nextLine();

        Employee karyawanBaru = new Employee(nama, jenisKelamin, jabatan);
        kantor.tambahKaryawan(karyawanBaru);

        System.out.println("Karyawan berhasil ditambahkan.");
    }
}
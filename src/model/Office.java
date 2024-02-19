package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Office {
    private ArrayList<Employee> karyawan;
    private Scanner inputScanner;

    public Office() {
        super();
        this.karyawan = new ArrayList<>();
        this.inputScanner = new Scanner(System.in);
    }

    public void tambahKaryawan(Employee karyawanBaru) {
        karyawan.add(karyawanBaru);
    }

    public void lihatData() {
        Collections.sort(karyawan, Comparator.comparing(Employee::getNama));

        System.out.println("No | Kode Karyawan | Nama Karyawan | Jenis Kelamin  | Posisi      | Gaji");
        int counter = 1;
        for (Employee karyawanTampil : karyawan) {
            System.out.printf("%-3d| %-14s| %-15s| %-14s| %-11s| %.2f%n", counter++,
                    karyawanTampil.getIdKaryawan(),
                    karyawanTampil.getNama(),
                    karyawanTampil.getJenisKelamin(),
                    karyawanTampil.getPosisi(),
                    karyawanTampil.getGaji());
        }
    }

    public void perbaruiData() {
        lihatData();

        System.out.print("Masukkan nomor urutan karyawan yang ingin diperbarui: ");
        int indeksKaryawan = inputScanner.nextInt();
        inputScanner.nextLine();

        if (indeksKaryawan < 1 || indeksKaryawan > karyawan.size()) {
            System.out.println("Nomor urutan tidak valid.");
            return;
        }

        System.out.print("Masukkan nama karyawan [>= 3] (Masukkan 0 untuk mempertahankan yang ada): ");
        String nama = inputScanner.nextLine();
        if (nama.equals("0")) {
            nama = karyawan.get(indeksKaryawan - 1).getNama();
        }

        System.out.print("Masukkan jenis kelamin [Laki-laki | Perempuan] (Huruf Besar) (Masukkan 0 untuk mempertahankan yang ada): ");
        String jenisKelamin = inputScanner.nextLine();
        if (jenisKelamin.equals("0")) {
            jenisKelamin = karyawan.get(indeksKaryawan - 1).getJenisKelamin();
        }

        System.out.print("Masukkan posisi [Manager | Supervisor | Admin] (Huruf Besar) (Masukkan 0 untuk mempertahankan yang ada): ");
        String posisi = inputScanner.nextLine();
        if (posisi.equals("0")) {
            posisi = karyawan.get(indeksKaryawan - 1).getPosisi();
        }

        Employee karyawanToUpdate = karyawan.get(indeksKaryawan - 1);
        karyawanToUpdate.setNama(nama.length() >= 3 ? nama : karyawanToUpdate.getNama());
        karyawanToUpdate.setJenisKelamin(jenisKelamin);
        karyawanToUpdate.setPosisi(posisi);

        System.out.println("Berhasil memperbarui karyawan dengan kode " + karyawanToUpdate.getIdKaryawan());
        System.out.println("ENTER untuk kembali");
        inputScanner.nextLine();
    }

    public void hapusKaryawan() {
        lihatData();

        System.out.print("Masukkan nomor karyawan yang ingin dihapus: ");
        int indeksKaryawan = inputScanner.nextInt();
        inputScanner.nextLine();

        if (indeksKaryawan < 1 || indeksKaryawan > karyawan.size()) {
            System.out.println("Nomor urutan tidak valid.");
            return;
        }

        Employee karyawanToDelete = karyawan.get(indeksKaryawan - 1);
        String idKaryawanDihapus = karyawanToDelete.getIdKaryawan();

        karyawan.remove(indeksKaryawan - 1);

        System.out.println("Karyawan dengan kode " + idKaryawanDihapus + " berhasil dihapus");
    }
}

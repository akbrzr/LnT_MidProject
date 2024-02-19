package model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Employee {
    private String idKaryawan;
    private String nama;
    private String jenisKelamin;
    private String posisi;
    private double gaji;
    private static final String ABJAD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int digit = 4;
    private static final int huruf = 2;
    private static final Set<String> idTerpakai = new HashSet<>();

    public Employee(String nama, String jenisKelamin, String posisi) {
        super();
        this.idKaryawan = generateId();
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.posisi = posisi;
        setGajiBerdasarkanPosisi(posisi);
    }

    private String generateId() {
        String idBaru;
        do {
            idBaru = generateRandomId();
        } while (idTerpakai.contains(idBaru));

        idTerpakai.add(idBaru);
        return idBaru;
    }

    private String generateRandomId() {
        StringBuilder pembangunId = new StringBuilder();

        for (int i = 0; i < huruf; i++) {
            char hurufAcak = ABJAD.charAt(new Random().nextInt(ABJAD.length()));
            pembangunId.append(hurufAcak);
        }

        for (int i = 0; i < digit; i++) {
            int angkaAcak = new Random().nextInt(10);
            pembangunId.append(angkaAcak);
        }

        return pembangunId.toString();
    }

    private void setGajiBerdasarkanPosisi(String posisi) {
        switch (posisi.toLowerCase()) {
            case "manager":
                this.gaji = 8000000;
                break;
            case "supervisor":
                this.gaji = 6000000;
                break;
            case "admin":
                this.gaji = 4000000;
                break;
            default:
                System.out.println("Posisi yang dimasukkan tidak valid.");
                break;
        }
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
        setGajiBerdasarkanPosisi(posisi);
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
}

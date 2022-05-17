package com.rizal.utsa.ticketbox.model;

import android.util.Pair;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tiket {
    public void setKota(String kota) {
        this.kota = kota;
    }

    public enum Pembayaran {
        TRANSFER_BANK,
        KARTU_KREDIT
    }
    public static List<String> listKotaKonser = Arrays.asList("Malang", "Jakarta", "Bali", "Surabaya");
    private Map<Konser, Integer> listKonser = new HashMap<>();
    private LocalDateTime tanggalBeli;
//    private List<String> listKota = new ArrayList<>();
    private String kota;
    private String noID;
    private String jenisID;
    private String namaPembeli;
    private String emailPembeli;
    private String telpPembeli;
    private String alamatPembeli;
    private Pembayaran pembayaranPembeli;
    private int jmlhTransfer;
    private LocalDateTime tglTransfer;
    private String bankTransfer;
    private int noAC;
    private String namaPembayar;
    private String namaKK;
    private String atasNamaKK;
    private LocalDateTime tglBayar;
    public Tiket() {
        listKonser.clear();
    }

    public LocalDateTime getTanggalBeli() {
        return tanggalBeli;
    }

    public String getKota() {
        return kota;
    }

    public String getNoID() {
        return noID;
    }

    public String getJenisID() {
        return jenisID;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public String getEmailPembeli() {
        return emailPembeli;
    }

    public String getTelpPembeli() {
        return telpPembeli;
    }

    public String getAlamatPembeli() {
        return alamatPembeli;
    }

    public Pembayaran getPembayaranPembeli() {
        return pembayaranPembeli;
    }

    public int getJmlhTransfer() {
        return jmlhTransfer;
    }

    public LocalDateTime getTglTransfer() {
        return tglTransfer;
    }

    public String getBankTransfer() {
        return bankTransfer;
    }

    public int getNoAC() {
        return noAC;
    }

    public String getNamaPembayar() {
        return namaPembayar;
    }

    public String getNamaKK() {
        return namaKK;
    }

    public String getAtasNamaKK() {
        return atasNamaKK;
    }

    public LocalDateTime getTglBayar() {
        return tglBayar;
    }

    public void addKonser(Konser konser, int qty) {
        listKonser.put(konser, qty);
    }
    public void setQtyKonser(Konser konser, int qty) {
        listKonser.put(konser, qty);
    }
    public void removeKonser(Konser konser) {
        listKonser.remove(konser);
    }

    public int calcHarga() {
        int harga = 0;
        for (Map.Entry<Konser, Integer> entryKonser : listKonser.entrySet()) {
            harga += (entryKonser.getKey().getHargaKonser() * entryKonser.getValue());
        }
        return harga;
    }
    public void setTanggalBeli(LocalDateTime tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }

    public void setNoID(String noID) {
        this.noID = noID;
    }

    public void setJenisID(String jenisID) {
        this.jenisID = jenisID;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public void setEmailPembeli(String emailPembeli) {
        this.emailPembeli = emailPembeli;
    }

    public void setTelpPembeli(String telpPembeli) {
        this.telpPembeli = telpPembeli;
    }

    public void setAlamatPembeli(String alamatPembeli) {
        this.alamatPembeli = alamatPembeli;
    }

    public void setPembayaranPembeli(Pembayaran pembayaranPembeli) {
        this.pembayaranPembeli = pembayaranPembeli;
    }

    public void setJmlhTransfer(int jmlhTransfer) {
        this.jmlhTransfer = jmlhTransfer;
    }

    public void setTglTransfer(LocalDateTime tglTransfer) {
        this.tglTransfer = tglTransfer;
    }

    public void setBankTransfer(String bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public void setNoAC(int noAC) {
        this.noAC = noAC;
    }

    public void setNamaPembayar(String namaPembayar) {
        this.namaPembayar = namaPembayar;
    }

    public void setNamaKK(String namaKK) {
        this.namaKK = namaKK;
    }

    public void setAtasNamaKK(String atasNamaKK) {
        this.atasNamaKK = atasNamaKK;
    }

    public void setTglBayar(LocalDateTime tglBayar) {
        this.tglBayar = tglBayar;
    }
}

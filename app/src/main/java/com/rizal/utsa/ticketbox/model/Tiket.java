package com.rizal.utsa.ticketbox.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tiket implements Parcelable {
    public void setKota(String kota) {
        this.kota = kota;
    }

    public int getJmlhBayarKK() {
        return jmlhBayarKK;
    }

    public void setJmlhBayarKK(int jmlhBayarKK) {
        this.jmlhBayarKK = jmlhBayarKK;
    }

    public enum Pembayaran {
        TRANSFER_BANK,
        KARTU_KREDIT
    }
    public static List<String> listKotaKonser = Arrays.asList("Malang", "Jakarta", "Bali", "Surabaya");

    public Map<Konser, Integer> getListKonser() {
        return listKonser;
    }

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
    private String noAC;
    private String namaPembayar;
    private String namaKK;
    private String atasNamaKK;
    private int jmlhBayarKK;
    private LocalDateTime tglBayarKK;
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

    public String getNoAC() {
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

    public LocalDateTime getTglBayarKK() {
        return tglBayarKK;
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

    public void setNoAC(String noAC) {
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

    public void setTglBayarKK(LocalDateTime tglBayarKK) {
        this.tglBayarKK = tglBayarKK;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.listKonser.size());
        for (Map.Entry<Konser, Integer> entry : this.listKonser.entrySet()) {
            dest.writeParcelable(entry.getKey(), flags);
            dest.writeValue(entry.getValue());
        }
        dest.writeSerializable(this.tanggalBeli);
        dest.writeString(this.kota);
        dest.writeString(this.noID);
        dest.writeString(this.jenisID);
        dest.writeString(this.namaPembeli);
        dest.writeString(this.emailPembeli);
        dest.writeString(this.telpPembeli);
        dest.writeString(this.alamatPembeli);
        dest.writeInt(this.pembayaranPembeli == null ? -1 : this.pembayaranPembeli.ordinal());
        dest.writeInt(this.jmlhTransfer);
        dest.writeSerializable(this.tglTransfer);
        dest.writeString(this.bankTransfer);
        dest.writeString(this.noAC);
        dest.writeString(this.namaPembayar);
        dest.writeString(this.namaKK);
        dest.writeString(this.atasNamaKK);
        dest.writeInt(this.jmlhBayarKK);
        dest.writeSerializable(this.tglBayarKK);
    }

    public void readFromParcel(Parcel source) {
        int listKonserSize = source.readInt();
        this.listKonser = new HashMap<Konser, Integer>(listKonserSize);
        for (int i = 0; i < listKonserSize; i++) {
            Konser key = source.readParcelable(Konser.class.getClassLoader());
            Integer value = (Integer) source.readValue(Integer.class.getClassLoader());
            this.listKonser.put(key, value);
        }
        this.tanggalBeli = (LocalDateTime) source.readSerializable();
        this.kota = source.readString();
        this.noID = source.readString();
        this.jenisID = source.readString();
        this.namaPembeli = source.readString();
        this.emailPembeli = source.readString();
        this.telpPembeli = source.readString();
        this.alamatPembeli = source.readString();
        int tmpPembayaranPembeli = source.readInt();
        this.pembayaranPembeli = tmpPembayaranPembeli == -1 ? null : Pembayaran.values()[tmpPembayaranPembeli];
        this.jmlhTransfer = source.readInt();
        this.tglTransfer = (LocalDateTime) source.readSerializable();
        this.bankTransfer = source.readString();
        this.noAC = source.readString();
        this.namaPembayar = source.readString();
        this.namaKK = source.readString();
        this.atasNamaKK = source.readString();
        this.jmlhBayarKK = source.readInt();
        this.tglBayarKK = (LocalDateTime) source.readSerializable();
    }

    protected Tiket(Parcel in) {
        int listKonserSize = in.readInt();
        this.listKonser = new HashMap<Konser, Integer>(listKonserSize);
        for (int i = 0; i < listKonserSize; i++) {
            Konser key = in.readParcelable(Konser.class.getClassLoader());
            Integer value = (Integer) in.readValue(Integer.class.getClassLoader());
            this.listKonser.put(key, value);
        }
        this.tanggalBeli = (LocalDateTime) in.readSerializable();
        this.kota = in.readString();
        this.noID = in.readString();
        this.jenisID = in.readString();
        this.namaPembeli = in.readString();
        this.emailPembeli = in.readString();
        this.telpPembeli = in.readString();
        this.alamatPembeli = in.readString();
        int tmpPembayaranPembeli = in.readInt();
        this.pembayaranPembeli = tmpPembayaranPembeli == -1 ? null : Pembayaran.values()[tmpPembayaranPembeli];
        this.jmlhTransfer = in.readInt();
        this.tglTransfer = (LocalDateTime) in.readSerializable();
        this.bankTransfer = in.readString();
        this.noAC = in.readString();
        this.namaPembayar = in.readString();
        this.namaKK = in.readString();
        this.atasNamaKK = in.readString();
        this.jmlhBayarKK = in.readInt();
        this.tglBayarKK = (LocalDateTime) in.readSerializable();
    }

    public static final Parcelable.Creator<Tiket> CREATOR = new Parcelable.Creator<Tiket>() {
        @Override
        public Tiket createFromParcel(Parcel source) {
            return new Tiket(source);
        }

        @Override
        public Tiket[] newArray(int size) {
            return new Tiket[size];
        }
    };
}

package com.rizal.utsa.ticketbox.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.rizal.utsa.ticketbox.R;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Konser implements Parcelable {
    private String namaKonser;
    private int hargaKonser;
    private int imgCoverBand;
    private List<LocalDateTime> dateKonser;
    private List<String> kotaKonser;
    public static List<Konser> listKonser = Arrays.asList(
            new Konser("Senbatsu JKT48 Gen 1", 1500000, R.drawable.waipu, Arrays.asList(
                    LocalDateTime.of(2022, Month.MAY, 16, 0, 0, 0),
                    LocalDateTime.of(2022, Month.MAY, 17, 0, 0, 0)
            ), Arrays.asList("Malang", "Jakarta")),
            new Konser("Senbatsu JKT48 Gen 2", 1200000, R.drawable.waipu, Arrays.asList(
                    LocalDateTime.of(2022, Month.MAY, 18, 0, 0, 0)
            ), Arrays.asList("Malang"))
    );

    public Konser(String namaKonser, int hargaKonser, int imgCoverBand, List<LocalDateTime> dateKonser, List<String> kotaKonser) {
        this.namaKonser = namaKonser;
        this.hargaKonser = hargaKonser;
        this.imgCoverBand = imgCoverBand;
        this.dateKonser = dateKonser;
        this.kotaKonser = kotaKonser;
    }

    public String getNamaKonser() {
        return namaKonser;
    }

    public int getHargaKonser() {
        return hargaKonser;
    }

    public int getImgCoverBand() {
        return imgCoverBand;
    }

    public List<LocalDateTime> getDateKonser() {
        return dateKonser;
    }

    public List<String> getKotaKonser() {
        return kotaKonser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaKonser);
        dest.writeInt(this.hargaKonser);
        dest.writeInt(this.imgCoverBand);
        dest.writeList(this.dateKonser);
        dest.writeStringList(this.kotaKonser);
    }

    public void readFromParcel(Parcel source) {
        this.namaKonser = source.readString();
        this.hargaKonser = source.readInt();
        this.imgCoverBand = source.readInt();
        this.dateKonser = new ArrayList<LocalDateTime>();
        source.readList(this.dateKonser, LocalDateTime.class.getClassLoader());
        this.kotaKonser = source.createStringArrayList();
    }

    protected Konser(Parcel in) {
        this.namaKonser = in.readString();
        this.hargaKonser = in.readInt();
        this.imgCoverBand = in.readInt();
        this.dateKonser = new ArrayList<LocalDateTime>();
        in.readList(this.dateKonser, LocalDateTime.class.getClassLoader());
        this.kotaKonser = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Konser> CREATOR = new Parcelable.Creator<Konser>() {
        @Override
        public Konser createFromParcel(Parcel source) {
            return new Konser(source);
        }

        @Override
        public Konser[] newArray(int size) {
            return new Konser[size];
        }
    };
}

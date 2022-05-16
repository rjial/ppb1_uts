package com.rizal.utsa.ticketbox.model;

import com.rizal.utsa.ticketbox.R;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Konser {
    private String namaKonser;
    private int hargaKonser;
    private int imgCoverBand;
    private List<LocalDateTime> dateKonser;
    private List<String> kotaKonser;
    public static List<Konser> listKonser = Arrays.asList(
            new Konser("Senbatsu JKT48 Gen 1", 1500000, R.drawable.waipu, Arrays.asList(
                    LocalDateTime.of(2022, Month.MAY, 5, 0, 0, 0), LocalDateTime.of(2022, Month.MAY, 5, 0, 0, 0)
            ), Arrays.asList("Malang", "Jakarta")),
            new Konser("Senbatsu JKT48 Gen 2", 1200000, R.drawable.waipu, Arrays.asList(
                    LocalDateTime.of(2022, Month.MAY, 5, 0, 0, 0)
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
}

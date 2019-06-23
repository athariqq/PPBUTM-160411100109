package com.example.myapplication;

public class Makanan {

    private String namaMkn;
    private String hargaMkn;
    private String jumlahMkn;
    private Integer total;
    private Integer index;

    public Makanan(String namaMkn, String hargaMkn, String jumlahMkn, Integer total, Integer index) {
        this.namaMkn = namaMkn;
        this.hargaMkn = hargaMkn;
        this.jumlahMkn = jumlahMkn;
        this.total = total;
        this.index = index;
    }

    public String getNamaMakanan() {
        return namaMkn;
    }


    public String getHargaMakanan() {
        return hargaMkn;
    }


    public void setJumlah(String jumlahMkn) {
        this.jumlahMkn = jumlahMkn;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getIndex() {
        return index;
    }
}

package com.example.spermbank;

public class SpermData {

    String titledoes;
//    String datedoes;
//    String descdoes;
    String titledoes1;
    String titledoes2;
    String titledoes3;
    String keydoes;

    public SpermData(String titledoes, String titledoes1, String titledoes2, String titledoes3, String keydoes) {
        this.titledoes = titledoes;
        this.titledoes1 = titledoes1;
        this.titledoes2 = titledoes2;
        this.titledoes3 = titledoes3;
//        this.datedoes = datedoes;
//        this.descdoes = descdoes;
        this.keydoes = keydoes;
    }

    public String getKeydoes() {
        return keydoes;
    }

    public void setKeydoes(String keydoes) {
        this.keydoes = keydoes;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titledoes) {
        this.titledoes = titledoes;
    }

    public String getTitledoes1() {
        return titledoes1;
    }

    public void setTitledoes1(String titledoes1) {
        this.titledoes1 = titledoes1;
    }

    public String getTitledoes2() {
        return titledoes2;
    }

    public void setTitledoes2(String titledoes2) {
        this.titledoes2 = titledoes2;
    }


    public String getTitledoes3() {
        return titledoes3;
    }

    public void setTitledoes3(String titledoes3) {
        this.titledoes = titledoes3;
    }

//    public String getDatedoes() {
//        return datedoes;
//    }
//
//    public void setDatedoes(String datedoes) {
//        this.datedoes = datedoes;
//    }
//
//    public String getDescdoes() {
//        return descdoes;
//    }
//
//    public void setDescdoes(String descdoes) {
//        this.descdoes = descdoes;
//    }
}
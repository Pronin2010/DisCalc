package com.cement.model;

public class OrderDiscountParam {

    private int priceFor50Kg;
    private int kgPerBag;
    private int startDiscountPercent;
    private int discountStep;
    private int minDiscountPercent;
    private String inputFilePath;
    private String resultFilePath;

    public OrderDiscountParam(int priceFor50Kg, int kgPerBag, int startDiscountPercent, int discountStep, int minDiscountPercent, String inputFilePath, String resultFilePath) {
        this.priceFor50Kg = priceFor50Kg;
        this.kgPerBag = kgPerBag;
        this.startDiscountPercent = startDiscountPercent;
        this.discountStep = discountStep;
        this.minDiscountPercent = minDiscountPercent;
        this.inputFilePath = inputFilePath;
        this.resultFilePath = resultFilePath;
    }

    public int getPriceFor50Kg() {
        return priceFor50Kg;
    }

    public void setPriceFor50Kg(int priceFor50Kg) {
        this.priceFor50Kg = priceFor50Kg;
    }

    public int getStartDiscountPercent() {
        return startDiscountPercent;
    }

    public void setStartDiscountPercent(int startDiscountPercent) {
        this.startDiscountPercent = startDiscountPercent;
    }

    public int getKgPerBag() {
        return kgPerBag;
    }

    public void setKgPerBag(int kgPerBag) {
        this.kgPerBag = kgPerBag;
    }

    public int getDiscountStep() {
        return discountStep;
    }

    public void setDiscountStep(int discountStep) {
        this.discountStep = discountStep;
    }

    public int getMinDiscountPercent() {
        return minDiscountPercent;
    }

    public void setMinDiscountPercent(int minDiscountPercent) {
        this.minDiscountPercent = minDiscountPercent;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getResultFilePath() {
        return resultFilePath;
    }

    public void setResultFilePath(String resultFilePath) {
        this.resultFilePath = resultFilePath;
    }
}
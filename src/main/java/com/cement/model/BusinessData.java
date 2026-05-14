package com.cement.model;

public class BusinessData {

    private int priceFor50Kg = 500;
    private int kgPerBag = 50;
    private int startDiscountPercent = 50;
    private int discountStep = 5;
    private int minDiscountPercent = 0;





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
}

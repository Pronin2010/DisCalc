package com.cement.service;

import com.cement.model.BusinessData;
import com.cement.model.Order;

import java.util.ArrayList;
import java.util.List;

public class BuisnessLogicMain {

    public void BuisnessLogic(BusinessData businessData) {
        List<Order> allOrders = new ArrayList<>();
        ReadOrderFromFile readOrder = new ReadOrderFromFile();
        WriteResultInFile writeResult = new WriteResultInFile();
        DiscountService discountService = new DiscountService();


        allOrders.addAll(readOrder.readOrdersFromFile(businessData.getInputFilePath()));
        writeResult.writeResultInFile((discountService.processOrders(allOrders,
                        businessData.getStartDiscountPercent(),
                        businessData.getDiscountStep(),
                        businessData.getMinDiscountPercent(),
                        businessData.getPriceFor50Kg(),
                        businessData.getKgPerBag())),
                businessData.getResultFilePath());


        System.out.println("Расчет закончен : " + businessData.getResultFilePath());
    }

}

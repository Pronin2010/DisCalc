package com.cement;

import com.cement.model.Order;
import com.cement.service.DiscountService;
import com.cement.service.ReadOrderFromFile;
import com.cement.service.WriteResultInFile;
import com.cement.model.BusinessData;
import java.util.ArrayList;
import java.util.List;



public class Main {

    static void main(String[] args) {

        String inputFilePath = "InputData/discount_day.txt";
        String resultFilePath = "OutputData/result.txt";

        List<Order> allOrders = new ArrayList<>();
        ReadOrderFromFile readOrder = new ReadOrderFromFile();
        WriteResultInFile writeResult = new WriteResultInFile();
        DiscountService discountService = new DiscountService();
        BusinessData businessData = new BusinessData();

        allOrders.addAll(readOrder.readOrdersFromFile(inputFilePath));
        writeResult.writeResultInFile((discountService.processOrders(allOrders,
                businessData.getStartDiscountPercent(),
                businessData.getDiscountStep(),
                businessData.getMinDiscountPercent(),
                businessData.getPriceFor50Kg(),
                businessData.getKgPerBag())) ,
                resultFilePath);


        System.out.println("Расчет закончен : " + resultFilePath);
    }
}

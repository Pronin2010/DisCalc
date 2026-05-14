package com.cement;

import com.cement.model.BusinessData;
import com.cement.service.BuisnessLogicMain;


public class Main {

    static void main(String[] args) {

        BusinessData businessData = new BusinessData(
                500,
                50,
                50,
                5,
                0,
                "InputData/discount_day.txt",
                "OutputData/result.txt"
        );

        BuisnessLogicMain buisnessLogicMain = new BuisnessLogicMain();
        buisnessLogicMain.BuisnessLogic(businessData);


    }


}

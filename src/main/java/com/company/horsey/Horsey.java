package com.company.horsey;

import com.model.Currency;
import com.service.HorseService;
import com.service.HorseServiceImpl;
import com.service.ProcessService;
import com.service.ProcessServiceImpl;

import java.util.Scanner;

public class Horsey {

    public static void main(String [ ] args) {

        HorseService horseService = new HorseServiceImpl();
        horseService.displayHorses(horseService.loadHorses());
        Currency currency = new Currency();
        currency.displayCurrencyInventory();

        ProcessService processService = new ProcessServiceImpl();
        Scanner console = new Scanner(System.in);
        String input;

        do {
            processService.processInput(console.nextLine());
        } while (true);
    }
}

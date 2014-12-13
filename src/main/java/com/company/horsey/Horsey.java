package com.company.horsey;

import com.service.DisplayService;
import com.service.DisplayServiceImpl;
import com.service.ProcessService;
import com.service.ProcessServiceImpl;

import java.util.Scanner;

public class Horsey {

    public static void main(String [ ] args) {

        DisplayService displayService = new DisplayServiceImpl();
        displayService.displayInventoryAndHorses();

        ProcessService processService = new ProcessServiceImpl();
        Scanner console = new Scanner(System.in);
        String input;

        do {
            processService.processInput(console.nextLine());
        } while (true);
    }
}

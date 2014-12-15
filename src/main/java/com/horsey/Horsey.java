package com.horsey;

import com.horsey.service.DisplayService;
import com.horsey.service.DisplayServiceImpl;
import com.horsey.service.ProcessService;
import com.horsey.service.ProcessServiceImpl;

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

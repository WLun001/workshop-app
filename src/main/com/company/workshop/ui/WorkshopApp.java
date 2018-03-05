package com.company.workshop.ui;

import com.company.workshop.domain.Controller;

public class WorkshopApp {

    private static IUserInterface userInterface;
    private static Controller controller;
    public static void main(String[] args) {
        userInterface = new AppUI();
        controller = new Controller();
        userInterface.setController(controller);
        userInterface.start();
    }
}

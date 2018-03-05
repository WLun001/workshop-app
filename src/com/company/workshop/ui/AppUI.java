package com.company.workshop.ui;

import com.company.workshop.domain.Controller;
import com.company.workshop.domain.Participant;
import com.company.workshop.domain.Workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppUI implements IUserInterface {

    private Scanner scanner;
    private Controller controller;

    public AppUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        int choice;
        do {
            System.out.println("Do you want to:");
            System.out.println("1. Display all workshops");
            System.out.println("2. Add participant to workshop");
            System.out.println("3. Display student name list for workshop");
            System.out.println("4. Register new workshop");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            while (choice < 1 || choice > 5) {
                System.out.println("Invalid choice.");
                System.out.print("Enter your choice (1-5): ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    displayWorkshops();
                    break;
                case 2:
                    addParticipant();
                    break;
                case 3:
                    displayParticipantsList();
                    break;
                case 4:
                    registerWorkshop();
                    break;
                case 5:
                    break;
            }

            System.out.println();

        } while (choice != 5);
    }

    private void displayWorkshops() {

        int count = controller.getNumberOfWorkshop();
        if (count == 0)
            System.out.println("No workshops to display");
        else {
            List<Workshop> workshops = controller.getWorkshopList();
            for (Workshop workshop : workshops) {
                System.out.println("Title: " + workshop.getTitle()
                        + "\tMax Participants: " + workshop.getMaxParticipants()
                        + "\tCurrent Participants: " + workshop.getNumberOfParticipants());
            }
        }
    }

    private void addParticipant() {

        selectWorkshop();
        Workshop selectedWorkshop = controller.getSelectedWorkshop();

        if (selectedWorkshop != null) {
            System.out.print("Enter participant name: ");
            String name = scanner.nextLine();

            controller.addParticipant(name);

            System.out.println();
        }
    }

    private void displayParticipantsList() {

        selectWorkshop();
        Workshop selectedWorkshop = controller.getSelectedWorkshop();
        if (selectedWorkshop != null) {
            ArrayList<Participant> participants = selectedWorkshop.getParticipants();
            if (participants.size() > 0) {
                System.out.println("Participants enrolled in workshop:");
                for (Participant participant : participants) {
                    System.out.println("ID: " + participant.getId()
                            + "\tName: " + participant.getName());
                }
            } else{
                System.out.println("No participants enrolled in workshop:");
            }
        }

    }

    private void selectWorkshop() {

        System.out.print("Enter workshop title: ");
        String skip = scanner.nextLine();
        String title = scanner.nextLine();
        Workshop workshop = controller.searchWorkshop(title);
        if (workshop == null)
            System.out.println("No workshop with title " + title + " found");
        else {
            System.out.println("Title: " + workshop.getTitle()
                    + "\tMax Participants: " + workshop.getMaxParticipants()
                    + "\tCurrent Participants: " + workshop.getNumberOfParticipants());
        }

    }

    private void registerWorkshop() {
        System.out.print("Enter workshop title: ");
        String skip = scanner.nextLine();
        String title = scanner.nextLine();

        System.out.print("Enter max number of participants can accept: ");
        int maxParticipants = scanner.nextInt();

        controller.registerWorkshop(title, maxParticipants);
        System.out.println("New workshop registered");
        System.out.println();
    }
}

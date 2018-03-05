package com.company.workshop.domain;

import java.util.List;

public class Controller {

    private IWorkshopList workshopList;
    private Workshop selectedWorkshop;

    public Controller(){
        workshopList = new WorkshopList();
    }

    public Workshop getSelectedWorkshop() {
        return selectedWorkshop;
    }

    public void registerWorkshop(String title, int maxParticipants){
        workshopList.registerWorkshop(title, maxParticipants);
    }

    public Workshop searchWorkshop(String title){
        selectedWorkshop =  workshopList.searchWorkshop(title);
        return selectedWorkshop;
    }

    public int getNumberOfWorkshop(){
        return workshopList.getWorkshopCount();
    }

    public List<Workshop> getWorkshopList(){
        return workshopList.getWorkshopList();
    }

    public void addParticipant(String name){
        selectedWorkshop.addParticipant(name);
    }
}

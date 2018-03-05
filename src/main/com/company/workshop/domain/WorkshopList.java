package com.company.workshop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkshopList implements IWorkshopList {
    private List<Workshop> workshops;

    public WorkshopList(){
        workshops = new ArrayList<>();
    }
    @Override
    public void registerWorkshop(String title, int maxParticipants) {
        workshops.add(new Workshop(title, maxParticipants));
    }

    @Override
    public Workshop searchWorkshop(String title) {
        return workshops
                .stream()
                .filter(workshop -> workshop.getTitle().equals(title))
        .collect(Collectors.toList()).get(0);
    }

    @Override
    public int getWorkshopCount() {
        return workshops.size();
    }

    @Override
    public List<Workshop> getWorkshopList() {
        return workshops;
    }
}

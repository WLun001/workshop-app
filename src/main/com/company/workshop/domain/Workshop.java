package com.company.workshop.domain;

import java.util.ArrayList;

public class Workshop {

    private String title;
    private int maxParticipants;
    private ArrayList<Participant> participants;

    public Workshop(String title, int maxParticipants){
        participants = new ArrayList<>();
        this.title = title;
        this.maxParticipants = maxParticipants;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void addParticipant(String name) throws MaxParticipantsException {
        if (participants.size() < maxParticipants) {
            participants.add(new Participant(name));
        } else throw new MaxParticipantsException("Reached max number of participants");
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public int getNumberOfParticipants(){
        return participants.size() > 0 ? participants.size() : 0;
    }
}

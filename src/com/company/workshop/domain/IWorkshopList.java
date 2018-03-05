package com.company.workshop.domain;

import java.util.ArrayList;
import java.util.List;

interface IWorkshopList {
    void registerWorkshop(String title, int maxParticipants);
    Workshop searchWorkshop(String title);
    int getWorkshopCount();
    List<Workshop> getWorkshopList();
}

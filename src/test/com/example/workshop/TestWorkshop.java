package com.example.workshop;

import com.company.workshop.domain.Controller;
import com.company.workshop.domain.MaxParticipantsException;
import com.company.workshop.domain.Workshop;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWorkshop {
    @Test
    public void testSearchWorkshop(){
        Controller controller = new Controller();
        controller.registerWorkshop("c++", 10);
        assertEquals(controller.searchWorkshop("c++").getTitle(), "c++");
    }

    @Test(expected = MaxParticipantsException.class)
    public void testMaxParticipant() throws MaxParticipantsException {
        Workshop workshop = new Workshop("c++", 1);
        workshop.addParticipant("weilun");
        workshop.addParticipant("wanching");

    }
}

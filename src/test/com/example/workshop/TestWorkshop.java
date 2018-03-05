package com.example.workshop;

import com.company.workshop.domain.Controller;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWorkshop {
    @Test
    public void testSearchWorkshop(){
        Controller controller = new Controller();
        controller.registerWorkshop("c++", 10);
        assertEquals(controller.searchWorkshop("c++").getTitle(), "c++");
    }
}

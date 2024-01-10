package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flightTime1 = (24 - t1.getTimeFrom()) + t1.getTimeTo();
        int flightTime2 = (24 - t2.getTimeFrom()) + t2.getTimeTo();

        if (flightTime1 < flightTime2) {
            return -1;
        } else if (flightTime1 > flightTime2) {
            return 1;
        } else {
            return 0;
        }
    }
}

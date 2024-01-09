package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {
    @Test
    public void shouldCompareWhenTicketPriceGreater() {
        Ticket ticket1 = new Ticket("Москва", "Пермь", 10_000, 3, 2);
        Ticket ticket2 = new Ticket("Екатеринбург", "Сочи", 5_000, 6, 1);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareWhenTicketPriceLess() {
        Ticket ticket1 = new Ticket("Минск", "Москва", 17_000, 8, 1);
        Ticket ticket2 = new Ticket("Москва", "Милан", 60_000, 16, 15);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareWhenTicketPriceEquals() {
        Ticket ticket1 = new Ticket("Саратов", "Москва", 20_000, 13, 12);
        Ticket ticket2 = new Ticket("Казань", "Москва", 20_000, 16, 11);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

}
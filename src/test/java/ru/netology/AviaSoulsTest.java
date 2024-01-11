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

    @Test
    public void shouldFindTicket() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Пхукет", "Адлер", 80_000, 13, 12);
        Ticket ticket2 = new Ticket("Самара", "Новосибирск", 100_000, 16, 11);
        Ticket ticket3 = new Ticket("Адлер", "Самара", 5_000, 10, 1);
        Ticket ticket4 = new Ticket("Адлер", "Москва", 12_000, 11, 7);
        Ticket ticket5 = new Ticket("Казань", "Москва", 8_000, 13, 17);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.search("Адлер", "Самара");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchResultsByPrice() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Казань", "Москва", 16_000, 13, 12);
        Ticket ticket2 = new Ticket("Саратов", "Москва", 14_000, 16, 11);
        Ticket ticket3 = new Ticket("Казань", "Москва", 7_000, 16, 11);
        Ticket ticket4 = new Ticket("Минск", "Екатеринбург", 20_000, 10, 1);
        Ticket ticket5 = new Ticket("Казань", "Москва", 200, 2, 3);
        Ticket ticket6 = new Ticket("Казань", "Москва", 1000, 2, 8);
        Ticket ticket7 = new Ticket("Адлер", "Новосибирск", 1000, 4, 5);
        Ticket ticket8 = new Ticket("Казань", "Москва", 250, 6, 1);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {ticket5, ticket8, ticket6, ticket3, ticket1};
        Ticket[] actual = aviaSouls.search("Казань", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchResultsWhenPriceEquals() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Нижний Новгород", "Санкт-Петербург", 1_100, 13, 12);
        Ticket ticket2 = new Ticket("Нижний Новгород", "Санкт-Петербург", 5_738, 10, 11);
        Ticket ticket3 = new Ticket("Красноярск", "Пхукет", 25_637, 16, 11);
        Ticket ticket4 = new Ticket("Нижний Новгород", "Санкт-Петербург", 10_858, 13, 18);
        Ticket ticket5 = new Ticket("Нижний Новгород", "Санкт-Петербург", 189, 10, 1);
        Ticket ticket6 = new Ticket("Санкт-Петербург", "Нижний Новгород", 25, 2, 3);
        Ticket ticket7 = new Ticket("Нижний Новгород", "Санкт-Петербург", 1_100, 4, 5);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {ticket5, ticket1, ticket7, ticket2, ticket4};
        Ticket[] actual = aviaSouls.search("Нижний Новгород", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchResultsWhenElementsSorted() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Хабаровск", "Красноярск", 20_000, 1, 12);
        Ticket ticket2 = new Ticket("Хабаровск", "Красноярск", 34_454, 12, 6);
        Ticket ticket3 = new Ticket("Хабаровск", "Красноярск", 67_366, 11, 12);
        Ticket ticket4 = new Ticket("Хабаровск", "Красноярск", 78_399, 1, 2);
        Ticket ticket5 = new Ticket("Хабаровск", "Красноярск", 100_000, 19, 12);
        Ticket ticket6 = new Ticket("Санкт-Петербург", "Нижний Новгород", 25, 2, 3);
        Ticket ticket7 = new Ticket("Нижний Новгород", "Санкт-Петербург", 1_100, 4, 5);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.search("Хабаровск", "Красноярск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoTicketsFound() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Махачкала", "Иркутск", 2_624, 13, 12);
        Ticket ticket2 = new Ticket("Минеральные Воды", "Уфа", 3_628, 16, 11);
        Ticket ticket3 = new Ticket("Адлер", "Самара", 5_000, 10, 1);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Минеральные Воды", "Самара");

        Assertions.assertArrayEquals(expected, actual);
    }

   /* @Test
    public void shouldCompareWhenFlightTimeLess() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Минск", "Москва", 8_282, 17, 18);
        Ticket ticket2 = new Ticket("Новый Уренгой", "Уфа", 40_262, 22, 5);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }*/

    @Test
    public void shouldSortSearchResultsByTimeWithComparator() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Казань", "Москва", 16_000, 5, 15); // 10
        Ticket ticket2 = new Ticket("Саратов", "Москва", 14_000, 16, 11);
        Ticket ticket3 = new Ticket("Казань", "Москва", 7_000, 3, 7); // 4
        Ticket ticket4 = new Ticket("Минск", "Екатеринбург", 20_000, 10, 1);
        Ticket ticket5 = new Ticket("Казань", "Москва", 200, 2, 3); // 1
        Ticket ticket6 = new Ticket("Казань", "Москва", 1000, 2, 8); // 6
        Ticket ticket7 = new Ticket("Адлер", "Новосибирск", 1000, 4, 5);
        Ticket ticket8 = new Ticket("Казань", "Москва", 250, 6, 11); //5

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket3, ticket8, ticket6, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Казань", "Москва", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
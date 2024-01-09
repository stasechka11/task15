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

        Ticket ticket1 = new Ticket("Пхукет", "Иркутск", 80_000, 13, 12);
        Ticket ticket2 = new Ticket("Москва", "Новосибирск", 100_000, 16, 11);
        Ticket ticket3 = new Ticket("Адлер", "Самара", 5_000, 10, 1);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.search("Адлер", "Самара");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchResultsByPrice() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Казань", "Москва", 16_000, 13, 12);
        Ticket ticket2 = new Ticket("Саратов", "Москва", 14_000, 16, 11);
        Ticket ticket3 = new Ticket("Минск", "Екатеринбург", 20_000, 10, 1);
        Ticket ticket4 = new Ticket("Казань", "Москва", 200, 2, 3);
        Ticket ticket5 = new Ticket("Казань", "Москва", 1000, 4, 5);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket4, ticket5, ticket1};
        Ticket[] actual = aviaSouls.search("Казань", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchResultsWhenPriceEquals() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Нижний Новгород", "Санкт-Петербург", 1_100, 13, 12);
        Ticket ticket2 = new Ticket("Красноярск", "Пхукет", 25_637, 16, 11);
        Ticket ticket3 = new Ticket("Нижний Новгород", "Санкт-Петербург", 189, 10, 1);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Нижний Новгород", 25, 2, 3);
        Ticket ticket5 = new Ticket("Нижний Новгород", "Санкт-Петербург", 1_100, 4, 5);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket3, ticket1, ticket5};
        Ticket[] actual = aviaSouls.search("Нижний Новгород", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchResultsWhenElementsSorted() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Хабаровск", "Красноярск", 20_000, 1, 12);
        Ticket ticket2 = new Ticket("Хабаровск", "Красноярск", 34_454, 12, 6);
        Ticket ticket3 = new Ticket("Хабаровск", "Красноярск", 67_366, 11, 12);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Нижний Новгород", 25, 2, 3);
        Ticket ticket5 = new Ticket("Нижний Новгород", "Санкт-Петербург", 1_100, 4, 5);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3};
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

}
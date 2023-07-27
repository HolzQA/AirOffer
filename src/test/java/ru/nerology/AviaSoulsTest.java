package ru.nerology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.AviaSouls;
import ru.netology.manager.TicketTimeComparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Mosсow", "Paris", 15000, 1678811520, 1678827420);  /* 4:25 */
    Ticket ticket2 = new Ticket("Mosсow", "Paris", 17000, 1678778700, 1678793100);  /* 4 */
    Ticket ticket3 = new Ticket("Mosсow", "Tokio", 35000, 1678799100, 1678832700);  /* 9:20 */
    Ticket ticket4 = new Ticket("Mosсow", "New-York", 89000, 1678819560, 1678856460);  /* 10:15 */
    Ticket[] tickets = new Ticket[0];
    /* тест для сравнения по цене (compareTo) */
    @Test
    public void shouldComparePrices() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    /* тест на упорядочивание по возрастанию цены (search) */
    @Test
    public void shouldRegularizePrice() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = { ticket1, ticket2 };
        Ticket[] actual = manager.search("Mosсow","Paris");

        Assertions.assertArrayEquals(expected, actual);
    }

    /* тест для сравнения по времени полета (Comparator) */
    @Test
    public void shouldCompareDurationWithComparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = timeComparator.compare(ticket4, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    /* тест на упорядочивание по времени полета (searchAndSortBy) */
    @Test
    public void shouldRegularizeDurationWithComparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = { ticket2, ticket1 };
        Ticket[] actual = manager.searchAndSortBy("Mosсow","Paris", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}

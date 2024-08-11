import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void moreOneTicketSearch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 1000, 7, 10);
        Ticket ticket2 = new Ticket("MSK", "UFA", 7000, 17, 21);
        Ticket ticket3 = new Ticket("MSK", "NSB", 5500, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 15, 19);
        Ticket ticket5 = new Ticket("MSK", "UFA", 4000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 3000, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "UFA", 2500, 17, 20);
        Ticket ticket8 = new Ticket("MSK", "UFA", 7000, 17, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("MSK", "UFA");
        Ticket[] expected = {ticket7, ticket5, ticket2, ticket8};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneTicketSearch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 1000, 7, 10);
        Ticket ticket2 = new Ticket("MSK", "UFA", 7000, 17, 21);
        Ticket ticket3 = new Ticket("MSK", "NSB", 5500, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 15, 19);
        Ticket ticket5 = new Ticket("MSK", "UFA", 4000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "ASF", 3000, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "UFA", 2500, 17, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSK", "ASF");
        Ticket[] expected = {ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void nullTicketSearch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 1000, 7, 10);
        Ticket ticket2 = new Ticket("MSK", "UFA", 7000, 17, 21);
        Ticket ticket3 = new Ticket("MSK", "NSB", 5500, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 15, 19);
        Ticket ticket5 = new Ticket("MSK", "UFA", 4000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "ASF", 3000, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "UFA", 2500, 17, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSK", "ASH");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moreOneTicketSearchComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 1000, 7, 10);
        Ticket ticket2 = new Ticket("MSK", "UFA", 7000, 17, 21);
        Ticket ticket3 = new Ticket("MSK", "NSB", 5500, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 15, 19);
        Ticket ticket5 = new Ticket("MSK", "UFA", 4000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "ASF", 3000, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "UFA", 2500, 17, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "UFA", comparator);
        Ticket[] expected = {ticket7, ticket2, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneTicketSearchComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 1000, 7, 10);
        Ticket ticket2 = new Ticket("MSK", "UFA", 7000, 17, 21);
        Ticket ticket3 = new Ticket("MSK", "NSB", 5500, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 15, 19);
        Ticket ticket5 = new Ticket("MSK", "UFA", 4000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "ASF", 3000, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "UFA", 2500, 17, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "ASF", comparator);
        Ticket[] expected = {ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void mullTicketSearchComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 1000, 7, 10);
        Ticket ticket2 = new Ticket("MSK", "UFA", 7000, 17, 21);
        Ticket ticket3 = new Ticket("MSK", "NSB", 5500, 12, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 15, 19);
        Ticket ticket5 = new Ticket("MSK", "UFA", 4000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "ASF", 3000, 11, 14);
        Ticket ticket7 = new Ticket("MSK", "UFA", 2500, 17, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "ASH", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}

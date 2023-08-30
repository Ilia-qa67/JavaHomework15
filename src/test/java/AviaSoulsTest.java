import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket(
            "Moscow",
            "New York",
            50_000,
            1400,
            2300

    );

    Ticket ticket2 = new Ticket(
            "Moscow",
            "New York",
            60_000,
            1500,
            2350
    );

    Ticket ticket3 = new Ticket(
            "Moscow",
            "New York",
            20_000,
            600,
            1200
    );

    Ticket ticket4 = new Ticket(
            "Moscow",
            "New York",
            10_000,
            2000,
            800
    );

    Ticket ticket5 = new Ticket(
            "Moscow",
            "New York",
            100_000,
            2300,
            430
    );

    @Test
    public void ShouldCompareToTickets() {

        AviaSouls man = new AviaSouls();

        man.add(ticket1);
        man.add(ticket2);

        int expected = - 1;
        int actual = ticket1.compareTo(ticket2);


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSortTickets() {

        AviaSouls man = new AviaSouls();

        man.add(ticket1);
        man.add(ticket2);
        man.add(ticket3);
        man.add(ticket4);
        man.add(ticket5);

        Ticket[] expected = {ticket4, ticket3, ticket1, ticket2, ticket5};
        Ticket[] actual = man.search("Moscow", "New York");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketTimeComparator() {

        AviaSouls man = new AviaSouls();

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        man.add(ticket1);
        man.add(ticket2);

        int expected = 1;

        Assertions.assertEquals(expected, timeComparator.compare(ticket1, ticket2));

    }

    @Test
    public void searchAndSortBy() {
        AviaSouls man = new AviaSouls();

        man.add(ticket1);
        man.add(ticket2);
        man.add(ticket3);
        man.add(ticket4);
        man.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = { ticket5, ticket3, ticket2, ticket1, ticket4};
        Ticket[] actual = man.searchAndSortBy("Moscow", "New York", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}

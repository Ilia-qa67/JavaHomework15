import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void ShouldCompareToTickets() {
        Ticket ticket1 = new Ticket(
                "Moscow",
                "New York",
                50_000,
                1400,
                2300

        );

        Ticket ticket2 = new Ticket(
                "Moscow",
                "Barcelona",
                30_000,
                1500,
                2000
        );

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSortTickets() {

        AviaSouls man = new AviaSouls();

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
                630,
                1600
        );

        man.add(ticket1);
        man.add(ticket2);
        man.add(ticket3);

        Ticket[] expected = {ticket3, ticket1, ticket2};
        Ticket[] actual = man.search("Moscow", "New York");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketTimeComparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();


        int actual = timeComparator.compare(new Ticket(
                "Moscow",
                "New York",
                50_000,
                1400,
                2300
        ), new Ticket(
                "Moscow",
                "New York",
                60_000,
                1500,
                2330
        ));

        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchAndSortBy() {
        AviaSouls man = new AviaSouls();

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

        man.add(ticket1);
        man.add(ticket2);
        man.add(ticket3);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = { ticket3, ticket2, ticket1};
        Ticket[] actual = man.searchAndSortBy("Moscow", "New york", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}

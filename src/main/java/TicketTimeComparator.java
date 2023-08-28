import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int time1;
        int time2;
        if (t1.getTimeFrom() < t1.getTimeTo()) {
            time1 = t1.getTimeTo() - t1.getTimeFrom();
        } else {
            time1 = t1.getTimeTo() - t1.getTimeFrom() + 2400;
        }
        if (t2.getTimeFrom() < t2.getTimeTo()) {
            time2 = t2.getTimeTo() - t2.getTimeFrom();
        } else {
            time2 = t2.getTimeTo() - t2.getTimeFrom() + 2400;
        }
        if (time1 < time2) {
            return -1;
        }
        if (time1 > time2) {
            return 1;
        } else {
            return 0;
        }
    }
}


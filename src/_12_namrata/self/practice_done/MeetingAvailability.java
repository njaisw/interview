package _12_namrata.self.practice_done;

import java.util.Arrays;

public class MeetingAvailability {

    private static class Availability implements Comparable<Availability> {
        int start;
        int end;

        public Availability(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Availability() {
        }

        @Override
        public int compareTo(Availability o) {
            return this.end - o.end;
        }
    }

    private Availability findAvailability(Availability[] person1, Availability[] person2) {

        Availability availableSchedule = new Availability();

        //TODO sorts elements by end time
        Arrays.sort(person1);
        Arrays.sort(person2);

        int i = 0;
        int j = 0;

        while (i < person1.length && j < person2.length) {
            if (person1[i].end < person2[j].start) {
                i++;
            } else if (person1[i].start >= person2[j].end) {
                j++;
            } else {
                availableSchedule.start = Math.max(person1[i].start, person2[j].start);
                availableSchedule.end = Math.min(person1[i].end, person2[j].end);
                break;
            }

        }

        return availableSchedule;

    }

    public static void main(String[] args) {

        Availability[] person1 = new Availability[]{new Availability(1, 2), new Availability(4, 7),
                new Availability(7, 8)};

        Availability[] person2 = new Availability[]{new Availability(3, 4), new Availability(5, 6),
                new Availability(11, 12)};

        MeetingAvailability availability = new MeetingAvailability();
        Availability meeting = availability.findAvailability(person1, person2);

        System.out.println(meeting.start + " " + meeting.end);

    }

}

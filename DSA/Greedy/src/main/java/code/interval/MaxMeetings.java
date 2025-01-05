package code.interval;

import java.util.ArrayList;
import java.util.List;

public class MaxMeetings {
    class Meeting {
        int start;
        int end;
        int position;

        Meeting(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

    }

    public int maxMeetings(int start[], int end[]) {
        if (start.length == 0 || end.length == 0 || start.length != end.length) {
            return 0; // Handle edge cases
        }
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i], i));
        }

        // Sort meetings by end time, and by start time in case of ties
        meetings.sort((a, b) -> a.end != b.end ? Integer.compare(a.end, b.end) : Integer.compare(a.start, b.start));


        int count = 0;
        int lastEndTime = -1; // Initialize to a value before any possible start time

        // Iterate through sorted meetings
        for (Meeting currentMeeting : meetings) {
            if (currentMeeting.start > lastEndTime) { // Can attend this meeting
                lastEndTime = currentMeeting.end;
                count++;
            }
        }

        return count;


    }


    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) count5++;
            else if (bills[i] == 10) {
                if (count5 == 0) return false;
                count5--;
                count10++;
            } else if (bills[i] == 20) {
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                }
                else if (count5 >= 3) {
                    count5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}

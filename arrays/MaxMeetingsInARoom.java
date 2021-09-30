/**
 /**
 There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i]
 is start time of meeting i and end[i] is finish time of meeting i.
 What is the maximum number of meetings that can be accommodated in the meeting room when only
 one meeting can be held in the meeting room at a particular time?

 Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
 Example 1:

 Input:
 N = 6
 start[] = {1,3,0,5,8,5}
 end[] =  {2,4,6,7,9,9}
 Output:
 4
 Explanation:
 Maximum four meetings can be held with
 given start and end timings.
 The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
 **/

package com.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxMeetingsInARoom {

    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Meeting> a = createMeetingArray(start,end);
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(a,mc);
        int maxMeetings = 1;
        int time_Limit = a.get(0).endTime;
        for(int i=1;i<n;i++){
            if(time_Limit < a.get(i).startTime){
                time_Limit = a.get(i).endTime;
                maxMeetings +=1;
            }
        }
        return maxMeetings;
    }

    public static List<Meeting> createMeetingArray(int start[], int end[]){
        List<Meeting> a = new ArrayList<>();
        for(int i=0;i<end.length;i++){
            Meeting meeting = new Meeting();
            meeting.startTime = start[i];
            meeting.endTime = end[i];
            a.add(meeting);
        }
        return a;
    }

    static class Meeting{
        int startTime;
        int endTime;
    }

    static class MeetingComparator implements Comparator<Meeting> {

            public int compare(Meeting o1, Meeting o2)
            {
                if (o1.endTime < o2.endTime)

                    return -1;
                else if (o1.endTime > o2.endTime)

                    // Return 1 if second object is
                    // smaller then first
                    return 1;

                return 0;
            }
        }

}


package SnapchatQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MeetingRooms {
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i ++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startPointer = 0;
        int endPointer = 0;
        int assignRoomNumber = 0;
        while (startPointer < start.length) {
            if (end[endPointer] > start[startPointer]) {
                assignRoomNumber ++;
                startPointer ++;
            } else {
                endPointer ++;
            }
        }
        
        
        return assignRoomNumber;
    }
    
}

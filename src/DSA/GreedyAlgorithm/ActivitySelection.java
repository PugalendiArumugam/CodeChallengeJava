package DSA.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Represents an activity with start and finish times
class Activity {
    int start;
    int finish;
    String name; // Optional: to identify the activity

    public Activity(String name, int start, int finish) {
        this.name = name;
        this.start = start;
        this.finish = finish;
    }

    // Getter for finish time, used for sorting
    public int getFinishTime() {
        return finish;
    }

    @Override
    public String toString() {
        return "(" + name + ": " + start + "-" + finish + ")";
    }
}

// Comparator to sort activities based on finish time
class ActivityComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        // Sort in ascending order of finish times
        return Integer.compare(a1.finish, a2.finish);
        // Or simply: return a1.finish - a2.finish;
    }
}

public class ActivitySelection {

    /**
     * Selects the maximum number of non-overlapping activities using a greedy approach.
     *
     * @param activities The list of all available activities.
     * @return A list containing the names of the selected activities.
     */
    public static List<String> selectActivities(List<Activity> activities) {
        List<String> selectedActivityNames = new ArrayList<>();

        if (activities == null || activities.isEmpty()) {
            return selectedActivityNames; // Return empty list if no activities
        }

        // 1. Sort activities based on their finish times
        Collections.sort(activities, new ActivityComparator());
        // Or using lambda expression:
        // activities.sort(Comparator.comparingInt(Activity::getFinishTime));

        System.out.println("Sorted Activities (by finish time): " + activities);

        // 2. Select the first activity (it finishes earliest)
        Activity lastSelectedActivity = activities.get(0);
        selectedActivityNames.add(lastSelectedActivity.name);
        System.out.println("Selected: " + lastSelectedActivity);

        // 3. Iterate through the remaining activities
        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);

            // If the current activity starts after or at the same time the last selected one finishes
            if (currentActivity.start >= lastSelectedActivity.finish) {
                // Select this activity
                selectedActivityNames.add(currentActivity.name);
                lastSelectedActivity = currentActivity; // Update the last selected activity
                System.out.println("Selected: " + currentActivity);
            } else {
                System.out.println("Skipped (overlaps " + lastSelectedActivity.name + "): " + currentActivity);
            }
        }

        return selectedActivityNames;
    }

    public static void main(String[] args) {
        // Example Activities
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1", 1, 4));
        activities.add(new Activity("A2", 3, 5));
        activities.add(new Activity("A3", 0, 6));
        activities.add(new Activity("A4", 5, 7));
        activities.add(new Activity("A5", 3, 9)); // Note: Longer duration, finishes later
        activities.add(new Activity("A6", 5, 9));
        activities.add(new Activity("A7", 6, 10));
        activities.add(new Activity("A8", 8, 11));
        activities.add(new Activity("A9", 8, 12));
        activities.add(new Activity("A10", 2, 14));
        activities.add(new Activity("A11", 12, 16));

        System.out.println("Original Activities: " + activities);
        System.out.println("------------------------------------");

        // Perform the selection
        List<String> result = selectActivities(activities);

        System.out.println("------------------------------------");
        System.out.println("Maximum number of non-overlapping activities: " + result.size());
        System.out.println("Selected Activities: " + result); // Expected: [A1, A4, A8, A11] or similar based on tie-breaking in sort
    }
}

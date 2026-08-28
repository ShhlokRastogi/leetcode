class Task implements Comparable<Task> {

    int freq;       // How many times this task still needs to execute
    int exetime;    // The earliest time when this task can execute again

    Task(int f, int e) {
        freq = f;
        exetime = e;
    }
    // PriorityQueue will use this to decide which task comes first
    public int compareTo(Task that) {
        return that.freq - this.freq;
    }
}

class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Store frequency of every task
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {

            // Increase frequency of current task
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        // PriorityQueue stores tasks that are currently AVAILABLE
        // Because of compareTo(), task with highest frequency
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (Character ch : map.keySet()) {
            int freq = map.get(ch);
            pq.offer(new Task(freq, 0));
        }


        // Queue stores tasks that are currently in COOLDOWN
        Queue<Task> q = new LinkedList<>();
        int time = 0;
        // Continue until:
        // 1. No available task is left
        // AND
        // 2. No task is waiting for cooldown
        while (!pq.isEmpty() || !q.isEmpty()) {

            // Move time forward by 1
            time++;
            // Check whether a waiting task is available
            if (!q.isEmpty() && q.peek().exetime <= time) {
                pq.offer(q.poll());
            }
            // Execute a task if one is available
            if (!pq.isEmpty()) {
                
                Task task = pq.poll(); // Take the task with the HIGHEST frequency
                task.freq--;
                // If this task still needs to be executed,
                // put it into cooldown
                if (task.freq > 0) {
                    task.exetime = time + n + 1;
                    // Put task into waiting queue
                    q.offer(task);
                }
            }
            // If pq is empty here,
            // it means there is no task available.
            //
            // We simply move time forward.
            // This represents an IDLE slot.
        }
        // Total time required to execute all tasks
        return time;
    }
}

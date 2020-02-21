package operateingSystem.shiyan1.osExpect3.job;

import java.util.LinkedList;
import java.util.Queue;


public class JobManager {
    /**
     * 任务队列
     */
    public static final Queue<Job> JOB_QUEUE = new LinkedList<>();


    static {
        //初始化任务
        Job job1 = new Job(1, 130);
        Job job2 = new Job(2, 60);
        Job job3 = new Job(3, 100);
        Job job4 = new Job(4, 200);
        Job job5 = new Job(5, 140);
        Job job6 = new Job(6, 60);
        Job job7 = new Job(7, 50);
        //初始化 任务队列
        JOB_QUEUE.add(job1);
        JOB_QUEUE.add(job2);
        JOB_QUEUE.add(job3);
        JOB_QUEUE.add(job4);
        JOB_QUEUE.add(job5);
        JOB_QUEUE.add(job6);
        JOB_QUEUE.add(job7);
    }
}

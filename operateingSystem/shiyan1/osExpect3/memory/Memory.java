package operateingSystem.shiyan1.osExpect3.memory;

import operateingSystem.shiyan1.osExpect3.job.Job;
import operateingSystem.shiyan1.osExpect3.job.Pause;

import java.util.*;


public class Memory {
    public static final List<Zone> ZONE_LIST = new LinkedList<>();
    public static final List<Zone> FREE_ZONELIST = new LinkedList<>();
    public static final List<Zone> BUSY_ZONELIST = new LinkedList<>();

    public static final Map<Job,Zone> JOB_ZONE_MAP=new HashMap<>();

    static {
        //初始化6个分区，其中一个是系统分区
        Zone SYSTEM_ZONE = new Zone(0, 1, 40);
        Zone USER_ZONE_1 = new Zone(40, 2, 256);
        Zone USER_ZONE_2 = new Zone(296, 3, 128);
        Zone USER_ZONE_3 = new Zone(424, 4, 64);
        Zone USER_ZONE_4 = new Zone(488, 5, 64);
        Zone USER_ZONE_5 = new Zone(552, 6, 88);
        //初始化系统空间
        BUSY_ZONELIST.add(SYSTEM_ZONE);
        //初始化全局列表
        ZONE_LIST.add(SYSTEM_ZONE);
        ZONE_LIST.add(USER_ZONE_1);
        ZONE_LIST.add(USER_ZONE_2);
        ZONE_LIST.add(USER_ZONE_3);
        ZONE_LIST.add(USER_ZONE_4);
        ZONE_LIST.add(USER_ZONE_5);
        //初始化空闲列表
        FREE_ZONELIST.add(USER_ZONE_1);
        FREE_ZONELIST.add(USER_ZONE_2);
        FREE_ZONELIST.add(USER_ZONE_3);
        FREE_ZONELIST.add(USER_ZONE_4);
        FREE_ZONELIST.add(USER_ZONE_5);
        //首次对空闲分区进行排序
        sortFreeZone();
    }

    /**
     * 对空闲分区进行排序，从小到大
     */
    public static void sortFreeZone() {
        FREE_ZONELIST.sort(Comparator.comparingInt(Zone::getSize));
    }

    public static void printFreeZone() {
        Pause.pause(20);
        System.out.println("**************************************");
        System.out.println("空闲分区情况如下：");
        Pause.pause(50);
        for (Zone zone : FREE_ZONELIST) {
            System.out.println(zone.toString());
        }
        System.out.println("**************************************");
    }
}

package algorithms.greedy.findJob;

import jdk.internal.dynalink.linker.ConversionComparator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/6 20:21
 */
public class FindJob {
  static class Job {
    int pi;
    int di;

    public Job(int di, int pi) {
      this.pi = pi;
      this.di = di;
    }

    public int getPi() {
      return pi;
    }

    public void setPi(int pi) {
      this.pi = pi;
    }

    public int getDi() {
      return di;
    }

    public void setDi(int di) {
      this.di = di;
    }
  }

  static class Person {
    int ai;
    int maxPi;

    public Person(int ai) {
      this.ai = ai;
    }

    public int getAi() {
      return ai;
    }

    public void setAi(int ai) {
      this.ai = ai;
    }

    public int getMaxPi() {
      return maxPi;
    }

    public void setMaxPi(int maxPi) {
      this.maxPi = maxPi;
    }
  }

  public static void getMaxPi(ArrayList<Job> jobList, ArrayList<Person> personList) {
    if (jobList.size() == 0 || personList.size() == 0) {
      return ;
    }

    jobList.sort(Comparator.comparingInt(Job::getPi));
    personList.sort(Comparator.comparingInt(Person::getAi));
    int maxPi = 0;
    Person tempPerson = null;
    Iterator<Person> iterator = personList.listIterator();

    tempPerson = iterator.next();

    for (Job job : jobList) {
      while (tempPerson.getAi() < job.getDi()) {
        tempPerson.setMaxPi(maxPi);
        if (iterator.hasNext()) {
          tempPerson = iterator.next();
        } else {
          break;
        }
      }

      if (!iterator.hasNext() && tempPerson.getAi() < job.getDi()) {
        tempPerson.setMaxPi(maxPi);
        tempPerson = null;
        break;
      }

      maxPi = Integer.max(maxPi, job.getPi());
    }

    if (tempPerson != null) {
      tempPerson.setMaxPi(maxPi);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String head = scanner.nextLine();
    int jobCount = Integer.parseInt(head.split(" ")[0]);
    int personCount = Integer.parseInt(head.split(" ")[1]);

    ArrayList<Job> jobList = new ArrayList<>();
    ArrayList<Person> personList = new ArrayList<>();

    while (jobCount-- != 0) {
      String[] tempJobInfo = scanner.nextLine().split(" ");
      jobList.add(new Job(Integer.parseInt(tempJobInfo[0]), Integer.parseInt(tempJobInfo[1])));
    }

    String[] personInfo = scanner.nextLine().split(" ");

    for (String item : personInfo) {
      personList.add(new Person(Integer.parseInt(item)));
      if (personCount-- == 0) {
        break;
      }
    }

    FindJob.getMaxPi(jobList, personList);

    for (Person person : personList) {
      System.out.println(person.getMaxPi());
    }
  }
}

package operateingSystem.shiyan1.osExpect3.job;


public class Job {
    private int jobId;
    private int memory;

    public Job(int jobId, int memory) {
        this.jobId = jobId;
        this.memory = memory;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", memory=" + memory +
                '}';
    }
}

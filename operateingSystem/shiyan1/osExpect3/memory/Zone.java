package operateingSystem.shiyan1.osExpect3.memory;


public class Zone {
    private int start;
    private int no;
    private int size;
    private boolean status;

    public Zone(int start, int no, int size) {
        this.start = start;
        this.no = no;
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "start=" + start +
                ", no=" + no +
                ", size=" + size +
                ", status=" + status +
                '}';
    }
}

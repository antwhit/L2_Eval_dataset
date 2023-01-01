class Student extends Person {

    private int stNum;

    private int status;

    private Supervisor mySupervisor;

    public Student(int stNum) {
        this.stNum = stNum;
        status = 0;
    }

    public int stNum() {
        return stNum;
    }

    public void enrol() {
        if (status == 0) status = 1;
    }

    void graduate() {
        if (status == 1) {
            removeSupervisor();
            status = 2;
        }
    }

    public void quit() {
        removeSupervisor();
        status = 3;
    }

    public boolean setSupervisor(Supervisor newSupervisor) {
        if (mySupervisor != null || status != 1) return (false);
        mySupervisor = newSupervisor;
        newSupervisor.mentees.add(this);
        return (true);
    }

    public boolean removeSupervisor() {
        if (mySupervisor == null) return (false);
        mySupervisor.mentees.remove(this);
        mySupervisor = null;
        return (true);
    }

    public String toString() {
        return ((name == null ? " " : name) + " status=" + status + " stNum=" + stNum + " Supervisor=" + (mySupervisor == null ? "nobody" : mySupervisor.toString()));
    }
}

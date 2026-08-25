package cesde.edu.ga.model;

public class Group {
    private Long groupId;
    private String code;
    private Long programId;
    private Long periodId;
    private String schedule;
    private String name;
    private Integer capacity;

    public Group() {
    }

    public Group(Long groupId, String code, Long programId, Long periodId, String schedule) {
        this.groupId = groupId;
        this.code = code;
        this.programId = programId;
        this.periodId = periodId;
        this.schedule = schedule;
        this.name = "";
        this.capacity = 30; // default capacity
    }

    public Group(Long groupId, String code, Long programId, Long periodId, String schedule, String name, Integer capacity) {
        this.groupId = groupId;
        this.code = code;
        this.programId = programId;
        this.periodId = periodId;
        this.schedule = schedule;
        this.name = name;
        this.capacity = capacity;
    }


    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}


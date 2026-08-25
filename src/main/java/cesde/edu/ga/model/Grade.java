package cesde.edu.ga.model;

public class Grade {
    private Long gradeId;
    private Long enrollmentId;
    private Long groupSubjectId;
    private Double finalScore;
    private String observations;

    public Grade() {
    }

    public Grade(Long gradeId, Long enrollmentId, Long groupSubjectId, Double finalScore, String observations) {
        this.gradeId = gradeId;
        this.enrollmentId = enrollmentId;
        this.groupSubjectId = groupSubjectId;
        this.finalScore = finalScore;
        this.observations = observations;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Long getGroupSubjectId() {
        return groupSubjectId;
    }

    public void setGroupSubjectId(Long groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}


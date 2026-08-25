package cesde.edu.ga.model;

public class Teacher extends Person {

    private Long teacherId;
    private String specialty;

    public Teacher() {
        super();
    }

    public Teacher(Long teacherId, Long userId, String documentType, String documentNumber, String firstName, String lastName, String status, String specialty) {
        super(userId, documentType, documentNumber, firstName, lastName, status);
        this.teacherId = teacherId;
        this.specialty = specialty;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        if (teacherId == null || teacherId <= 0) {
            throw new IllegalArgumentException("El id del profesor es obligatorio");
        }

        this.teacherId = teacherId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", userId=" + getUserId() +
                ", documentType='" + getDocumentType() + '\'' +
                ", documentNumber='" + getDocumentNumber() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", specialty='" + specialty + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}


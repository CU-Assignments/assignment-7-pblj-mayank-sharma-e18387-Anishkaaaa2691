public class StudentAttendance {
    private String name, date, status;

    public StudentAttendance(String name, String date, String status) {
        this.name = name;
        this.date = date;
        this.status = status;
    }

    // Getters
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}

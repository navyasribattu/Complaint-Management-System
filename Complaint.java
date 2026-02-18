public class Complaint {
    private int id;
    private String userName;
    private String description;
    private String status;

    public Complaint(int id, String userName, String description) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.status = "Registered";
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayComplaint() {
        System.out.println("Complaint ID: " + id);
        System.out.println("User Name: " + userName);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("----------------------------");
    }
}

package shoval.ask.studentapp;

public class Student {
    final String image;
    String name;
    String id;
    String phone;
    String address;
    boolean checked;

    public Student(String image, String name, String id, String phone, String address, boolean checked) {
        this.image = image;
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.checked = checked;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}

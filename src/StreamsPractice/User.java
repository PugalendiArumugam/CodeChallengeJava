package StreamsPractice;

public class User {
    public int id;
    public String fname;
    public String lname;

    public User(int i, String fn, String ln) {
        id = i;
        fname = fn;
        lname = ln;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}

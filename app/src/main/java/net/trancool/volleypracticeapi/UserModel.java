package net.trancool.volleypracticeapi;

public class UserModel
{
    private String fName, lName, email_add;

    public UserModel(String fName, String lName, String email_add)
    {
        this.fName = fName;
        this.lName = lName;
        this.email_add = email_add;
    }



    public String getEmail_add() {
        return email_add;
    }

    public void setEmail_add(String email_add) {
        this.email_add = email_add;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}

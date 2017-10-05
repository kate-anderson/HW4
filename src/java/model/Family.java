package model;

public class Family {
    private int familyID;
    private String famMemName;
    private int age;
    private String birthday;
    private String relation;

     public Family() {
        this.familyID = 0;
        this.famMemName = "";
        this.age = 0;
        this.birthday = "";
        this.relation = "";
    }

    public Family(int familyID, String famMemName, int age, String birthday, String relation) {
        this.familyID = familyID;
        this.famMemName = famMemName;
        this.age = age;
        this.birthday = birthday;
        this.relation = relation;
    }
    
    
    public int getFamilyID() {
        return familyID;
    }

    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    public String getFamMemName() {
        return famMemName;
    }

    public void setFamMemName(String famMemName) {
        this.famMemName = famMemName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Family{" + "familyID=" + familyID + ", famMemName=" + famMemName + ", age=" + age + ", birthday=" + birthday + ", relation=" + relation + '}';
    }
     
    
}

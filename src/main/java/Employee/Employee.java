/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

/**
 *
 * @author hardiksodhani
 */
public class Employee {
    private String Name;
    private int EmployeeID;
    private int Age;
    private String Gender;
    private String StartDate;
    private String Level;
    private String TeamInfo;
    private String PositionTitle;
    private String CellNumber;
    private String Email;
    private String Photo;
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public String getTeamInfo() {
        return TeamInfo;
    }

    public void setTeamInfo(String TeamInfo) {
        this.TeamInfo = TeamInfo;
    }

    public String getPositionTitle() {
        return PositionTitle;
    }

    public void setPositionTitle(String PositionTitle) {
        this.PositionTitle = PositionTitle;
    }

    public String getCellNumber() {
        return CellNumber;
        
    }
    
    public String getEmail() {
        return Email;
        
    }

    public void setCellNumber(String CellNumber) {
        this.CellNumber = CellNumber;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

            
   @Override
    public String toString(){
    return Name; 
    }
}

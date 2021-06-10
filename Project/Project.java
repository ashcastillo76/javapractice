public class Project{
    public String name;
    public String description;

    public Project(String n, String d){
        this.name = n;
        this.description = d;
    }

    public Project(){
    }

    public Project(String name){
        this.name= name;
    }

    // getter
    public String getName(){
        return name;
    }

    // setter
    public void setName(String projName){
        this.name = projName;
    }

    // getter
    public String getDesc(){
        return description;
    }

    // setter
    public void setDesc(String desc){
        this.description = desc;
    }

    public String showPitch(String name, String description){
        return elevatorPitch(name + " " + description);
    }

    // instance method to print name and description
    private String elevatorPitch(String pitch){
        return pitch;
    }

}
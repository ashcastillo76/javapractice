public class ProjectTest {
    public static void main(String[] args){
        Project funProject = new Project("fun", "this is such a fun project");
        System.out.println(funProject.name +" " + funProject.description);
        Project newProject = new Project();
        System.out.println(newProject.name);

        Project jude = new Project();

        jude.setName("Jude");
        jude.setDesc("this is a project for Jude");
        String judeProj = jude.getName();
        String judeDesc = jude.getDesc();
        System.out.println("This Project is called: " + judeProj + " Description: " + judeDesc);
    
        System.out.println(jude.showPitch("Jude", "This is Jude's Project"));
    
    } 
}

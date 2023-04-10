import department.*;

public class App {
    public static void main(String[] args) throws Exception {
        Department department = new Department("Lol");

        department.createWorker("A", "Smith1");
        department.createWorker("B", "Smith2");
        department.createWorker("D", "Smith3");
        department.createWorker("G", "Smith4");
        department.createWorker("E", "Smith5");
        department.createWorker("H", "Smith6");
        department.createWorker("C", "Smith7");
        department.createWorker("F", "Smith8");

        department.createProject("pr1", "pr1");
        department.addCollaborator("pr1", "A");
        department.addCollaborator("pr1", "B");
        department.addCollaborator("pr1", "D");

        department.createProject("pr2", "pr2");
        department.addCollaborator("pr2", "G");
        department.addCollaborator("pr2", "E");

        department.createProject("pr3", "pr3");
        department.addCollaborator("pr3", "E");
        department.addCollaborator("pr3", "H");

        department.createProject("pr4", "pr4");
        department.addCollaborator("pr4", "G");
        department.addCollaborator("pr4", "E");
        department.addCollaborator("pr4", "H");

        department.createProject("pr5", "pr5");
        department.addCollaborator("pr5", "A");
        department.addCollaborator("pr5", "B");
        department.addCollaborator("pr5", "C");

        department.createProject("pr6", "pr6");
        department.addCollaborator("pr6", "C");
        department.addCollaborator("pr6", "F");
        department.addCollaborator("pr6", "D");

        System.out.print(department.getConnectionCircle("A"));
    }
}

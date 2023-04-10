package department;

import java.util.HashSet;
import java.util.Set;

public class Project {
    String uid;
    String title;
    Set<String> collaborators;

    public Project(String id, String title){
        this.uid = id;
        this.title = title;
        this.collaborators = new HashSet<>();
    }

    public Set<String> getCollaborators(){
        return collaborators;
    }

    public boolean addCollaborators(String workerId) {
        if (collaborators.contains(workerId)) {
            return false;
        }

        collaborators.add(workerId);
        return true;
    }

    public boolean removeProject(String workerId) {
        return collaborators.remove(workerId);
    }
}

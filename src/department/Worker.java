package department;

import java.util.HashSet;
import java.util.Set;

public class Worker {
    String uid;
    String name;
    Set<String> projects;

    public Worker(String id, String name) {
        this.uid = id;
        this.name = name;
        projects = new HashSet<>();
    }

    public Set<String> getProjects() {
        return projects;
    }

    public boolean addProject(String projectId) {
        if (projects.contains(projectId)) {
            return false;
        }

        projects.add(projectId);
        return true;
    }

    public boolean removeProject(String projectId) {
        return projects.remove(projectId);
    }
}
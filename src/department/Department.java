package department;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Department {
    String name;
    Map<String, Worker> workers;
    Map<String, Project> projects;

    public Department(String name){
        this.name = name;
        workers = new HashMap<>();
        projects = new HashMap<>();
    }

    public Worker getWorker(String id) throws InvalidIDException{
        if(!workers.containsKey(id)){
            throw new InvalidIDException("There is no worker with such ID");
        }

        return workers.get(id);
    }

    public Project getProject(String id) throws InvalidIDException{
        if(!projects.containsKey(id)){
            throw new InvalidIDException("There is no worker with such ID");
        }

        return projects.get(id);
    }

    public Project createProject(String id, String title) throws InvalidIDException{
        if(projects.containsKey(id)){
            throw new InvalidIDException("The project with such ID already exists");
        }

        Project project = new Project(id, title);
        projects.put(id, project);

        return project;
    }

    public Worker createWorker(String id, String name) throws InvalidIDException{
        if(workers.containsKey(id)){
            throw new InvalidIDException("The project with such ID already exists");
        }

        Worker worker = new Worker(id, name);
        workers.put(id, worker);

        return worker;
    }

    public Project addCollaborator(String pID, String wID) throws InvalidIDException{
        if(!(projects.containsKey(pID) && workers.containsKey(wID))){
            throw new InvalidIDException("There is no such emplyee or project");
        }

        Project project = projects.get(pID);
        Worker worker = workers.get(wID);
        project.collaborators.add(worker.uid);

        return project;
    }

    public Set<String> getConnectionCircle(String wID){
        Set<String> idSet = workers.keySet();
        Map<String, Integer> distanceMap = new HashMap<>();

        for (String workerId : idSet){
            int distance = -1;
            if(wID == workerId) distance = 0;
            distanceMap.put(workerId, distance);
        }

        Queue<String> queueOfWorkers = new LinkedList<>();
        queueOfWorkers.add(wID);
        while(!queueOfWorkers.isEmpty()){
            String current = queueOfWorkers.poll();

            Set<String> projectSet = projects.keySet();
            for (String projectId : projectSet){
                Project project = projects.get(projectId);
                if(project.collaborators.contains(current)){
                    Iterator<String> collabs = project.collaborators.iterator();
                    while(collabs.hasNext()){
                        String workerId = collabs.next();
                        if(distanceMap.get(workerId) == -1){
                            distanceMap.put(workerId, distanceMap.get(current) + 1);
                            queueOfWorkers.add(workerId);
                        }
                    }
                }
            }
        }

        Set<String> adjacentWorkers = new HashSet<>();
        for(String worker: idSet){
            if(distanceMap.get(worker) > 0){
                adjacentWorkers.add(worker);
            }
        }

        return adjacentWorkers;
    }
}

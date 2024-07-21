package HW3.repository;

import HW3.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ProjectRepository {
    private static Long sequence = 1L;
    private final List<Project> projects = new ArrayList<>();

    public Optional<Project> getById(Long id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst();
    }

    public List<Project> getAll(){
        return List.copyOf(projects);
    }

    public Project create(Project project){
        project.setId(sequence++);
        projects.add(project);
        return project;
    }

//    public Project update(Long id, Project updatedProject){
//        Project existingProject = getById(id).get();
//        updatedProject.
//
//    }

    public void delete(Long id){
//        projects.removeIf(project -> project.getId().equals(id));
        projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst()
                .ifPresent(projects::remove);
    }
}
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

    public List<Project> findAll() {
        return new ArrayList<>(projects);
    }

    public Optional<Project> findById(Long id) {
        return projects.stream().filter(project -> project.getId().equals(id)).findFirst();
    }

    public Project save(Project project) {
        if (project.getId() == null) {
            project.setId(sequence++);
        } else {
            deleteById(project.getId());
        }
        projects.add(project);
        return project;
    }

    public void deleteById(Long id) {
        projects.removeIf(project -> project.getId().equals(id));
    }
}

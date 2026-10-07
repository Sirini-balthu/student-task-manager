package studenttaskmanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studenttaskmanger.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
package studenttaskmanger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import studenttaskmanger.entity.Task;
import studenttaskmanger.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task newTask) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(newTask.getTitle());
        existingTask.setDescription(newTask.getDescription());
        existingTask.setStatus(newTask.getStatus());
        existingTask.setDueDate(newTask.getDueDate());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
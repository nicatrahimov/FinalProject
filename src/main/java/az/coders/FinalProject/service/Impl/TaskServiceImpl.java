package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.TaskDtoConverter;
import az.coders.FinalProject.dto.request.TaskRequestDto;
import az.coders.FinalProject.dto.response.TaskResponseDto;
import az.coders.FinalProject.exception.TaskNotFound;
import az.coders.FinalProject.model.Task;
import az.coders.FinalProject.repository.TaskRepository;
import az.coders.FinalProject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDtoConverter taskDtoConverter;

    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDto> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(taskDtoConverter.convertToDto(task));
        }
        return dtos;
    }

    @Override
    public TaskResponseDto getTaskById(String id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFound("Task not found with id: " + id));
        return taskDtoConverter.convertToDto(task);
    }

    @Override
    public String addTask(TaskRequestDto task) {
        Task task1 = taskDtoConverter.convertToEntity(task);
        taskRepository.save(task1);
        return "Successfully added:" + task1.getId();
    }

    @Override
    public String deleteTask(String id) {
        taskRepository.findById(id).orElseThrow(() -> new TaskNotFound("Task not found with id: " + id));
        taskRepository.deleteById(id);
        return "Successfully deleted:" + id;
    }
}

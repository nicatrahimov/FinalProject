package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.request.TaskRequestDto;
import az.coders.FinalProject.dto.response.TaskResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskResponseDto> getAllTasks();

    TaskResponseDto getTaskById(String id);

    String addTask(TaskRequestDto task);

    String deleteTask(String id);
}

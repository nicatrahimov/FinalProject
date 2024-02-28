package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.ReminderDtoConverter;
import az.coders.FinalProject.dto.converter.TaskDtoConverter;
import az.coders.FinalProject.dto.request.TaskRequestDto;
import az.coders.FinalProject.dto.response.TaskResponseDto;
import az.coders.FinalProject.enums.Priority;
import az.coders.FinalProject.exception.TaskNotFound;
import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.model.Task;
import az.coders.FinalProject.repository.CaseRepository;
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
    private final ReminderDtoConverter reminderDtoConverter;
    private final CaseRepository caseRepository;

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
        if (task.getCaseId()==null){
            throw new NullPointerException("Case id can not be null");
        }
        Case aCase = caseRepository.findById(task.getCaseId()).orElseThrow(() -> new RuntimeException("Case not found with id: " + task.getCaseId()));
        Task task1 = taskDtoConverter.convertToEntity(task);
        task1.setACase(aCase);
        taskRepository.save(task1);
        return "Successfully added:" + task1.getId();
    }

    @Override
    public String deleteTask(String id) {
        if (id == null) {
            throw new NullPointerException("Id can not be null");
        }
        taskRepository.findById(id).orElseThrow(() -> new TaskNotFound("Task not found with id: " + id));
        taskRepository.deleteById(id);
        return "Successfully deleted:" + id;
    }

    @Override
    public String editTask(TaskRequestDto dto) {
        System.out.println(dto.getDueDate());
        if (dto.getId()==null){
            throw new NullPointerException("Id can not be null");
        }
        Task task =  taskRepository.findById(dto.getId()).orElseThrow(() -> new TaskNotFound("Task not found with id: " + dto.getId()));
        if (dto.getCaseId()!=null){
            Case aCase = caseRepository.findById(dto.getCaseId()).orElseThrow(() -> new RuntimeException("Case not found with id: " + dto.getCaseId()));
            task.setACase(aCase);
        }
        if (dto.getPriority()!=null){
            task.setPriority(Priority.valueOf(dto.getPriority()));
        }
        if (dto.getName()!=null){
            task.setName(dto.getName());
        }
        if (dto.getDescription()!=null){
            task.setDescription(dto.getDescription());
        }
        if (dto.getDueDate()!=null){
            task.setDueDate(dto.getDueDate());
        }
        if (dto.getReminder()!=null){
            task.setReminder(reminderDtoConverter.toEntity(dto.getReminder()));
        }
        taskRepository.save(task);
        return "Successfully edited:" + task.getId();

    }
}

package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.request.TaskRequestDto;
import az.coders.FinalProject.dto.response.TaskResponseDto;
import az.coders.FinalProject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable String id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody TaskRequestDto task) {
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> editTask(@RequestBody TaskRequestDto task) {
        return null;
    }
}

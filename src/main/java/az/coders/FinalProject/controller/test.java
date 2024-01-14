package az.coders.FinalProject.controller;

import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.model.Task;
import az.coders.FinalProject.repository.CaseRepository;
import az.coders.FinalProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    CaseRepository caseRepository;
    @Autowired
    TaskRepository taskRepository;
    @PostMapping("/case")
    public String addCase(@RequestBody Case aCase){
        caseRepository.save(aCase);
        return "salam";
    }

    @PostMapping("/task")
    public String addTask(@RequestBody Task task){
        taskRepository.save(task);
        return "salam";
    }
}

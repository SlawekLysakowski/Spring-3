package pl.edu.wszib.http2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.http2.service.ToDoService;
import pl.edu.wszib.http2.service.model.ToDo;
import pl.edu.wszib.http2.service.model.ToDoStatus;

@RequestMapping("/toDo")
@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;



    @GetMapping("/list")
    public String list(Model model) {
        ToDo toDo = new ToDo();
        toDo.setZadanie("cleaning");
        ToDoStatus toDoStatus = ToDoStatus.IN_PROGRESS;

        toDo.setTermin("Monday");
        toDoService.create(toDo);

        model.addAttribute("todoList", toDoService.list());  //przekaz list
        return "list-toDo"; //nazwa widoku
    }




}

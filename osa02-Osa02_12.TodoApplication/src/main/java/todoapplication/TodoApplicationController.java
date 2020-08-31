package todoapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoApplicationController {
    
    @Autowired
    private TodoRepository todoRepository;
    
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("items", this.todoRepository.findAll());
        return "index";
    }
    
    @GetMapping("/wipedb")
    public String wipedb() {
        this.todoRepository.deleteAll();
        return "redirect:/";
    }
    
    @GetMapping("/{id}")
    public String getSingleTask(Model model, @PathVariable Long id) {
        Todo todo = this.todoRepository.getOne(id);
        todo.setChecked(todo.getChecked() + 1);
        todo = this.todoRepository.save(todo);
        model.addAttribute("item", todo);
        return "todo";
    }
    
    @PostMapping("/")
    public String post(@RequestParam String name) {
        todoRepository.save(new Todo(name, 0));
        return "redirect:/";
    }
    
}

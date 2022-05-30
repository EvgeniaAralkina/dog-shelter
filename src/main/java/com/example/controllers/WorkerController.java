/*package com.example.controllers;
import com.example.Worker;
import com.example.dao.EmailService;
import com.example.dao.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerService workerService;

    @Autowired
    private EmailService emailService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("worker", workerService.index());
        return "worker_index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        System.out.println("controller " + id);
        model.addAttribute("worker", workerService.show(id));
        return "worker_show";
    }

    @GetMapping("/new")
    public String newWorker(@ModelAttribute("worker") Worker worker) {
        return "worker_new";
    }

    @PostMapping()
    public String create(@ModelAttribute("worker") Worker worker) {
        workerService.save(worker);
        emailService.sendEmail("new worker has been added:\n\tfirst name: "+
                worker.getFirstName()+"\n\tmiddle name: "+ worker.getMiddleName()+
                "\n\tlast name: " + worker.getLastName());
        return "redirect:/worker";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        System.out.println("deleteMapping");
        workerService.delete(id);
        return "redirect:/worker";
    }

    //pr17
    @GetMapping("/filteredByFirstName")
    public String getWorkerFilteredByFirstName(Model model){
        model.addAttribute("worker", workerService.getWorkerFilteredByFirstName());
        return "worker_index";
    }

    @GetMapping("/filteredByMiddleName")
    public String getWorkerFilteredByMiddleName(Model model){
        model.addAttribute("worker", workerService.getWorkerFilteredByMiddleName());
        return "worker_index";
    }

    @GetMapping("/filteredByLastName")
    public String getWorkerFilteredByLastName(Model model){
        model.addAttribute("worker", workerService.getWorkerFilteredByLastName());
        return "worker_index";
    }
}

 */
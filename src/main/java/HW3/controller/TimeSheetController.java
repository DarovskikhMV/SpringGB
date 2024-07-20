package HW3.controller;

import HW3.model.Timesheet;
import HW3.service.TimesheetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
public class TimeSheetController {

    // GET - получить  (не содержит "body" тела)
    //PUT - изменение
    // POST - создать
    //DELETE - удалить
    // PATCH - изменение частичное

    private final TimesheetService service;
    public TimeSheetController(TimesheetService service) {
        this.service = service;
    }

    @GetMapping("/{id}")   //получить по id
    //@GetMapping("/timesheets/{id}")   //получить по какой то либо записи например id
    public ResponseEntity<Timesheet>  get(@PathVariable Long id ) {

        Optional<Timesheet> ts = service.getById(id);
        if (ts.isPresent()) {
            return ResponseEntity.ok().body(ts.get());
           // return ResponseEntity.status(HttpStatus.OK).body(ts.get()); 2 способ
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping()   //получить все
    public List<Timesheet> getAll() {
        return service.getAll();
    }


    @PostMapping()  // создание нового ресурса
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {
       timesheet = service.create(timesheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  delete(@PathVariable Long id) {
         service.delete(id);
         //204 no Content
         return ResponseEntity.noContent().build();

    }

}


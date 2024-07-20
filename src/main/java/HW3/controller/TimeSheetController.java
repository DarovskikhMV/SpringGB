package HW3.controller;

import HW3.model.Timesheet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class TimeSheetController {

    // GET - получить  (не содержит "body" тела)
    //PUT - изменение
    // POST - создать
    //DELETE - удалить
    // PATCH - изменение частичное

    private final  List<Timesheet> timesheets = new ArrayList<>();
    private static Long sequence = 1L;

    @GetMapping("/timesheets/{id}")   //получить по id
    //@GetMapping("/timesheets/{id}")   //получить по какой то либо записи например id
    public ResponseEntity<Timesheet>  get(@PathVariable Long id ) {
        Optional<Timesheet> ts = timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
        if (ts.isPresent()) {
            return ResponseEntity.ok().body(ts.get());
           // return ResponseEntity.status(HttpStatus.OK).body(ts.get()); 2 способ
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/timesheets")   //получить все
    public List<Timesheet> getAll() {
        return timesheets;
    }


    @PostMapping("/timesheets")  // создание нового ресурса
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {
        timesheet.setId(sequence++);
        timesheets.add(timesheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
    }
    @DeleteMapping("/timesheets/{id}")
    public ResponseEntity<Void>  delete(@PathVariable Long id) {
         timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .ifPresent(timesheets::remove);
         //204 no Content
         return ResponseEntity.noContent().build();

    }

}


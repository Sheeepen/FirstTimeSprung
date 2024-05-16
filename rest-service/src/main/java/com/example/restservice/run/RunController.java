package com.example.restservice.run;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/runs")
public class RunController {

  private final RunRepository runRepo;

  @Autowired
  public RunController(RunRepository runRepo) {
    this.runRepo = runRepo;
  }

  @GetMapping("")
  public List<Run> findAll() {
    return runRepo.findAll();
  }

  @GetMapping("/{id}")
  public Run findById(@PathVariable Integer id) {
    Optional<Run> run = runRepo.findById(id);

    if (run.isEmpty()) {
      throw new RunNotFoundException();
    }

    return run.get();
  }

  @GetMapping("/location/{location}")
  List<Run> findByLocation(@PathVariable String location) {
    return runRepo.findByLocation(location);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@Valid @RequestBody Run run) {
    runRepo.save(run);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
    runRepo.save(run);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    runRepo.delete(runRepo.findById(id).get());
  }

}

package ch.becare.assessment.service.rest;

import ch.becare.assessment.dao.DataNotFoundException;
import ch.becare.assessment.dao.UserRepository;
import ch.becare.assessment.dao.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/user")
    User newEmployee(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(User.class,id));
    }
/*
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }*/

  //  @DeleteMapping("/employees/{id}")
   // void deleteEmployee(@PathVariable Long id) {
  //      repository.deleteById(id);
   // }
}
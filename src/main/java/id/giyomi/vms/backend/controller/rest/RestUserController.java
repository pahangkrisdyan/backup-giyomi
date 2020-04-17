package id.giyomi.vms.backend.controller.rest;

import id.giyomi.vms.backend.controller.rest.model.ResUser;
import id.giyomi.vms.backend.service.UserService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class RestUserController {

    private UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}")
    private ResponseEntity<ResUser> getUser(@PathVariable Long userId) {
        try{
            id.giyomi.vms.backend.entity.User user = userService.getUser(userId);
//            return ResponseEntity.ok(new ResponseOfGetUser(user.getUsername(), user.getEmail(), user.getTelepon(), user.getRole().getNama()));
            return ResponseEntity.ok(new ResUser(user.getId(), user.getUsername(), user.getEmail(), "telepon", user.getRole().getNama()));
        }catch (ResourceNotFoundException e){

            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "")
    private ResponseEntity<List<ResUser>> getUsers(@RequestParam(required = false) String role) {
        List<ResUser> response = new ArrayList<>();
        try{
            List<id.giyomi.vms.backend.entity.User> staffs = userService.getUsers(role);
            staffs.forEach(user -> {
//                response.add(new ResponseOfGetUser(user.getUsername(), user.getEmail(), user.getTelepon(), user.getRole().getNama()));
                response.add(new ResUser(user.getId(), user.getUsername(), user.getEmail(), "telepon", user.getRole().getNama()));
            });
            return ResponseEntity.ok(response);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

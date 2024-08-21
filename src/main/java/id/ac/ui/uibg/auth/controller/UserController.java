package id.ac.ui.uibg.auth.controller;

import id.ac.ui.uibg.auth.dto.ChangePasswordRequest;
import id.ac.ui.uibg.auth.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/change-password")
    public void changePassword(@Valid @RequestBody ChangePasswordRequest request) {
        userService.changePassword(request.getUsername(), request.getOldPassword(), request.getNewPassword());
    }
}

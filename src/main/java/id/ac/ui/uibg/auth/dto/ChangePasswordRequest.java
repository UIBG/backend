package id.ac.ui.uibg.auth.dto;

import id.ac.ui.uibg.auth.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Old password is mandatory")
    private String oldPassword;

    @ValidPassword
    @NotBlank(message = "New password is mandatory")
    private String newPassword;
}
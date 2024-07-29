package id.ac.ui.uibg.auth.dto;

import id.ac.ui.uibg.auth.validation.ValidPassword;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    @Email(message = "Email should be valid")
    private String email;
    @ValidPassword
    private String password;
}

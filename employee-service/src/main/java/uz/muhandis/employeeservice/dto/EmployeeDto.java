package uz.muhandis.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "EmployeeDto Model Information") //for openapi docs

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @Schema(description = "First Name") //for openapi docs
    @NotEmpty(message = "First name shouldn't be empty")
    private String firstName;
    @Schema(description = "Last name") //for openapi docs
    @NotEmpty(message = "Last name shouldn't be empty")
    private String lastName;
    @Schema(description = "Email") //for openapi docs
    @Email(message ="Email should be example@email.com" )
    private String email;
    @Schema(description = "Department Code") //for openapi docs
    @NotEmpty(message = "Department Code shouldn't be empty")
    private String departmentCode;
    @Schema(description = "Organization Code") //for openapi docs
    @NotEmpty(message = "Organization Code shouldn't be empty")
    private String organizationCode;
}

package uz.muhandis.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(description = "DepartmentDto Model Information") //for openapi docs

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema(description = "Department name") //for openapi docs
    @NotEmpty(message = "Department name shouldn't be empty!")
    private String departmentName;
    @Schema(description = "Department description") //for openapi docs
    @NotEmpty(message = "Department description shouldn't be empty!")
    private String departmentDescription;
    @Schema(description = "Department code") //for openapi docs
    @NotEmpty(message = "Department code shouldn't be empty!")
    private String departmentCode;
}

package uz.muhandis.departmentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    @NotEmpty(message = "Department name shouldn't be empty!")
    private String departmentName;
    @NotEmpty(message = "Department description shouldn't be empty!")
    private String departmentDescription;
    @NotEmpty(message = "Department code shouldn't be empty!")
    private String departmentCode;
}

package uz.muhandis.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



@Schema(description = "OrganizationDto Model Information")//for openapi docs

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;
    @Schema(description = "Organization Name") //for openapi docs
    private String organizationName;
    @Schema(description = "Organization Description")
    private String organizationDescription;
    @Schema(description = "Organization Code")
    private String organizationCode;
}

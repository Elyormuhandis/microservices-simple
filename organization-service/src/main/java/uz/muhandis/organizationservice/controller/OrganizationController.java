package uz.muhandis.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.organizationservice.dto.OrganizationDto;
import uz.muhandis.organizationservice.service.OrganizationService;


@Tag(
        name = "Organization Service - OrganizationController",
description = "Organization Controller Exposes REST APIs for Organization Service")

@RestController
@RequestMapping("api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @Operation(summary = "Save Organization REST API", description = "This is used to save Organization object in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }



    @Operation(summary = "Get Organization REST API", description = "This is used to get Organization object from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")


    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable(value = "code") String organizationCode) {
        OrganizationDto organization = organizationService.getOrganization(organizationCode);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }
}

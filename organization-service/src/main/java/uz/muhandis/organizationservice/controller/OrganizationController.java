package uz.muhandis.organizationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.organizationservice.dto.OrganizationDto;
import uz.muhandis.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @GetMapping("orragization/{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable(value = "code") String organizationCode) {
        OrganizationDto organization = organizationService.getOrganization(organizationCode);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }
}

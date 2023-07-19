package uz.muhandis.organizationservice.service;

import uz.muhandis.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganization(String organizationCode);
}

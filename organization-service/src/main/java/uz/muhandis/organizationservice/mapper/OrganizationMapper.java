package uz.muhandis.organizationservice.mapper;

import uz.muhandis.organizationservice.dto.OrganizationDto;
import uz.muhandis.organizationservice.entity.Organization;


public class OrganizationMapper {
    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode()
        );
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        organization.setOrganizationName(organizationDto.getOrganizationName());
        organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
        organization.setOrganizationCode(organizationDto.getOrganizationCode());
        return organization;
    }
}

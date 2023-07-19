package uz.muhandis.organizationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhandis.organizationservice.dto.OrganizationDto;
import uz.muhandis.organizationservice.entity.Organization;
import uz.muhandis.organizationservice.mapper.OrganizationMapper;
import uz.muhandis.organizationservice.repository.OrganizationRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto getOrganization(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode).orElseThrow(()->new RuntimeException("Organization not found"));
        return OrganizationMapper.mapToOrganizationDto(organization);
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }
}

package uz.muhandis.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "department_name", nullable = false)
    private String departmentName;
    @Column(name = "department_description", nullable = false)
    private String departmentDescription;
    @Column(name = "department_code", nullable = false)
    private String departmentCode;
}

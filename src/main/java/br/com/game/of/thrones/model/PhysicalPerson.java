package br.com.game.of.thrones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class PhysicalPerson extends Person {

    @NotNull(message = "FullName cannot be Null")
    @NotEmpty(message = "CPF cannot be Null or Empty")
    @Size(min = 11, max = 11, message = "CPF must be have 14 numbers")
    @CPF(message = "CPF is invalid.")
    private String cpf;
    @NotNull(message = "FullName cannot be Null")
    @NotBlank(message = "FullName cannot be only whitespace")
    @NotEmpty(message = "FullName cannot be Null or Empty")
    @Size(min = 3, message = "FullName must be have atleast 3 characteres")
    private String fullName;
    @Past(message = "Birthdate can not be a future date")
    private LocalDate birthdate;
}

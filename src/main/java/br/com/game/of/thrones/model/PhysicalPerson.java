package br.com.game.of.thrones.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@ApiModel(description = "All details about PhysicalPerson")
public class PhysicalPerson extends Person {

    @NotNull(message = "FullName cannot be Null")
    @NotEmpty(message = "CPF cannot be Null or Empty")
    @Size(min = 11, max = 11, message = "CPF must be have 14 numbers")
    @CPF(message = "CPF is invalid.")
    @ApiModelProperty(notes = "CPF must be valid, cannot be Null, Empty, only whitespaces and must be have 11 characteres.")
    private String cpf;
    @NotNull(message = "FullName cannot be Null")
    @NotBlank(message = "FullName cannot be only whitespace")
    @NotEmpty(message = "FullName cannot be Null or Empty")
    @Size(min = 3, message = "FullName must be have atleast 3 characteres")
    @ApiModelProperty(notes = "FullName cannot be Null, Empty, only whitespaces and must be have atleast 3 characteres.")
    private String fullName;
    @Past(message = "Birthdate should be in the past")
    @ApiModelProperty(notes = "Birthdate should be in the past")
    private LocalDate birthdate;
}

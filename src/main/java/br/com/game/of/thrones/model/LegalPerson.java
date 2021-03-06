package br.com.game.of.thrones.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@ApiModel(description = "All details about LegalPerson")
public class LegalPerson extends Person {

    @NotNull(message = "CNPJ cannot be Null")
    @NotEmpty(message = "CNPJ cannot be Empty")
    @Size(min = 14, max = 14, message = "CNPJ must be have 14 numbers")
    @CNPJ(message = "CNPJ is invalid")
    @ApiModelProperty(notes = "CNPJ must be valid, cannot be Null, Empty, only whitespaces and must be have 14 characteres.")
    private String cnpj;
    @NotNull(message = "SocialReason cannot be Null")
    @NotBlank(message = "SocialReason cannot be only whitespace")
    @NotEmpty(message = "SocialReason cannot be Null or Empty")
    @Size(min = 3, message = "SocialReason must be have atleast 3 characteres")
    @ApiModelProperty(notes = "SocialReason cannot be Null, Empty, only whitespaces and must be have atleast 3 characteres.")
    private String socialReason;
    @NotNull(message = "FantasyName cannot be Null")
    @NotBlank(message = "FantasyName cannot be only whitespace")
    @NotEmpty(message = "FantasyName cannot be Null or Empty")
    @Size(min = 3, message = "FantasyName must be have atleast 3 characteres")
    @ApiModelProperty(notes = "FantasyName cannot be Null, Empty, only whitespaces and must be have atleast 3 characteres.")
    private String fantasyName;
}

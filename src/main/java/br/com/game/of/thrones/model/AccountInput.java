package br.com.game.of.thrones.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(description = "All Details about AccountInput")
public class AccountInput {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Account cannot be null")
    @ManyToOne
    @ApiModelProperty(notes = "Account cannot be null")
    private Account account;
    @NotNull(message = "Code cannot be null")
    @NotBlank(message = "Code cannot be only whitespace")
    @NotEmpty(message = "Code cannot be Null or Empty")
    @Size(min = 3, message = "Code must be have atleast 3 characteres")
    @Column(unique = true)
    @ApiModelProperty(notes = "Code is Unique, cannot be Null, Empty, only whitespaces and must be have atleast 3 characteres.")
    private String code;
    @NotNull(message = "CreatedDate cannot be null")
    @ApiModelProperty(notes = "CreatedDate cannot be null")
    private LocalDateTime createdDate;
    @NotNull(message = "Value cannot be null")
    @ApiModelProperty(notes = "Value cannot be null")
    private BigDecimal value;
    @NotNull(message = "TransactionType cannot be null")
    @ApiModelProperty(notes = "TransactionType cannot be null")
    private TransactionType transactionType;
    @ManyToOne
    private AccountInput accountInput;

}

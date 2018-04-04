package br.com.game.of.thrones.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class AccountInput {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Account cannot be null")
    @ManyToOne
    private Account account;
    @NotNull(message = "Code cannot be null")
    @NotBlank(message = "Code cannot be only whitespace")
    @NotEmpty(message = "Code cannot be Null or Empty")
    @Size(min = 3, message = "Code must be have atleast 3 characteres")
    private String code;
    @NotNull(message = "CreatedDate cannot be null")
    private LocalDateTime createdDate;
    @NotNull(message = "Value cannot be null")
    private BigDecimal value;
    @NotNull
    private TransactionType transactionType;
    @ManyToOne
    private AccountInput accountInput;

}

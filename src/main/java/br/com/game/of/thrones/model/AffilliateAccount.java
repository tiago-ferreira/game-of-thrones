package br.com.game.of.thrones.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@ApiModel(description = "All details about AffilliateAccount")
public class AffilliateAccount extends Account {

    @NotNull(message = "The Parent Account cannot be null")
    @ManyToOne
    @ApiModelProperty(notes = "The Parent Account cannot be null")
    private Account account;

    public AffilliateAccount(String name, BigDecimal balance, AccountStatus status, Account account) {
        super(null, name, LocalDateTime.now(), balance, status, null);
        this.account = account;
    }
}

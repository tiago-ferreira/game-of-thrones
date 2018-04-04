package br.com.game.of.thrones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transfer {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "The Origin account cannot be null")
    @ManyToOne
    private AffilliateAccount origin;
    @NotNull(message = "The Destiny account cannot be null")
    @ManyToOne
    private AffilliateAccount destiny;
    @NotNull(message = "Value cannot be null")
    private BigDecimal value;
    @NotNull(message = "TransferDate cannot be null")
    private LocalDateTime transferDate;
    @NotNull(message = "TransactionType cannot be null")
    private TransactionType transactionType;
    @ManyToOne
    private Transfer transferReference;
}

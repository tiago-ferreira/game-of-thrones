package br.com.game.of.thrones.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = "affilliateAccounts")
@ToString(exclude = "affilliateAccounts")
@ApiModel(description = "All Details about Account")
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Name cannot be Null")
    @NotBlank(message = "Name cannot be only whitespace")
    @NotEmpty(message = "Name cannot be Null or Empty")
    @Size(min = 3, message = "Name must be have atleast 3 characteres")
    @ApiModelProperty(notes = "Name cannot be Null, Empty, only whitespaces and must be have atleast 3 characteres.")
    private String name;
    private LocalDateTime createdDate;

    private BigDecimal balance;
    private AccountStatus status;

    @OneToMany()
    private List<AffilliateAccount> affilliateAccounts;


}

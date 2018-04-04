package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AffilliateAccount;
import br.com.game.of.thrones.model.TransactionType;
import br.com.game.of.thrones.model.Transfer;
import br.com.game.of.thrones.repository.AffilliateAccountRepository;
import br.com.game.of.thrones.repository.TransferRepository;
import br.com.game.of.thrones.service.interfaces.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AffilliateAccountRepository affilliateAccountRepository;


    @Override
    public void deposit(Transfer transfer) {
        AffilliateAccount origin = validAndReturnOriginAccount(transfer);
        AffilliateAccount destiny = validAndReturnDestinyAccount(transfer);
        transfer.setTransferDate(LocalDateTime.now());
        transfer.setTransactionType(TransactionType.DEPOSIT);
        origin.setBalance(subtract(origin.getBalance(), transfer.getValue()));
        destiny.setBalance(sum(destiny.getBalance(), transfer.getValue()));
        affilliateAccountRepository.save(origin);
        affilliateAccountRepository.save(destiny);
        transferRepository.save(transfer);
    }

    @Override
    public void reversal(Long idTransfer) {
        Optional<Transfer> transfer = transferRepository.findById(idTransfer);
        if(!transfer.isPresent()) {
            throw new ResourceNotFoundException("Transfer", "id", idTransfer);
        }
        BigDecimal value = transfer.get().getValue();
        AffilliateAccount origin = transfer.get().getOrigin();
        AffilliateAccount destiny = transfer.get().getDestiny();
        origin.setBalance(sum(origin.getBalance(), value));
        destiny.setBalance(subtract(destiny.getBalance(), value));
        affilliateAccountRepository.save(origin);
        affilliateAccountRepository.save(destiny);
        Transfer newTransfer = new Transfer(null, origin, destiny, value, LocalDateTime.now(), TransactionType.REVERSAL, transfer.get());
        transferRepository.save(newTransfer);
    }

    @Override
    public Transfer read(Long id) {
        return transferRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Transfer", "id", id));
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }


    private BigDecimal subtract(BigDecimal valueOne, BigDecimal valueTwo) {
        return valueOne.subtract(valueTwo);
    }

    private BigDecimal sum(BigDecimal valueOne, BigDecimal valueTwo) {
        return valueOne.add(valueTwo);
    }

    private AffilliateAccount validAndReturnOriginAccount(Transfer transfer) {
        Optional<AffilliateAccount> origin = affilliateAccountRepository.findById(transfer.getOrigin().getId());
        if(origin.isPresent()) transfer.setOrigin(origin.get());
        return origin.filter( o -> o.getBalance().compareTo(transfer.getValue()) >= 0 )
                .orElseThrow( () -> new RuntimeException("The source account does not have enough money for this transaction"));
    }

    private AffilliateAccount validAndReturnDestinyAccount(Transfer transfer) {
        Optional<AffilliateAccount> destiny = affilliateAccountRepository.findById(transfer.getDestiny().getId());
        return destiny.filter( d -> d.getAccount().getId() == transfer.getOrigin().getId()).orElseThrow( () -> new RuntimeException("The destiny account isn't linked to origin account"));
    }
}

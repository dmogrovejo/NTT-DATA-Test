package com.nttdata.test.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.test.model.Account;

/**
 * @author David Mogrovejo
 */
@Repository
public interface IAccountRepository extends CrudRepository<Account, Long>{

	
	public Optional<Account> findByAccountNumber(String accountNumber);
}

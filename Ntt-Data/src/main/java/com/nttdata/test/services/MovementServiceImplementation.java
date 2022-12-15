package com.nttdata.test.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.test.dto.ReportDTO;
import com.nttdata.test.model.Movement;
import com.nttdata.test.repository.IMovementRepository;

/**
 * @author David Mogrovejo
 */
@Service
public class MovementServiceImplementation implements IMovementService{

	@Autowired
	private IMovementRepository repositoryMovement;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movement> findAll() {
		return (List<Movement>) repositoryMovement.findAll();
	}

	@Override
	@Transactional
	public Movement save(Movement client) {		
		return repositoryMovement.save(client);
	}

	@Override
	@Transactional
	public void delete(String id) {
		repositoryMovement.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Movement findById(String id) {
		return repositoryMovement.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<BigDecimal> getBalance( Long accountId) {
		return repositoryMovement.getBalance(accountId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<BigDecimal> getBalanceDebit( Long accountId, Date dateMovement) {
		return repositoryMovement.getBalanceDebit(accountId, dateMovement);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ReportDTO> getMovements(Date fromDate, Date toDate){
		return repositoryMovement.getMovements(fromDate, toDate);
	}
	
	
}

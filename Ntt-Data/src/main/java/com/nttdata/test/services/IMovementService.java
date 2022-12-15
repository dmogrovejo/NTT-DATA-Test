package com.nttdata.test.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nttdata.test.dto.ReportDTO;
import com.nttdata.test.model.Movement;

/**
 * @author David Mogrovejo
 */
@Service
public interface IMovementService {
	
	public List<Movement> findAll();
	
	public Movement save(Movement movement);
	
	public void delete(String id);
	
	public Movement findById(String id);
	
	public Optional<BigDecimal> getBalance( Long accountId);
	
	public Optional<BigDecimal> getBalanceDebit( Long accountId, Date dateMovement);
	
	public List<ReportDTO> getMovements( Date fromDate, Date toDate);
	
}

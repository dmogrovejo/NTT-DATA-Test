package com.nttdata.test.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nttdata.test.dto.ReportDTO;
import com.nttdata.test.model.Movement;

/**
 * @author David Mogrovejo
 */
@Repository
public interface IMovementRepository extends CrudRepository<Movement, String>{

	@Query(value = "SELECT  SUM(VALUE) FROM MOVEMENT WHERE ACCOUNT_ID = :accountId", nativeQuery = true)
	public Optional<BigDecimal> getBalance(@Param("accountId") Long accountId);
	
	@Query(value = "SELECT SUM(ABS(VALUE)) "
			+ "FROM MOVEMENT "
			+ " WHERE "
			+ " ACCOUNT_ID = :accountId "
			+ " AND MOVEMENT_TYPE='DEBITO' "
			+ " AND  DATE_MOVEMENT = :dateMovement", nativeQuery = true)
	public Optional<BigDecimal> getBalanceDebit(@Param("accountId") Long accountId, @Param("dateMovement") Date dateMovement);
	
	
	
	
	@Query(value = "select  new com.nttdata.test.dto.ReportDTO ( "
			+ "	to_char(m.dateMovement, 'dd-mm-yyyy') as fecha, "
			+ "	c.name as cliente, "
			+ "	a.accountNumber as numeroCuenta ,"
			+ "	a.accountType as tipoCuenta,"
			+ "	a.inicialBalance as saldoInicial, "
			+ "	a.status as estado,"
			+ "	m.movementType as tipoMovimiento, "
			+ "	m.value as movimiento,"
			+ "	m.balance as saldoDisponible) "
			+ " from Movement m  "
			+ " left join  m.account a  "
			+ " left join  a.client c "
			+ " where m.dateMovement  between :fromDate AND :toDate")
	public List<ReportDTO> getMovements(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	
	
	
}

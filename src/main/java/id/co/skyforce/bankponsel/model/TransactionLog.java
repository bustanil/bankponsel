package id.co.skyforce.bankponsel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="transaction_log")
public class TransactionLog {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private int transactionId;
	
	@Column(name = "transaction_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
		
	@Column(name = "amount", nullable = false, precision = 15, scale = 2)
	private BigDecimal amount;
	
	@ManyToOne (fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "account_no")  
	private VirtualAccount virtualAccount;
	
	@Column(name="db_cr", nullable =false,length=1)
	private Character dbCr;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public VirtualAccount getVirtualAccount() {
		return virtualAccount;
	}

	public void setVirtualAccount(VirtualAccount virtualAccount) {
		this.virtualAccount = virtualAccount;
	}

	public Character getDbCr() {
		return dbCr;
	}

	public void setDbCr(Character dbCr) {
		this.dbCr = dbCr;
	}
	
	
}

package id.co.skyforce.bankponsel.model;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="virtual_account")
public class VirtualAccount {
	
	
	@Id
	@Column(name="account_no", nullable=true, length=15)
	private String accountNo;
	
	@Column(name="balance", nullable=false)
	private BigDecimal balance;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserProfile userProfile;
	
	@OneToMany(mappedBy = "virtualAccount") // default lazy
	private Set<TransactionLog> transactionLog = new HashSet<>();
//	@OneToMany(mappedBy="virtual_account")
//	private Set<TransactionLog> transaction_log = new HashSet<>();

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Set<TransactionLog> getTransactionLog() {
		return transactionLog;
	}

	public void setTransactionLog(Set<TransactionLog> transactionLog) {
		this.transactionLog = transactionLog;
	}

	

}

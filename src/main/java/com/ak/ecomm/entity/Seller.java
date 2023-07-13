package com.ak.ecomm.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedNativeQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name = "Seller.sellerDetails", query = "select * from Seller where email=?1 and password=?2", resultClass = Seller.class)
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;
	private String sellerName;
	private String password;
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "SELLER_ROLE", joinColumns = { @JoinColumn(name = "SELLER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_NAME") })
	private Set<Role> role;

	
}

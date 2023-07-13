package com.ak.ecomm.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.JwtSellerRequest;
import com.ak.ecomm.entity.JwtSellerResponse;
import com.ak.ecomm.entity.JwtUserRequest;
import com.ak.ecomm.entity.JwtUserResponse;
import com.ak.ecomm.entity.Seller;
import com.ak.ecomm.entity.User;
import com.ak.ecomm.repository.SellerRepository;
import com.ak.ecomm.repository.UserRepository;
import com.ak.ecomm.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	public JwtUserResponse createUserJwtToken(JwtUserRequest jwtRequest) throws Exception {
		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getPassword();
		authenticate(userName, userPassword);
		UserDetails userDetails = loadUserByUsername(userName);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);

		List<User> findByUserName = userRepository.findByUserName(userName);
		return new JwtUserResponse(findByUserName.get(0), newGeneratedToken);
	}

	public JwtSellerResponse createSellerJwtToken(JwtSellerRequest jwtRequest) throws Exception {
		String sellerName = jwtRequest.getSellerName();
		String userPassword = jwtRequest.getPassword();
		authenticate(sellerName, userPassword);
		UserDetails userDetails = loadUserByUsername(sellerName);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);

		List<Seller> findBySellerName = sellerRepository.findBySellerName(sellerName);
		return new JwtSellerResponse(findBySellerName.get(0), newGeneratedToken);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<User> findByUserName = userRepository.findByUserName(userName);
		List<Seller> findBySellerName = sellerRepository.findBySellerName(userName);

		if (!findByUserName.isEmpty()) {
			User user = findByUserName.get(0);
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
					getAuthorityforUser(user));
		} else if (!findBySellerName.isEmpty()) {
			Seller seller = findBySellerName.get(0);
			return new org.springframework.security.core.userdetails.User(seller.getSellerName(), seller.getPassword(),
					getAuthorityforSeller(seller));
		}

		else {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
	}

	private Set<SimpleGrantedAuthority> getAuthorityforUser(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});
		return authorities;
	}

	private Set<SimpleGrantedAuthority> getAuthorityforSeller(Seller seller) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		seller.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});
		return authorities;
	}

	private void authenticate(String userName, String userPassword) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
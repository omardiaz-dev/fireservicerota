package com.conem.layouts.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountService implements UserDetailsService {
	
	public static Account globalUser =null;
	
	public static String ADMIN_ROLE ="ADMIN_ROLE";
	public static String USER_ROLE ="USER_ROLE";
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	protected void initialize() {
		System.out.println("--------------PostContruct annotation - Saving Account -----------------------");
		save(new Account("commander@gmail.com", "1234", "USER_ROLE"));
		save(new Account("driver@gmail.com", "1234", "USER_ROLE"));
		save(new Account("backseat1@gmail.com", "1234", "USER_ROLE"));
		save(new Account("backseat2@gmail.com", "1234", "USER_ROLE"));
		save(new Account("admin@gmail.com", "1234", "ADMIN_ROLE"));
	}

	@Transactional
	public Account save(Account account) {
		Account dbAccount = accountRepository.findOneByEmail(account.getEmail());
		if(dbAccount == null) {
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			accountRepository.save(account);
		}
		
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findOneByEmail(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(account);
	}
	
	public void signin(Account account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	private Authentication authenticate(Account account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));
	}
	
	private User createUser(Account account) {
		return new User(account.getEmail(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(Account account) {
		globalUser =account;
		return new SimpleGrantedAuthority(account.getRole());
	}
	
	
	public static boolean isAdmin() {
		boolean isAdmin = false;
		if (globalUser == null) {
			return false;
		}
		
		if( ADMIN_ROLE.equals(globalUser.getRole())){
			isAdmin = true;
		}
		
		return isAdmin;
	}

}

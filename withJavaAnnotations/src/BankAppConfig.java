package com.capgemini.bankapp.config;

import java.sql.Connection;

import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;
import org.springframework.context.annotation.*;
import com.capgemini.bankapp.util.DbUtil;
import com.capgemini.bankapp.bankapp.dao.*;
import com.capgemini.bankapp.bankapp.dao.impl.*;


@Configuration
public class BankAppConfig{

	@Bean
	public BankAccountDao bankAccountDao(){
		BankAccountDaoImpl bankAccountDaoImpl = new BankAccountDaoImpl(connection());
		return bankAccountDaoImpl;
	}

	@Bean 
	public BankAccountServiceImpl bankAccountServiceImpl(){
		BankAccountServiceImpl bankAccountServiceImpl = new BankAccountServiceImpl(bankAccountDao());
		return bankAccountServiceImpl;
	}

	@Bean
	public Connection connection(){
		Connection connection=DbUtil.getConnection();
		return connection;
	}
	

	

}
package com.qa.persistence.repository.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.AccountServiceImpl;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";
	
	@InjectMocks
	AccountServiceImpl serviceImpl;
	
	@Mock
	private AccountRepository repo;
	
	@Before
	public void setup() {
		serviceImpl.setRepo(repo);
	}
	

	@Test
	public void testGetAllAccounts() {
		Mockito.when(repo.getAllAccounts()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, serviceImpl.getAllAccounts());
		
	
	}

	@Test
	public void testAddAccount() {
		Mockito.when(repo.createAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, serviceImpl.addAccount(MOCK_VALUE2));
		Mockito.verify(repo).createAccount(MOCK_VALUE2);
		
	}

	@Test
	public void testUpdateAccount() {
		Mockito.when(repo.updateAccount(1L,MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, serviceImpl.updateAccount(1L,MOCK_VALUE2));
		Mockito.verify(repo).updateAccount(1L,MOCK_VALUE2);
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(repo.deleteAccount(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE,serviceImpl.deleteAccount(1L));
		Mockito.verify(repo).deleteAccount(1L);
	}
}

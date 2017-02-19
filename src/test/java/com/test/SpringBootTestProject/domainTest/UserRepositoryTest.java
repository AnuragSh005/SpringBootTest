package com.test.SpringBootTestProject.domainTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.SpringBootTestProject.domain.User;
import com.test.SpringBootTestProject.domain.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional(propagation=Propagation.NEVER)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Rule
	public ExpectedException thrown=ExpectedException.none();
	
	@Test
	public void findByUsernameShouldGiveUserObject(){
		User user=new User("1","ansh");
		this.entityManager.persist(user);
		User user1=this.userRepository.findByUsername("anurag");
		assertThat(user1.getId()).contains("1");
	}
	
	@Test
	public void findByIdShouldGiveUserObjectWhenGivenWrongId(){
		this.entityManager.persist(new User("1", "anurag"));
		thrown.expect(NullPointerException.class);
		User user=this.userRepository.findByUsername("an");
		assertThat(user.getId()).contains("1");
	} 
}

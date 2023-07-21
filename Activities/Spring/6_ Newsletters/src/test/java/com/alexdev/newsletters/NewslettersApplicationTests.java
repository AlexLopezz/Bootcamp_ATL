package com.alexdev.newsletters;

import com.alexdev.newsletters.validators.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewslettersApplicationTests {
	EmailValidator ev;

	@BeforeEach
	void initTest(){
		ev = new EmailValidator();
	}

	@Test
	@DisplayName("Email debe contener arroba(@)")
	void testAt() {
		boolean valid = ev.isValid("asda@sda.com");
		System.out.println("valid = " + valid);

		assertTrue(ev.isValid("asda@sda.com"));
	}

	@Test
	@DisplayName("Email debe contener un punto(.)")
	void testDot(){
		assertTrue(ev.isValid("asdadad@vgnk.com"));
	}

	@Test
	@DisplayName("Email no debe terminar con un punto(.)")
	void testFinalWithDot(){
		assertTrue(ev.isValid("asdsad@as.dsa"),"El email termina con un punto.");
	}

}

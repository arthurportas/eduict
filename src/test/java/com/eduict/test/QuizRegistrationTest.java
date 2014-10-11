package com.eduict.test;

import com.eduict.controller.QuizRegistration;
import com.eduict.model.Quiz;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class QuizRegistrationTest {
   /*@Deployment
   public static Archive<?> createTestArchive() {
      return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClasses(Quiz.class, QuizRegistration.class, Resources.class)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            // Deploy our test datasource
            .addAsWebInfResource("test-ds.xml", "test-ds.xml");
   }*/

    @Inject
    QuizRegistration quizRegistration;

   @Inject
   Logger log;
   
   @Test
   public void testRegister() throws Exception {
      Quiz newQuiz= quizRegistration.getNewQuiz();
      quizRegistration.register();
      assertNotNull(newQuiz.getId());
      assertEquals("Quiz", newQuiz.getDescription());
      log.info(newQuiz.getDescription() + " was persisted with id " + newQuiz.getId());
   }
   
}

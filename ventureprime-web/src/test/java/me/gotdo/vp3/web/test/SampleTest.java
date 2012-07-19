package me.gotdo.vp3.web.test;

import static org.junit.Assert.*;

import java.util.UUID;

import me.gotdo.vp3.web.model.Survey;
import me.gotdo.vp3.web.repository.SurveyRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/SampleTest-context.xml"})
public class SampleTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private SurveyRepository surveyDao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void canCreateAndSaveSurvey() {
		
		// Create random survey name
		UUID idOne = UUID.randomUUID();
		String surveyName = "survey_" + idOne.toString();
		
		Survey survey = new Survey();
		survey.setSurveyName(surveyName);
		assertNull(survey.getSurveyId());
		
		survey = surveyDao.save(survey);
		assertNotNull(survey);
		assertNotNull(survey.getSurveyId());
		assertEquals(surveyName, survey.getSurveyName());
		
		String id = survey.getSurveyId();
		Survey retrieved = surveyDao.findOne(id);
		assertNotNull(retrieved);
		assertEquals(survey.getSurveyId(), retrieved.getSurveyId());
		assertEquals(survey.getSurveyName(), retrieved.getSurveyName());
	}

}

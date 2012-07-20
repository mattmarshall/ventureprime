package me.gotdo.vp3.web.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.gotdo.vp3.web.model.Survey;
import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.SurveyRepository;
import me.gotdo.vp3.web.repository.VPUserRepository;

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
	
	@Autowired
	private VPUserRepository userRepo;

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
		String friendlyName = "survey_" + idOne.toString();
		
		Random random = new Random();
		long schemaVersion = random.nextLong();
		long documentVersion = random.nextLong();
		
		Survey survey = new Survey();
		survey.setFriendlyName(friendlyName);
		survey.getMetadata().setSchemaVersion(schemaVersion);
		survey.getMetadata().setDocumentVersion(documentVersion);
		assertNull(survey.getId());
		
		survey = surveyDao.save(survey);
		
		assertNotNull(survey);
		assertNotNull(survey.getId());
		assertNotNull(survey.getMetadata());
		assertEquals(survey.getMetadata().getSchemaVersion(), schemaVersion);
		assertEquals(survey.getMetadata().getDocumentVersion(), documentVersion);
		assertEquals(friendlyName, survey.getFriendlyName());
		
		String id = survey.getId();
		Survey retrieved = surveyDao.findOne(id);
		assertNotNull(retrieved);
		assertEquals(survey.getId(), retrieved.getId());
		assertEquals(survey.getFriendlyName(), retrieved.getFriendlyName());
		assertNotNull(retrieved.getMetadata());
		assertEquals(retrieved.getMetadata().getSchemaVersion(), schemaVersion);
		assertEquals(retrieved.getMetadata().getDocumentVersion(), documentVersion);
	}
	
	@Test
	public void canUpdate() {
		List<Survey> surveys = surveyDao.findAll();
		for (Survey survey : surveys) {
			Survey newSurvey = (Survey) survey.upgradeTo(0);
			surveyDao.save(newSurvey);
		}
	}
	
	@Test
	public void createUsers() {
		
		// Create mmarshall
		VPUser mmarshall = userRepo.findOne("mmarshall");
		if (mmarshall == null) {
			mmarshall = new VPUser();
			mmarshall.setId("mmarshall");
			mmarshall.setActive(true);
			mmarshall.setCredentials("1234");
			userRepo.save(mmarshall);
		}
		
		// Create lharris
		VPUser lharris = userRepo.findOne("lharris");
		if (lharris == null) {
			lharris = new VPUser();
			lharris.setId("lharris");
			lharris.setActive(true);
			lharris.setCredentials("1234");
			userRepo.save(lharris);
		}
		
		// Create kclayton
		VPUser kclayton = userRepo.findOne("kclayton");
		if (kclayton == null) {
			kclayton = new VPUser();
			kclayton.setId("kclayton");
			kclayton.setActive(true);
			kclayton.setCredentials("1234");
			userRepo.save(kclayton);
		}
	}
}

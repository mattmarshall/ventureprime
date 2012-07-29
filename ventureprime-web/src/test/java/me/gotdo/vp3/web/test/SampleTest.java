package me.gotdo.vp3.web.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.gotdo.vp3.web.model.Company;
import me.gotdo.vp3.web.model.Prize;
import me.gotdo.vp3.web.model.Survey;
import me.gotdo.vp3.web.model.TestLevel;
import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.CompanyRepository;
import me.gotdo.vp3.web.repository.PrizeRepository;
import me.gotdo.vp3.web.repository.SurveyRepository;
import me.gotdo.vp3.web.repository.TestLevelRepository;
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
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private PrizeRepository prizeRepo;
	
	@Autowired
	private TestLevelRepository testLevelRepo;

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
	public void canCreateUsers() {
		
		List<String> ventureRoles = new ArrayList<String>();
		ventureRoles.add("venture");
		
		List<String> primerRoles = new ArrayList<String>();
		primerRoles.add("primer");
		
		// Create mmarshall
		VPUser mmarshall = userRepo.findOne("mmarshall");
		if (mmarshall == null) {
			mmarshall = new VPUser();
			mmarshall.setId("mmarshall");
			mmarshall.setActive(true);
			mmarshall.setCredentials("1234");
		}
		mmarshall.setRoles(ventureRoles);
		userRepo.save(mmarshall);
		
		// Create lharris
		VPUser lharris = userRepo.findOne("lharris");
		if (lharris == null) {
			lharris = new VPUser();
			lharris.setId("lharris");
			lharris.setActive(true);
			lharris.setCredentials("1234");
		}
		lharris.setRoles(primerRoles);
		userRepo.save(lharris);
		
		// Create kclayton
		VPUser kclayton = userRepo.findOne("kclayton");
		if (kclayton == null) {
			kclayton = new VPUser();
			kclayton.setId("kclayton");
			kclayton.setActive(true);
			kclayton.setCredentials("1234");
		}
		kclayton.setRoles(ventureRoles);
		userRepo.save(kclayton);
		
		// Retrieve users
		mmarshall = userRepo.findOne("mmarshall");
		assertNotNull(mmarshall);
		assertNotNull(mmarshall.getId());
		assertNotNull(mmarshall.getCredentials());
		assertNotNull(mmarshall.getRoles());
		assertTrue(mmarshall.getRoles().contains("venture"));
		assertEquals("1234", mmarshall.getCredentials());
		assertTrue(mmarshall.isActive());
		
		// Retrieve users
		lharris = userRepo.findOne("lharris");
		assertNotNull(lharris);
		assertNotNull(lharris.getId());
		assertNotNull(lharris.getCredentials());
		assertNotNull(lharris.getRoles());
		assertTrue(lharris.getRoles().contains("primer"));
		assertEquals("1234", lharris.getCredentials());
		assertTrue(lharris.isActive());
		
		// Retrieve users
		kclayton = userRepo.findOne("kclayton");
		assertNotNull(kclayton);
		assertNotNull(kclayton.getId());
		assertNotNull(kclayton.getCredentials());
		assertNotNull(kclayton.getRoles());
		assertTrue(kclayton.getRoles().contains("venture"));
		assertEquals("1234", kclayton.getCredentials());
		assertTrue(kclayton.isActive());
	}
	
	@Test
	public void canCreateCompany() {
		
		/**
		 * Onswipe
		 * Sendgrid
		 * Captimo
		 * Lore
		 * GrowVC
		 */
		
		// Onswipe
		Company onswipe = companyRepo.findByName("Onswipe");
		if (onswipe == null) {
			onswipe = new Company();
			onswipe.setName("Onswipe");
		}
		companyRepo.save(onswipe);

		// Sendgrid
		Company sendgrid = companyRepo.findByName("Sendgrid");
		if (sendgrid == null) {
			sendgrid = new Company();
			sendgrid.setName("Sendgrid");
		}
		companyRepo.save(sendgrid);

		// Captimo
		Company captimo = companyRepo.findByName("Captimo");
		if (captimo == null) {
			captimo = new Company();
			captimo.setName("Captimo");
		}
		companyRepo.save(captimo);
		
		// Lore
		Company lore = companyRepo.findByName("Lore");
		if (lore == null) {
			lore = new Company();
			lore.setName("Lore");
		}
		companyRepo.save(lore);
		
		// GrowVC
		Company growvc = companyRepo.findByName("GrowVC");
		if (growvc == null) {
			growvc = new Company();
			growvc.setName("GrowVC");
		}
		companyRepo.save(growvc);
	}
	
	@Test
	public void canCreatePrizes()
	{
		// Beats by Dre Studio Headphones
		Prize beats = prizeRepo.findByName("Beats by Dre Studio Headphones");
		if (beats == null) {
			beats = new Prize();
			beats.setName("Beats by Dre Studio Headphones");
		}
		beats.setPoints(450);
		prizeRepo.save(beats);
		
		// 12 Issues Wired Magazine
		Prize wired = prizeRepo.findByName("12 Issues Wired Magazine");
		if (wired == null) {
			wired = new Prize();
			wired.setName("12 Issues Wired Magazine");
		}
		wired.setPoints(35);
		prizeRepo.save(wired);
		
		// $15 Chipotle Gift Card
		Prize chipotle = prizeRepo.findByName("$15 Chipotle Gift Card");
		if (chipotle == null) {
			chipotle = new Prize();
			chipotle.setName("$15 Chipotle Gift Card");
		}
		chipotle.setPoints(20);
		prizeRepo.save(chipotle);
		
		// Two Tickets to Disrupt NYC
		Prize disrupt = prizeRepo.findByName("Two Tickets to Disrupt NYC");
		if (disrupt == null) {
			disrupt = new Prize();
			disrupt.setName("Two Tickets to Disrupt NYC");
		}
		disrupt.setPoints(320);
		prizeRepo.save(disrupt);

		// Photoshop CS5 Extended
		Prize photoshop = prizeRepo.findByName("Photoshop CS5 Extended");
		if (photoshop == null) {
			photoshop = new Prize();
			photoshop.setName("Photoshop CS5 Extended");
		}
		photoshop.setPoints(900);
		prizeRepo.save(photoshop);
		
		// $20 xkcd Store Gift Card
		Prize xkcd = prizeRepo.findByName("$20 xkcd Store Gift Card");
		if (xkcd == null) {
			xkcd = new Prize();
			xkcd.setName("$20 xkcd Store Gift Card");
		}
		xkcd.setPoints(25);
		prizeRepo.save(xkcd);
		
		// 50% off One Day Bike Rental
		Prize bike = prizeRepo.findByName("50% off One Day Bike Rental");
		if (bike == null) {
			bike = new Prize();
			bike.setName("50% off One Day Bike Rental");
		}
		bike.setPoints(10);
		prizeRepo.save(bike);
		
		// Speedcam Radar Detector
		Prize radar = prizeRepo.findByName("Speedcam Radar Detector");
		if (radar == null) {
			radar = new Prize();
			radar.setName("Speedcam Radar Detector");
		}
		radar.setPoints(80);
		prizeRepo.save(radar);
		
		// 40% off One General Assembly Event
		Prize ga = prizeRepo.findByName("40% off One General Assembly Event");
		if (ga == null) {
			ga = new Prize();
			ga.setName("40% off One General Assembly Event");
		}
		ga.setPoints(15);
		prizeRepo.save(ga);

		// Xbox 360 Slim 4GB Kinect 2
		Prize xbox = prizeRepo.findByName("Xbox 360 Slim 4GB Kinect 2");
		if (xbox == null) {
			xbox = new Prize();
			xbox.setName("Xbox 360 Slim 4GB Kinect 2");
		}
		xbox.setPoints(240);
		prizeRepo.save(xbox);

		// Two Tickets to TED Conference
		Prize ted = prizeRepo.findByName("Two Tickets to TED Conference");
		if (ted == null) {
			ted = new Prize();
			ted.setName("Two Tickets to TED Conference");
		}
		ted.setPoints(170);
		prizeRepo.save(ted);

		// $30 Best Buy Gift Card
		Prize bestbuy = prizeRepo.findByName("$30 Best Buy Gift Card");
		if (bestbuy == null) {
			bestbuy = new Prize();
			bestbuy.setName("$30 Best Buy Gift Card");
		}
		bestbuy.setPoints(50);
		prizeRepo.save(bestbuy);
	}
	
	@Test
	public void canCreateTestLevels() {
		
		TestLevel level = null;
		
		// Level 1
		level = testLevelRepo.findByFriendlyName("Level 1");
		if (level == null) {
			level = new TestLevel();
			level.setFriendlyName("Level 1");
			level.setDescription("Description 1");
			level.setPrice(0);
			testLevelRepo.save(level);
		}
		
		// Level 2
		level = testLevelRepo.findByFriendlyName("Level 2");
		if (level == null) {
			level = new TestLevel();
			level.setFriendlyName("Level 2");
			level.setDescription("Description 2");
			level.setPrice(50);
			testLevelRepo.save(level);
		}
		
		// Level 3
		level = testLevelRepo.findByFriendlyName("Level 3");
		if (level == null) {
			level = new TestLevel();
			level.setFriendlyName("Level 3");
			level.setDescription("Description 3");
			level.setPrice(150);
			testLevelRepo.save(level);
		}
		
		// Level 4
		level = testLevelRepo.findByFriendlyName("Level 4");
		if (level == null) {
			level = new TestLevel();
			level.setFriendlyName("Level 4");
			level.setDescription("Description 4");
			level.setPrice(300);
			testLevelRepo.save(level);
		}
		
		// Level 5
		level = testLevelRepo.findByFriendlyName("Level 5");
		if (level == null) {
			level = new TestLevel();
			level.setFriendlyName("Level 5");
			level.setDescription("Description 5");
			level.setPrice(500);
			testLevelRepo.save(level);
		}
	}
}

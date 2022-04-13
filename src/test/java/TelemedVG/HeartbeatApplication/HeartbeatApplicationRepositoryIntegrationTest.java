package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;

import TelemedVG.HeartbeatApplication.model.AppUser;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@Log
public class HeartbeatApplicationRepositoryIntegrationTest {

    @Autowired
    HealthRecordRepository healthRecordRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Test
    public void testFindUserByID() {
        log.info("Test FindByID executing.");

        //given
        Date startTest = new Date();
        AppUser newUser = new AppUser();
        newUser.setDateOfBirth(startTest);
        appUserRepository.save(newUser);

        // when
        AppUser foundUser = appUserRepository.findById(newUser.getId());

        // then
        Assert.assertEquals(foundUser.getDateOfBirth().getTime(), startTest.getTime());
    }

    @Test
    public void testFindRecordByHeartBeat() {
        log.info("Test FindByHeartBeat executing.");

        //given
        Date startTest = new Date();
        HealthRecord newRecord = new HealthRecord(150);
        newRecord.setDateOfInput(startTest);
        healthRecordRepository.save(newRecord);

        // when
        HealthRecord foundRecord = healthRecordRepository.findByHeartBeat(150);

        // then
        Assert.assertEquals(foundRecord.getDateOfInput().getTime(), startTest.getTime());
    }
}

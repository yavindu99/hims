package hims.patunscal.clinic.patient_history;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientHistoryServiceImplTest {

    @Autowired
    private PatientHistoryServiceInt service;

    @Test
    public void add() {

        PatientHistory history = new PatientHistory();
        history.setVisitId("0001");

        //Mockito.when(repo.save(history)).thenReturn(history);

        assertEquals(history,service.add(history).getEntityBody());


    }
}
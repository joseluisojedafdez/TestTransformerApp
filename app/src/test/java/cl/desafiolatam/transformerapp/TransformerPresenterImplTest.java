package cl.desafiolatam.transformerapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TransformerPresenterImplTest {

    private final Calendar calendarDate = Calendar.getInstance(TimeZone.getTimeZone( "UTC" ));

    @Mock
    private TransformerView view;
    private TransformerPresenter presenter;

    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        presenter=new TransformerPresenterImpl();
        presenter.setView(view);
        calendarDate.set( 2019 , 2 , 28 );

    }

    @Test
    public void setDate_defaultDate() {
        presenter.setDate(calendarDate.getTime().getTime());
        Mockito.verify(view, Mockito.times(1)).showDateResult();
        Assert.assertEquals("jueves, marzo 28, 2019",presenter.getStringDate());
    }
    @Test
    public void setDate_null() {
      Mockito.verify(view, Mockito.never()).showDateResult();
      Assert.assertNull(presenter.getStringDate());
    }

    @Test
    public void getStringDate_defaultDate() {
        presenter.setDate(calendarDate.getTime().getTime());
        Assert.assertEquals("jueves, marzo 28, 2019",presenter.getStringDate());

    }
    @Test
    public void getStringDate_null() {
        // lo vemos despues
    }

    @Test
    public void getDaysOnly_defaultDate() {
        presenter.setDate(calendarDate.getTime().getTime());
        Assert.assertEquals("Día del mes: 28",presenter.getDaysOnly());

    }
    @Test
    public void getDaysOnly_null() {
        presenter.setDate(null);
        Assert.assertEquals("Día del mes: ",presenter.getDaysOnly());

    }


    @Test
    public void getWeeksOnly() {
    }

    @Test
    public void getTimeStamp() {
    }

    @Test
    public void getDateFormatOne() {
    }

    @Test
    public void getDateFormatTwo() {
    }

    @Test
    public void getDateFormatThree() {
    }

    @Test
    public void getDateFormatFour() {
    }
}
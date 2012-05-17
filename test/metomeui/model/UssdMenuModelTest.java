package metomeui.model;

import metomeui.model.UssdPredefInput;
import junit.framework.TestCase;

public class UssdMenuModelTest extends TestCase {

    private UssdPredefInput ussdPredefInput;

    protected void setUp() throws Exception {
    	ussdPredefInput = new UssdPredefInput();
    }

    public void testSetAndGetPredefInputId() {
        Integer testPredefInputId = 1;
        assertNull(ussdPredefInput.getPredefInputId());
        ussdPredefInput.setPredefInputId(testPredefInputId);
        assertEquals(testPredefInputId, ussdPredefInput.getPredefInputId());
    }
    
    public void testSetAndGetPredefInputName() {
        String testPredefInputName = "testpredefinput";
        assertNull(ussdPredefInput.getPredefInputName());
        ussdPredefInput.setPredefInputName(testPredefInputName);
        assertEquals(testPredefInputName, ussdPredefInput.getPredefInputName());
    }
    
    public void testSetAndGetPredefInputDesc() {
        String testPredefInputDesc = "testpredefinputDesc";
        assertNull(ussdPredefInput.getPredefInputDescription());
        ussdPredefInput.setPredefInputDescription(testPredefInputDesc);
        assertEquals(testPredefInputDesc, ussdPredefInput.getPredefInputDescription());
    }
  
}
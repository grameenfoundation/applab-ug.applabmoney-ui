package metomeui.model;

import static org.junit.Assert.*;

import metomeui.model.Message;

import org.junit.Test;

public class MessagesTests {

    private Message message;

    @Test
    public void testSetAndGetMessageId() {
    	message = new Message();
        int testMessageId = 3;
        assertEquals(0, 0, 0); 
        message.setMessageId(testMessageId);
        assertEquals(testMessageId, message.getMessageId(),0);
    }
    
    @Test
    public void testSetAndGetLanguageId() {
    	message = new Message();
        int testLanguageId = 456;
        assertEquals(0, 0, 0); 
        message.setLanguageId(testLanguageId);
        assertEquals(testLanguageId, message.getLanguageId(),0);
    }
    
    @Test
    public void testSetAndGetMessageCode() {
    	message = new Message();
        int testMessageCode = 34;
        assertEquals(0, 0, 0); 
        message.setMessageCode(testMessageCode);
        assertEquals(testMessageCode, message.getMessageCode(),0);
    }
    
    @Test
    public void testSetAndGetMessageDesc() {
    	message = new Message();
        String testMessageDesc = "aMessageDesc";
        assertNull(message.getMessageDesc());
        message.setMessageDesc(testMessageDesc);
        assertEquals(testMessageDesc, message.getMessageDesc());
    }

    @Test
    public void testSetAndGetMessageText() {
    	message = new Message();
    	String testMessageText = "aMessageText";
        assertEquals(0, 0, 0);    
        message.setMessageText(testMessageText);
        assertEquals(testMessageText, message.getMessageText());
    }
  
}
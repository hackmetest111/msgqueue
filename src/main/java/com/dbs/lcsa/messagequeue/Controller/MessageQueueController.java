package com.dbs.lcsa.messagequeue.Controller;
import com.dbs.lcsa.messagequeue.Model.QueueDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

@CrossOrigin
@RestController
@RequestMapping(value="api/getmessagequeue",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageQueueController {
  @GetMapping("/getAllQueue")
public List<QueueDetails> getQueueDetails()
    {
        List<QueueDetails> lstqueue=new ArrayList<>();
        lstqueue.add(new QueueDetails(1,"test"));
        return lstqueue;
    }
    @PostMapping("/addMessages")
    public void pushMessage(@RequestParam(name = "id") Integer queueId, @RequestParam String message)
    {
        LinkedTransferQueue<String> messagequeue=new LinkedTransferQueue<>();
        messagequeue.put(message);
        Map<Integer,LinkedTransferQueue<String>> messages=new HashMap<>();
        messages.put(queueId,messagequeue);

    }
    @GetMapping("/getAllMessages")
    public List<String> getAllMessages(){
    	/*ArrayList<QueueDetails> queueDetails = new ArrayList<QueueDetails>();
    	queueDetails.add(new QueueDetails(1, "sample1"));
    	queueDetails.add(new QueueDetails(1, "sample2"));
    	
    	List<String>
    	for (QueueDetails queueDetails2 : queueDetails) {
			
		}*/
    	  List<String> lstqueue=new ArrayList<String>();
          lstqueue.add("sample1");
          lstqueue.add("sample2");
          return lstqueue;
    }
    


}

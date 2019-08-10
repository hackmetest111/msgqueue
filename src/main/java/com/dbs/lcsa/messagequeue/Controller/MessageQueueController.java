package com.dbs.lcsa.messagequeue.Controller;
import com.dbs.lcsa.messagequeue.Model.MessageDetails;
import com.dbs.lcsa.messagequeue.Model.QueueDetails;
import com.dbs.lcsa.messagequeue.Service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value="api/getmessagequeue",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageQueueController {
    @Autowired
    QueueService queueService;
    static List<MessageDetails> msgdetails=new ArrayList<>();

  @GetMapping("/getAllQueue")
public ResponseEntity<?> getQueueDetails()
    {
        List<QueueDetails> lstqueue=new ArrayList<>();
        lstqueue.add(new QueueDetails(1,"test"));
        return new ResponseEntity<>(
                lstqueue,
                HttpStatus.OK);
    }
    @PostMapping("/addMessages")
    public ResponseEntity<?> pushMessage(@RequestParam(name="queueId") String queueId, @RequestParam(name="message") String message)
    {
        try {
            LinkedTransferQueue<String> messagequeue = new LinkedTransferQueue<String>();

            messagequeue.put(message);
            Map<Integer, LinkedTransferQueue<String>> messages = new HashMap<>();
            messages.put(Integer.parseInt(queueId), messagequeue);
            if(msgdetails.size()>0) {
                MessageDetails msg = msgdetails.stream().max(Comparator.comparing(v -> v.getMessageId())).get();
                msgdetails.add(new MessageDetails(Integer.parseInt(queueId), msg.getMessageId() + 1, message));
            }
            else {
                msgdetails.add(new MessageDetails(Integer.parseInt(queueId), 1 , message));
            }
                return new ResponseEntity<>(
                        "Added Message Successfully",
                        HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(
                    "Error While adding Messages",
                    HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PostMapping("/deleteMessage/{queueId}/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable(name = "queueId") Integer queueId, @PathVariable Integer messageId)
    {
        try {
            Map<Integer, LinkedTransferQueue<String>> messagequeue = new HashMap<>();
            LinkedTransferQueue<String> lstmessagequeue = new LinkedTransferQueue<>();
            for (Map.Entry<Integer, LinkedTransferQueue<String>> entry : messagequeue.entrySet()) {
                if (entry.getKey() == queueId) {
                    lstmessagequeue = entry.getValue();
                }
            }
            List<String> lstmessagedetails = queueService.getMessages().stream().filter(id -> id.getMessageId() == messageId).map(MessageDetails::getMessageName).collect(Collectors.toList());
            if(lstmessagequeue.size()<=0) {
                lstmessagequeue.remove(lstmessagedetails);


        MessageDetails messageDetails=new MessageDetails();
                for(MessageDetails item:msgdetails)
                {
                    if(item.getMessageId()==messageId)
                    {
                        messageDetails=item;
                    }
                }
msgdetails.remove(messageDetails);
                return new ResponseEntity<>(
                        "Deleted Message Successfully",
                        HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(
                        "Message Queue is Empty",
                        HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(
                    "Error While deleting Messages",
                    HttpStatus.EXPECTATION_FAILED);
        }

    }
    @GetMapping("/getAllMessages/{id}")
    public ResponseEntity<?> getMessageDetails(@PathVariable int id)
    {
       List<MessageDetails> lstmessagedetails=new ArrayList<>();
       lstmessagedetails=msgdetails.stream().filter(i -> i.getMessageId()==id).collect(Collectors.toList());
        return new ResponseEntity<>(
                lstmessagedetails,
                HttpStatus.OK);
    }


}

package com.dbs.lcsa.messagequeue.Service;

import com.dbs.lcsa.messagequeue.Model.MessageDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueService {

    public List<MessageDetails> getMessages()
    {
       List<MessageDetails> msgdetails=new ArrayList<>();
       msgdetails.add(new MessageDetails(1,1,"test Message"));
       msgdetails.add(new MessageDetails(1,2,"Hackathon"));
       return msgdetails;
    }
}

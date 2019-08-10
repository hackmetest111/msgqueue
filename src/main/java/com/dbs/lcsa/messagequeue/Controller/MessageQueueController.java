package ccom.dbs.lcsa.messagequeue.Controller;

import com.dbs.consumer.consumerdesk.Model.Consumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@RestController
@RequestMapping(value="api/getmessagequeue",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageQueueController {



}

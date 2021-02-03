package werth.matt.SimpleSpring.service;

import org.springframework.stereotype.Service;
import werth.matt.SimpleSpring.model.Person;
import werth.matt.SimpleSpring.model.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This is where we create / get all of the data to send over to the controller.

@Service     //business service, typically singleton, needed for Dependency Injection
public class TopicService {

    // This is some data we created so that it can be shared.
    // It will only be created once, singleton.
    List<Topic> topics = new ArrayList<>(Arrays.asList(  //creates new Topic and sends it to the url
            new Topic("spring", "Spring Framework", "A Set Of Tools To Develop On The Web."),
            new Topic("spring-boot", "Spring Boot", "Allows Us To Quickly Create RESTful Web Apps!")
    ));

    //this is the get method to return all topics to the controller.
    public List<Topic> getAllTopics() {
        return topics;
    }

    //this is the method to return a single topic
    public Topic getTopic(String id) {
        return topics.stream().filter(top -> top.getId().equals(id))
                              .findFirst()
                              .get();
    }

    public void addTopic(Topic topic) { // takes in our http object and adds it to the topic arrayList
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(int i = 0; i < topics.size(); i++) {
            Topic top = topics.get(i);
            if(top.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(per -> per.getId().equals(id));
    }
}

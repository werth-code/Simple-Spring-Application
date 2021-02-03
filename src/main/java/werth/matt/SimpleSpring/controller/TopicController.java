package werth.matt.SimpleSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import werth.matt.SimpleSpring.model.Topic;
import werth.matt.SimpleSpring.service.TopicService;

import java.util.List;

@RestController
public class TopicController {

    // the controller does the actual mapping. We get the data from the service.

    @Autowired // marks this as something which needs dependency injection
    private TopicService topicService;

    @GetMapping("/topics") // when annotating with @RestController data is returned as JSON
    public List<Topic> getTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}") //allows us to get whatever we pass in to the url
    public Topic getTopic(@PathVariable String id) { //using path variable..
        return topicService.getTopic(id);
    }

    @PostMapping("/topics") // when a post req comes in at this url..
    public void addTopic(@RequestBody Topic topic) { // tells spring that we will be receiving a JSON version of our object
        topicService.addTopic(topic); // call on our TopicService to add it to the arrayList
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}") //allows us to delete whatever we pass into the url
    public void deleteTopic(@PathVariable String id) { //using path variable..
        topicService.deleteTopic(id);
    }
}

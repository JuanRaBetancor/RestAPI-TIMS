package es.cicei.ulpgc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MainApplicationController {

    private List<DisruptionEntity> disruptions = new ArrayList<DisruptionEntity>(){};
    private List<TweetsEntity> tweets = new ArrayList<TweetsEntity>();

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homepage");
        return mav;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<List<DisruptionEntity>> getJson(@RequestBody List<DisruptionEntity> disruptions) {
        this.disruptions = disruptions;
        return new ResponseEntity<List<DisruptionEntity>>(disruptions, HttpStatus.OK);
    }

    @RequestMapping(value = "/tweets", method = RequestMethod.POST)
    public ResponseEntity<TweetsEntity> getJsonTweet(@RequestBody TweetsEntity tweet) {
        this.tweets.add(0, tweet);
        if(this.tweets.size() > 15){
            this.tweets = this.tweets.subList(0,15);
        }
        return new ResponseEntity<TweetsEntity>(tweet,HttpStatus.OK);
    }

    @RequestMapping("/disruptions")
    public ModelAndView renderIndex() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("disruptions", this.disruptions);
        mav.addObject("tweets", this.tweets);
        mav.setViewName("index");
        return mav;
    }


}

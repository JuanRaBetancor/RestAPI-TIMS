package es.cicei.ulpgc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainApplicationController {

    @Autowired
    private DisruptionRepository disruptionRepository;
    @Autowired
    private TweetsRepository tweetsRepository;

    private List<DisruptionEntity> disruptions = new ArrayList<DisruptionEntity>(){};
    private List<TweetsEntity> tweets = new ArrayList<TweetsEntity>();

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homepage");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<List<DisruptionEntity>> getJson(@RequestBody List<DisruptionEntity> disruptions) {
        //this.disruptions = disruptions;
        disruptionRepository.deleteAll();
        for (int i = 0; i < disruptions.size(); i++) {
            disruptionRepository.save(disruptions.get(i));
        }
        return new ResponseEntity<List<DisruptionEntity>>(disruptions, HttpStatus.OK);
    }

    @RequestMapping(value = "/tweets", method = RequestMethod.POST)
    public ResponseEntity<TweetsEntity> getJsonTweet(@RequestBody TweetsEntity tweet) {
        this.tweets = tweetsRepository.findAll();
        this.tweets.add(0, tweet);
        if(this.tweets.size() > 15){
            this.tweets = this.tweets.subList(0,15);
        }
        tweetsRepository.deleteAll();
        for (int i = 0; i < this.tweets.size(); i++){
            tweetsRepository.save(this.tweets.get(i));
        }
        return new ResponseEntity<TweetsEntity>(tweet,HttpStatus.OK);
    }

    @RequestMapping("/disruptions")
    public ModelAndView renderIndex() {
        List<DisruptionEntity> disruptions = disruptionRepository.findAll();
        List<TweetsEntity> tweets = tweetsRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("disruptions", disruptions);
        mav.addObject("tweets", tweets);
        mav.setViewName("index");
        return mav;
    }


}

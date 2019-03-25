package es.cicei.ulpgc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@RestController
public class MainApplicationController {

    private List<DisruptionEntity> disruptions;

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

    @RequestMapping("/disruptions")
    public ModelAndView renderIndex() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("disruptions", this.disruptions);
        mav.setViewName("index");
        return mav;
    }


}

package com.purepurr.apiservice.controller;

import com.purepurr.apiservice.model.Video;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/glasses")
public class GlassesController {

    /** curl -X GET 'http://localhost:9696/glasses/verify' -F rooted=true -F dateExpiration=1 -F counter=1 -F datePayment=1 */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verify(
            @RequestParam Long datePayment,
            @RequestParam Long dateExpiration,
            @RequestParam Integer counter,
            @RequestParam Boolean rooted
    ) {
        Video v = new Video("testname", 1);
        v.save();
        return "hello";
    }

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public String download() {
        return "TODO: RETURN FROM FILE-SERVICE";
    }
}

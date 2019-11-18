package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String PORT;
    String MEMORY_LIMIT;
    String CF_INSTANCE_INDEX;
    String CF_INSTANCE_ADDR;

    public EnvController(@Value("${port:NOT SET}")String port, @Value("${memory:NOT SET}") String memory,
                         @Value("${cf.instance.index:NOT SET}")String cf_index,
                         @Value("${cf.instance.addr:NOT SET}")String cf_addr) {
        this.PORT = port;
        this.MEMORY_LIMIT = memory;
        this.CF_INSTANCE_INDEX = cf_index;
        this.CF_INSTANCE_ADDR = cf_addr;
    }



    @GetMapping("/env")
   public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap<>();

        env.put("PORT", PORT);
        env.put("MEMORY_LIMIT", MEMORY_LIMIT);
        env.put("CF_INSTANCE_INDEX", CF_INSTANCE_INDEX);
        env.put("CF_INSTANCE_ADDR", CF_INSTANCE_ADDR);


        return env;
    }


}

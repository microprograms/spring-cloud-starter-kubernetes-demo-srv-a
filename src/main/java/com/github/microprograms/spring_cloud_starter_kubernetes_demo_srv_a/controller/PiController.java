package com.github.microprograms.spring_cloud_starter_kubernetes_demo_srv_a.controller;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.spring_cloud_starter_kubernetes_demo_srv_a.utils.Pi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pi")
public class PiController {
    private static final Logger log = LoggerFactory.getLogger(PiController.class);

    @RequestMapping("/gridPi")
    public String gridPi(Integer n) {
        if (null == n) {
            n = 999999999;
        }
        log.info("gridPi, n={}, calc...", n);
        Map<String, Object> map = new HashMap<>();
        map.put("start", System.currentTimeMillis());
        map.put("pi", Pi.grid_pi(n));
        map.put("n", n);
        map.put("end", System.currentTimeMillis());
        map.put("cost", (long) map.get("end") - (long) map.get("start"));
        log.info("gridPi, n={}, result={}", n, JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

}

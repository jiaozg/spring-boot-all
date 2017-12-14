package com.example.demo.web;

import com.example.demo.util.ServerInfoFormMap;
import com.example.demo.util.SystemInfo;
import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiaozhiguang on 2017/12/13.
 */
@Controller
public class SystemController {

//    @RequestMapping("/systemInfo")
//    public Model systemInfo(Model model) throws Exception {
//        model.addAttribute("systemInfo", SystemInfo.SystemProperty());
//        return Common.BACKGROUND_PATH + "/system/monitor/systemInfo";
//    }

    @GetMapping("/systemInfoApi")
    @ResponseBody
    public ServerInfoFormMap systemInfoApi() {
        return SystemInfo.SystemProperty();
    }

    @GetMapping("/memory")
    @ResponseBody
    public ServerInfoFormMap memory() {
        return SystemInfo.memory(new Sigar());
    }

    @GetMapping("/usage")
    @ResponseBody
    public ServerInfoFormMap usage() {
        return SystemInfo.usage(new Sigar());
    }

    @GetMapping("/systemInfo")
    public String getSystemInfo(Model model) {
        model.addAttribute("systemInfo", SystemInfo.SystemProperty());
        return "system_info";
    }


}

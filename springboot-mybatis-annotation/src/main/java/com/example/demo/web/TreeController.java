package com.example.demo.web;

import com.example.demo.entity.SysAreaEntity;
import com.example.demo.form.AreaTree;
import com.example.demo.mapper.SysAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/18.
 */
@Controller
public class TreeController {

    @Autowired
    private SysAreaMapper sysAreaMapper;

    @GetMapping("/totree")
    public String totree() {
        return "ztree";
    }

    @GetMapping("/totreeAsync")
    public String totreeAsync() {
        return "ztreeAsync";
    }

    @GetMapping("/ptree")
    @ResponseBody
    public List<AreaTree> ptree(Long id) {
        return sysAreaMapper.getAreaTreeByPid(0L);
    }

    @PostMapping("/getByPid")
    @ResponseBody
    public List<AreaTree> getByPid(Long pid) {
        return sysAreaMapper.getAreaTreeByPid(pid);
    }

    @PostMapping("/updateName")
    @ResponseBody
    public void updateName(Long id, String name) {
        sysAreaMapper.updateName(new SysAreaEntity(id.toString(), name));
    }


    @GetMapping("/tree")
    @ResponseBody
    public List<AreaTree> tree() {

        List<AreaTree> areaTrees = sysAreaMapper.getAreaTreeByPid(0L);

        for (AreaTree areaTree : areaTrees) {
            recursive(areaTree);
        }
        return areaTrees;
    }

    private void recursive(AreaTree areaTree) {

        List<AreaTree> areaTrees = sysAreaMapper.getAreaTreeByPid(areaTree.getId());
        areaTree.setChildren(areaTrees);
        for (AreaTree tree : areaTrees) {
            recursive(tree);
        }

    }


}

package com.example.bitcoin.controller;

import com.example.bitcoin.dto.RsiDTO;
import com.example.bitcoin.dto.RsiDTO;
import com.example.bitcoin.service.GetRsiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;


@Slf4j
@Controller
public class GetRsiController {

    @Autowired
    GetRsiService getRsiService;

    //RSI 값 insert
    @RequestMapping("/GetRsiController.getrsiSummary.do")
//    @ResponseBody
    public String getRsiSummary(Model model) throws IOException, ParseException, NoSuchAlgorithmException {
        getRsiService.getRsiSummary();
        return "redirect:/";
    }

    //메인화면 RSI 조회
    @GetMapping("/")
    public String showRsiSummary(Model model) {
        List<RsiDTO> rsiList = getRsiService.getRsi();
        model.addAttribute("rsiList", rsiList);
        return "rsiSummary";
    }
}

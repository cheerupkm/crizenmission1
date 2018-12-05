package com.crizen.mission;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mission1Cont {

  public mission1Cont() {
    System.out.println("---mission1Cont() 객체 생성");
  }//기본 생성자
  
  //결과확인 http://localhost:8080/mission1/watch.do
  
  @RequestMapping(value="/watch.do", method=RequestMethod.GET)
  public ModelAndView watchForm() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("watchForm");
    return mav;
  }//watchForm() end
  
  @RequestMapping(value = "/timer.do", method = RequestMethod.GET)
  public void watchView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try {
      resp.setContentType("text/plain; charset=UTF-8");
      PrintWriter out = resp.getWriter(); //출력객체
      
      //시간 구하기
      //출력결과 : 현재 시간은  YYYY-MM-dd HH24:mm:ss  입니다.
      Calendar cal = Calendar.getInstance();
      Date date = cal.getTime();
      String today = (new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date));

      out.println(today);
      out.flush();
      out.close(); //자원반납
    } catch (Exception e) {
      System.out.println("실패 : " + e);
    }
  }//watchView() end

}//class end
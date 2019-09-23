package com.example.web; //包名

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;


public class BeerSelect extends HttpServlet{ //继承了HttpServlet

    public void doPost(HttpServletRequest request,
                        HttpServletResponse response) 
                            throws IOException, ServletException{ 
        
        String c = request.getParameter("color"); //获取请求中的color属性
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Beer Selection Advice <br>");
        
        Iterator it = result.iterator();
        while(it.hasNext()) {
            out.print("<br> try: " + it.next());
        }
   
    }
}
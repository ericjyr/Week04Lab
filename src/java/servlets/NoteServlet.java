/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author ericr
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();
        br.close();
        
        Note note = new Note(title, content);   
        request.setAttribute("note", note);

        String page = request.getParameter("page");
        
        String jspPath =  page == null ? "/WEB-INF/viewnote.jsp" 
                                       : "/WEB-INF/editnote.jsp";
        
        getServletContext().getRequestDispatcher(jspPath)
            .forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(path, false))); 
        
        pw.println(title);
        pw.print(content);
        pw.close();

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp" )
            .forward(request, response);
    }



}


import mysql.animals.Animal;
import mysql.animals.AnimalDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Animal animal = AnimalDB.selectOne(id);
            if (animal!=null){
                request.setAttribute("animal",animal);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request,response);
            }else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request,response);
            }
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String animalName = request.getParameter("AnimalName");
            String animalType = request.getParameter("AnimalType");
            String animalColor = request.getParameter("AnimalColor");
            int animalAge = Integer.parseInt(request.getParameter("AnimalAge"));
            String animalHost = request.getParameter("AnimalHost");
            Animal animal = new Animal(id,animalName,animalType,animalColor,animalAge,animalHost);
            AnimalDB.update(animal);
            response.sendRedirect(request.getContextPath()+"/index");
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request,response);
        }
    }
}
import mysql.animals.Animal;
import mysql.animals.AnimalDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    String index = "/index";
    boolean isAnimal = true;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            String animalName = request.getParameter("AnimalName");
            String animalType = request.getParameter("AnimalType");
            String animalColor = request.getParameter("AnimalColor");
            int animalAge = Integer.parseInt(request.getParameter("AnimalAge"));
            String animalHost = request.getParameter("AnimalHost");
            Animal animal = new Animal(animalName,animalType,animalColor,animalAge,animalHost);
            /////////////////////////////////////////////
            if (animalType.equals("Teapot")){
            index = "/teapot.jsp";
            isAnimal = false;
            }
            ////////////////////////////////////////////////////
            if (isAnimal == true){
                AnimalDB.insert(animal);
            }
            response.sendRedirect(request.getContextPath()+ index);
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/create.jsp").forward(request,response);
        }
    }
}
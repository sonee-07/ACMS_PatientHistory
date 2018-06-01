package main;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginHandlerServlet")
public class LoginHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doc1 = "01_dr_neha";
        String pass1 = "123";

        String doc2 = "10_dr_supan";
        String pass2 = "1234";

        String doc3 = "11_dr_sonya";
        String pass3 = "12345";

        String id = request.getParameter("login_id");

        String pass = request.getParameter("login_pass");
        String redirect = "/PatientForm_Nurse.jsp";

        request.setAttribute("doctor_id", id);

        if(id.equals(doc1) && pass.equals(pass1)){

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
            dispatcher.include(request, response);
        }
        else if(id.equals(doc2) && pass.equals(pass2)){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
            dispatcher.include(request, response);
        }

        else if(id.equals(doc3) && pass.equals(pass3)){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
            dispatcher.include(request, response);
        }
        else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.html");
            dispatcher.include(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

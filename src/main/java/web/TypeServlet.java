package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.ITypeDao;
import dao.TypeDaoImpl;
import metier.entities.Type;

@WebServlet(name = "typeServ", urlPatterns = { "/types", "/saisieType", "/saveType", "/supprimerType", "/editerType", "/updateType" })

public class TypeServlet extends HttpServlet {
    ITypeDao metier;

    @Override
    public void init() throws ServletException {
        metier = new TypeDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/types")) {
            TypeModele model = new TypeModele();
            List<Type> types = metier.getAllTypes();
            model.setTypes(types);
            request.setAttribute("model", model);
            request.getRequestDispatcher("types.jsp").forward(request, response);
        } else if (path.equals("/saisieType")) {
            request.getRequestDispatcher("saisieType.jsp").forward(request, response);
        } else if (path.equals("/saveType") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nom");
            Date dateT = new Date(); 
            Type type = metier.save(new Type(nom, dateT));
            request.setAttribute("types", type);
            response.sendRedirect("types");
        } else if (path.equals("/supprimerType")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteType(id);
            response.sendRedirect("types");
        } else if (path.equals("/editerType")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Type type = metier.getType(id);
            request.setAttribute("type", type);
            request.getRequestDispatcher("editerType.jsp").forward(request, response);
        } else if (path.equals("/updateType")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nom");
            Type type = new Type();
            type.setIdT(id);
            type.setNomT(nom);
            metier.updateType(type);
            response.sendRedirect("types");
        } else {
            response.sendError(Response.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

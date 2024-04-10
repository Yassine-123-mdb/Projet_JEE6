package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.ITypeDao;
import dao.ISmartPhoneDao;
import dao.TypeDaoImpl;
import dao.SmartPhoneDaoImpl;
import metier.entities.Type;
import metier.entities.SmartPhone;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ISmartPhoneDao smartPhoneDao;
    private ITypeDao typeDao;

    @Override
    public void init() throws ServletException {
        smartPhoneDao = new SmartPhoneDaoImpl();
        typeDao = new TypeDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("SmartPhones.jsp").forward(request, response);
        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            SmartPhoneModele model = new SmartPhoneModele();
            model.setMotCle(motCle);
            List<SmartPhone> smartPhones = smartPhoneDao.smartphonesParMC(motCle);
            model.setSmartPhones(smartPhones);
            request.setAttribute("model", model);
            request.getRequestDispatcher("SmartPhones.jsp").forward(request, response);
        } else if (path.equals("/saisie.do")) {
            List<Type> types = typeDao.getAllTypes();
            TypeModele model = new TypeModele();
            model.setTypes(types);
            request.setAttribute("typeModel", model);
            request.getRequestDispatcher("saisieSmartPhone.jsp").forward(request, response);
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String marque = request.getParameter("marque");
            String couleur = request.getParameter("couleur");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int ram = Integer.parseInt(request.getParameter("ram"));
            int stockage = Integer.parseInt(request.getParameter("stockage"));
            Long typeId = Long.parseLong(request.getParameter("type"));
            Type type = typeDao.getType(typeId);
            SmartPhone smartPhone = smartPhoneDao.save(new SmartPhone(marque, couleur, prix, ram, stockage, type));
            request.setAttribute("smartPhone", smartPhone);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            smartPhoneDao.deleteSmartPhone(id);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            SmartPhone smartPhone = smartPhoneDao.getSmartPhone(id);
            request.setAttribute("smartPhone", smartPhone);
            List<Type> types = typeDao.getAllTypes();
            TypeModele model = new TypeModele();
            model.setTypes(types);
            request.setAttribute("typeModel", model);
            request.getRequestDispatcher("editerSmartPhone.jsp").forward(request, response);
        } else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String marque = request.getParameter("marque");
            String couleur = request.getParameter("couleur");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int ram = Integer.parseInt(request.getParameter("ram"));
            int stockage = Integer.parseInt(request.getParameter("stockage"));
            Long typeId = Long.parseLong(request.getParameter("type"));
            SmartPhone smartPhone = new SmartPhone();
            smartPhone.setIdSmartPhone(id);
            smartPhone.setMarque(marque);
            smartPhone.setCouleur(couleur);
            smartPhone.setPrix(prix);
            smartPhone.setRam(ram);
            smartPhone.setStockage(stockage);
            Type type = typeDao.getType(typeId);
            smartPhone.setType(type);
            smartPhoneDao.updateSmartPhone(smartPhone);
            response.sendRedirect("chercher.do?motCle=");
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

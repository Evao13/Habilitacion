package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Flores;
import modeloDAO.FloresDAO;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String listar = "vistas/listar.jsp";
	String add = "vistas/add.jsp";
	String edit = "vistas/edit.jsp";
	Flores f = new Flores();
	FloresDAO dao= new FloresDAO();
	
	int id;
	public Controlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acceso = "";
		String action = request.getParameter("accion");
		if(action.equalsIgnoreCase("listar")) {
			acceso = listar;
		}else if(action.equalsIgnoreCase("add")) {
			acceso=add;
		}else if(action.equalsIgnoreCase("Agregar")){
			String nombre_f = request.getParameter("txtnombre");
			String s = request.getParameter("txtstock");
			String p = request.getParameter("txtvalor");
			int stock = Integer.parseInt(s);
			int precio = Integer.parseInt(p);
			f.setNombre_flor(nombre_f);;
			f.setStock(stock);;
			f.setValor_unidad(precio);
			dao.add(f);
			acceso = listar;
		}else if(action.equalsIgnoreCase("editar")) {
			request.setAttribute("idper", request.getParameter("id"));
			acceso = edit;
		}else if(action.equalsIgnoreCase("Actualizar")) {
			id = Integer.parseInt(request.getParameter("txtid"));
			String nombre_f = request.getParameter("txtnombre");
			String s = request.getParameter("txtstock");
			String p = request.getParameter("txtvalor");
			int stock = Integer.parseInt(s);
			int precio = Integer.parseInt(p);
			f.setId(id);
			f.setNombre_flor(nombre_f);
			f.setStock(stock);
			f.setValor_unidad(precio);
			f.getFecha_ingreso();
			dao.adit(f);
			acceso = listar;
		}else if(action.equalsIgnoreCase("eliminar")) {
			id = Integer.parseInt(request.getParameter("id"));
			f.setId(id);
			dao.eliminar(id);
			acceso = listar;
		}
		
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
